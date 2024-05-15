package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import Model.Database;
import Model.Operation;
import Model.User;


public class AddNewAccount implements Operation{

    private int accType;
    public AddNewAccount(int accType){
        this.accType = accType;
    }

    public void operation(Database database, Scanner s, User user){
         System.out.println("Enter First Name:");
         String firstName = s.next();
         System.out.println("Enter Last Name:");
         String lastName = s.next();
         System.out.println("Enter Email:");
         String email = s.next();
         System.out.println("Enter Phone Number:");
         String phoneNumber = s.next();
         System.out.println("Enter Password:");
         String password = s.next();
         System.out.println("Confirm Password:");
         String confirmPassword = s.next();
         while(!password.equals(confirmPassword)){
            System.out.println("Password doesn't match");
            System.out.println("Enter Password:");
            password = s.next();
            System.out.println("Confirm Password:");
            confirmPassword = s.next();
         }

          try{
            ResultSet rs = database.getStatement().executeQuery("SELECT COUNT(*);");
            rs.next();
            int ID = rs.getInt("COUNT(*)")-1;

            String insert = "INSERT INTO `users`(`ID`, `firstName`, `lastName`, `email`, `phoneNumber`, `password`, `Type`)" 
                            + "VALUES ('"+ID+"','"+firstName+"','"+lastName+"','"+email+"','"+phoneNumber+"','"+password+"','"+accType+"');";
            database.getStatement().execute(insert);
            System.out.println("Account created successfully");

          } catch(SQLException e){
                e.printStackTrace();
          }
    }

}
