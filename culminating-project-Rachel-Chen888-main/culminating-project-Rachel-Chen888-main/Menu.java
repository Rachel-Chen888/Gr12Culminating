import java.util.Scanner;

public class Menu {  
    //create Scanner object for user input  
    Scanner input = new Scanner(System.in); 

    //print out welcome and instructions messages for Start Menu 
    public void startMenu() {
        System.out.println("Welcome to the Grade Tracking App for teachers called Gradify!"); 
        System.out.println("Please read the instructions document that is linked below before using."); 
        System.out.println("https://docs.google.com/document/d/1LyGy4_X32GQbYGdPZNNJsMgKtI2ld_07rhQhvv7QiQI/edit?usp=sharing");   
    }

    //print out the choices of the different sub-menus and return user's choice   
    public int mainMenu() {
        System.out.println("\n\nWelcome to the Main Menu!"); 
        System.out.println("Enter 1 to go to the Course Menu"); 
        System.out.println("Enter 2 to go to the Student Menu"); 
        System.out.println("Enter -1 to quit this program (stop using this app)"); 
        return input.nextInt(); 
    }

    //print out the actions user can do in Course Menu and returns user's choice  
    public int courseMenu() {
        System.out.println("\n\nWelcome to the Course Menu!"); 
        System.out.println("Enter 1 to create a new course"); 
        System.out.println("Enter 2 to print the class list of a course"); 
        System.out.println("Enter 3 to print out the mark information of a course in percentages"); 
        return input.nextInt();  
    }

    //prints out the actions user can do in Student Menu and returns user's choice 
    public int studentMenu() {
        System.out.println("\n\nWelcome to the Student Menu!"); 
        System.out.println("Enter 1 to create a new student"); 
        System.out.println("Enter 2 to add a mark for a student"); 
        System.out.println("Enter 3 to get the mark of a student in percentage"); 
        System.out.println("Enter 4 to add a comment regarding a student"); 
        System.out.println("Enter 5 to print your comments you entered for a student"); 
        System.out.println("Enter 6 to print out the information of a student including their average mark in percentage");
        return input.nextInt();  
    }

    //prints out goodbye/thanks message to user for End Menu 
    public void endMenu() {
        System.out.println("\n\nThank you for using the Grade Tracking App for teachers called Gradify, I hope you enjoyed your experience!"); 
    } 
     
}