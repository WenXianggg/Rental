package Model;

import java.util.Scanner;

import Controller.AddNewAdmin;

public class Admin extends User{

    private Operation[] operations = new Operation[]{new AddNewAdmin()};
    
    public Admin(){
        super();
    }

    public void showList(Database database, Scanner s){
        System.out.println("\n. Add New Car");
        System.out.println("2. View Cars");
        System.out.println("3. Update Car");
        System.out.println("4. Delete Car");
        System.out.println("5. Add new Admin");
        System.out.println("6. Show Rents");
        System.out.println("Quit\n");

        int i = s.nextInt();
        operations[i].operation(database, s, this);
    }
}
