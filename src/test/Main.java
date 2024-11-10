package test;
import java.util.*;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        int choice;
        String name;
        Boolean b;
        int roll;
        Scanner sc = new Scanner(System.in);
        
        
        // Loop 
        while(true) {
        System.out.print("Enter choice: 1:- Add\t2:- Delete\t3:- Update\t4:- Show: ");
        choice = sc.nextInt();
        Student s = new Student();     
        String status = Db.connection();
        sc.nextLine(); 
        
        if(choice == 1) {        	
            System.out.println("Enter your roll-no: ");
            roll = sc.nextInt();
            s.setRoll(roll);
            sc.nextLine();
            System.out.println("Enter your name: ");
            name = sc.nextLine(); 
            s.setName(name);
            System.out.println("Enter your Bona-fide status: ");
            b = sc.nextBoolean();
            s.setB(b);
            String msg = Db.add(s);
            System.out.println(msg);
        } 
        else if(choice == 2) {
            // Code for delete
        	System.out.println("Enter your roll-no: ");
            roll = sc.nextInt();
            String m = Db.delete(roll);
            System.out.println(m);
        } 
        else if(choice == 3) {
            // Code for update
        	System.out.println("Enter your roll-no you want to update : ");
            roll = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter your name: ");
            name = sc.nextLine();  
            s.setName(name);
            System.out.println("Enter your Bona-fide status: ");
            b = sc.nextBoolean();
            s.setB(b);
            String m = Db.update(name, roll, b);
            System.out.println(m);
        } 
        else if(choice == 4) {
        	// Showing all records
        	Db.show();
        } 
        else {
            System.out.println("Invalid choice.");
            break;
        }
        }
        
    }
}
