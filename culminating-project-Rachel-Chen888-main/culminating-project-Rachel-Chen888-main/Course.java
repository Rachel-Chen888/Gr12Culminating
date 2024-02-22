import java.util.Scanner;

public class Course {
    String courseCode; 
    double averageMark; 
    double highestMark; 
    double lowestMark; 
    Student[] students = new Student[0]; 


    //this method is used when we create Course object 
    //it gets the value of courseCode defined above based on the parameter given to constructor 
    public Course(String courseCode) {
        this.courseCode = courseCode; 
    }


    //adds a new student into the students array for a specific course 
    public void addStudent(Student newStudent) {
        int oldLen = students.length; 

        //array that will store old students and new one 
        Student[] newStudents = new Student[oldLen+1]; 

        //loop through students array 
        for(int i = 0; i<oldLen; i++) {
            newStudents[i] = students[i]; //copy the old students into the new array 
        }

        newStudents[oldLen] = newStudent; //set last element to be the new student (append) 
        students = newStudents; //students now references the same array as newStudents
    } 


    //adds a new course into courses array 
    public static Course[] addCourse(Course[] courses, Course newCourse) {
        int oldLen = courses.length; 
        Course[] newCourses = new Course[oldLen+1]; //array that will store old courses and new one 

        //loop through courses array 
        for(int i = 0; i<oldLen; i++) {
            newCourses[i] = courses[i]; //copy the old courses into the new array 
        }

        newCourses[oldLen] = newCourse; //set last element to be the new course (append) 
        return newCourses; 
    } 
 

    //prints all the students in the class list  
    public void printStudents() {
        //if there are no students, let the user know 
        if (students.length == 0) { 
            System.out.println("This course has no students.");
        }
        else {
            //loop through each student and print out its name 
            for(Student s: students) {
                System.out.println(s.name);
            }
        } 
    }


    //prints the mark information for the course 
    public void printMarks() { 
        double currentMark; 
        averageMark = 0; 
        highestMark = 0; //no mark will be lower than 0% 
        lowestMark = 1000; //no mark will be higher than 1000% 

        //loop through each student 
        for(Student s: students) {
            //get their mark 
            currentMark = s.getMark();  
            //calculate the different marks 
            averageMark+=currentMark; 

            if (highestMark < currentMark) {
                highestMark = currentMark; 
            }
            //used if and not else if 
            //when there is only one student and used else if, highest mark = student's mark but lowest mark = 1000 which is wrong  
            if (lowestMark > currentMark) { 
                lowestMark = currentMark; 
            }
        }

        //calculate average mark
        averageMark /= students.length;  
        //print out the information calculated  
        System.out.println("Average Mark: " + averageMark + "\nHighest Mark: " + highestMark + "\nLowest Mark: " + lowestMark); 
    }


    //add new student into the student array 
    public void addStudent() { 
        Scanner input = new Scanner(System.in); 

        //Prompt and input the necessary information needed for a student 
        System.out.print("Enter the student's full name: "); 
        String studentName = input.nextLine();
        System.out.print("Enter the student's age: ");  
        int age = input.nextInt(); 
        System.out.print("Enter the student's grade: "); 
        int grade = input.nextInt(); 
        input.nextLine(); //clean up  
        System.out.print("Enter the student's email: "); 
        String email = input.nextLine(); 

        
        int oldLen = students.length; 
        Student[] newStudents = new Student[oldLen+1]; //array that will store old students and new one 

        for(int i = 0; i<oldLen; i++) {
            newStudents[i] = students[i]; //copy the old students into the new array 
        }

        //Create new student and add it to the newStudents array 
        newStudents[oldLen] = new Student(studentName, age, grade, email, courseCode); //set last element to be the new course (append)  
        
        //make sure course also stores this new student 
        students = newStudents;

        System.out.println("Student " + studentName + " has been successfully created");
    } 


    //finds the index of the course in the courses array with the same course code 
    public static int findCourse(Course[] courses, String courseName) {
        String currentName; 

        //loop through each course in the courses array 
        for(int i = 0; i<courses.length; i++) { 
            currentName = courses[i].courseCode;   

            //if the course codes match, return their index 
            if (currentName.equals(courseName)) {
                return i;  
            }
        }

        //course with the course code given does not exist 
        System.out.println("A course with the course code \"" + courseName + "\" does not exist, please create a course first or enter the correct course code. Redirecting to Main Menu."); 
        return -1; 
    }  


    //find the index of the student in students using the studentName 
    public int findStudent(String studentName) {
        String currentName; 

        //loop through students array 
        for(int i = 0; i<students.length; i++) {
            currentName = students[i].name;  

            //if the names match, return their index 
            if (currentName.equals(studentName)) {
                return i; 
            }
        }

        //if student does not exist, let user know 
        System.out.println("A student with the student name \"" + studentName + "\" does not exist, please create a student first or enter the correct student name. Redirecting to Main Menu.");  
        return -1; 
    } 
   
} 