package Controller;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import Model.Database;
import Model.Client;
import Model.Admin;
import Model.User;

public class Main {

    public static void main(String[] args) {
        Database database = new Database();
        Scanner s = new Scanner(System.in);

        System.out.println("Welcome to Car Rental System !");
        System.out.println("Enter your email:\n(-1) tp create new account");
        String email = s.next();
        System.out.println("Enter password:");
        String password = s.next();

        ArrayList<User> users = new ArrayList<>();

        try{
            String select = "SELECT * FROM `users`;";
            ResultSet rs = database.getStatement().executeQuery(select);
            while(rs.next()){
                User user;
                int ID = rs.getInt("ID");
                String firstName = rs.getString("FirstName");
                String LastName = rs.getString("LastName");
                String em = rs.getString("Email");
                String phoneNumber = rs.getString("PhoneNumber");
                String pass = rs.getString("Password");
                int type = rs.getInt("Type");
                switch(type){
                    case 0:
                        user = new Client();
                        break;
                    case 1:
                        user = new Admin();
                        break;
                    default:
                        user = new Client();
                        break;
                }
                user.setID(ID);
                user.setFirstNName(firstName);
                user.setLastName(LastName);
                user.setEmail(email);
                user.setPhoneNumber(phoneNumber);
                user.setPassword(password);
                users.add(user);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        for(User u:users){
            if(u.getEmail().equals(email) && u.getPassword().equals(password)){
                System.out.println("Welcome " +u.getFirstName()+"!");
                u.showList(database, s);
            }
        
        } 
    }  
}
