import java.util.Scanner; 

public class Student {  
    public String name;
    public int age; 
    public int grade; 
    public String email; 
    public double markSum = 0; 
    public double weightSum = 0; 
    public String course; 
    public String comments = ""; 

    //create Scanner object for user input 
    public Scanner input = new Scanner(System.in); 
    

    //this method is used when we create Student object 
    //it gets the values of the variablesbased on the parameters given to constructor 
    public Student(String name, int age, int grade, String email, String course) {
        this.name = name;  
        this.age = age; 
        this.grade = grade;  
        this.email = email; 
        this.course = course; 
    }



    //returns a string that contains the information of the Student object in a neat way 
    public String toString() {
        return ("Name: " + name + "\n\nAge: " + age + "\n\nGrade: " + grade + "\n\nEmail: " + email + "\n\nCourse: " + course + "\n\nAverage Mark: " + getMark() + "\n\nComments: " + getComments()); 
    }


    //add new mark for a student 
    public void addMark() {
        //Prompt and store necessary user input 
        System.out.print("Enter the mark in %: ");
        double mark = input.nextDouble(); 
        System.out.print("Enter the weight of that mark in decimals: "); 
        double weight = input.nextDouble();  
        input.nextLine(); //clean up 
                        
        //add the mark to total sum of all marks   
        markSum+=mark*weight; 
        //add the weight to total sum of all weights 
        weightSum+=weight; 
    }


    //calculate and return the student's average mark 
    public double getMark() {
        //if there is no weighting to their mark, that means their mark is just 0 (default value)   
        if (weightSum == 0) {
            return 0; 
        }
        //calculate their mark if there is a weight to it 
        return (markSum/weightSum);
    }


    //add a new comment for a student to the comment string to store it  
    public void addComment() { 
        System.out.print("Enter the comment: ");
        String comment = input.nextLine(); 
        comments+="\n"+comment; 
        System.out.println("Comment successfully added");
    }


    //return the comment string 
    public String getComments() {  
        //if there are no comments, return this information  
        if (comments.length() == 0) {
            return "\nNo comments at the moment"; 
        }

        //if there are comments, return the comments 
        return comments;   
    }
   
}  