import java.util.Scanner;  

public class Main {
    public static void main(String[] args) {
        
        //main method is used to create Student, Course, and Menu objects 

        //create Scanner object for user input 
        Scanner input = new Scanner(System.in); 

        //Create students array to store students array of a course object 
        Student[] students; 

        //Create courses array to keep track of all the Course objects the user creates 
        Course[] courses = new Course[0]; 
        
        //Create Menu object that can print out all the menus for our program 
        Menu menu = new Menu();  
        int menuInput = 0; //stores the user's choice of which menu they want to go to 
        int choice; //stores the user's choice of which activity they want to do in a menu 

        //stores student information 
        String studentName;  
        int studentIndex; 

        //stores course information 
        String courseCode;
        int courseIndex; 
        

        //Print start menu for user 
        menu.startMenu(); 


        //as long as user doesn't quit program (doesn't enter -1), keep running it  
        while(menuInput != -1) {  
            menuInput = menu.mainMenu(); //print the Main Menu for user 
            

            //if user picks to go to the Course Menu 
            if (menuInput == 1) { 
                choice = menu.courseMenu(); //print Course Menu for user and store user's choice of what they want to do in menu

                //user wants to create a new course 
                if (choice == 1) { 
                    System.out.print("Enter the course code of the course you want to create: "); 
                    courseCode = input.nextLine(); 

                    //create a new course and add the course with the unique course code into courses array 
                    courses = Course.addCourse(courses, new Course(courseCode)); 
                    System.out.println("Course " + courseCode + " successfully created!"); 
                } 

                //user wants to print out class list for a course 
                else if (choice == 2) { 
                    System.out.print("Enter the course code to print out its class list: ");  
                    courseCode = input.nextLine(); 

                    //find the index of the course in the courses array using the findCourse() method and store it       
                    courseIndex = Course.findCourse(courses, courseCode); 
                    
                    if (courseIndex != -1) { 
                        courses[courseIndex].printStudents();
                    }
                }

                //user wants go print marks information for a course
                else if (choice == 3) { 
                    System.out.print("Enter the course code to print out its marks information: ");    
                    courseCode = input.nextLine(); 

                    //find the index of the course in the courses array using the findCourse() method and store it       
                    courseIndex = Course.findCourse(courses, courseCode);  


                    if (courseIndex != -1) { 
                        //let students refer to the same array as the one in the course object for easier to understand code
                        students = courses[courseIndex].students; 

                        //if there is currently no students in the course
                        if (students.length == 0) { 
                            System.out.println("There are no students in this course. Please have at least one student before getting the mark information of that course. Redirecting to the Main Menu.");  
                        }

                        //there are students so that means program can print their marks
                        else {  
                            //print the mark infomation of that particular course by calling printMarks()  
                            courses[courseIndex].printMarks(); 
                        }
                    }
                    
                }

                //user did not enter a valid choice for the Course Menu
                else { 
                    System.out.println("Please enter a valid choice in the Course Menu from 1-3"); 
                }
            } 
            

            //if user picks to go to the Student Menu  
            else if (menuInput == 2) { 
                choice = menu.studentMenu(); //print Student Menu for user and store user's choice of what they want to do in it
                
                //ask for course code so user can go to the correct student in that course 
                System.out.print("Enter the course code that the student is associated with: "); 
                courseCode = input.nextLine();  

                //find the index of the course in the courses array using the findCourse() method and store it       
                courseIndex = Course.findCourse(courses, courseCode); 


                //user wants to create a new student 
                if (choice == 1) {  
                    //make sure course exists (courseIndex!=-1) to add a student to that course 
                    if (courseIndex != -1) {
                        //call addStudent to add a new Student into students array 
                        courses[courseIndex].addStudent();  
                    }
                }

                //user wants to add a mark for a student  
                else if (choice == 2) { 
                    //make sure course exists (courseIndex!=-1) to add a mark for a student in that course 
                    if (courseIndex != -1) {
                        System.out.print("Enter the student's name to add a mark: "); 
                        studentName = input.nextLine();        
            
                        //find index of the student in students array of course object using findStudent() method and store it
                        studentIndex = courses[courseIndex].findStudent(studentName);

                        //course exists (index!=-1) and there are students, so add mark for the student 
                        if (studentIndex != -1) { 
                            //let students refer to the same array as the one in the course object for easier to understand code 
                            students = courses[courseIndex].students;  

                            students[studentIndex].addMark(); 
                            System.out.println("Mark successfully added");
                        }
                    }
                    
                }

                //user wants to get the average mark of a student  
                else if (choice == 3) { 
                    //make sure course exists (courseIndex!=-1) to get the mark of a student in that course 
                    if (courseIndex != -1) {
                        System.out.print("Enter the student's name to get their average mark: "); 
                        studentName = input.nextLine(); 
                        
                        //find index of the student in students array of course object using findStudent() method and store it
                        studentIndex = courses[courseIndex].findStudent(studentName);


                        //student exists (index!=-1), call getMark() and print out its average mark 
                        if (studentIndex != -1) { 
                            //let students refer to the same array as the one in the course object for easier to understand code 
                            students = courses[courseIndex].students;
                            System.out.println(students[studentIndex].getMark()); 
                        }
                    }
                }

                //user wants to add a comment for a student  
                else if (choice == 4) { 
                    //make sure course exists (courseIndex!=-1) to add a comment for a student in that course 
                    if (courseIndex != -1) {
                        System.out.print("Enter the student's name to add a comment about them: ");  
                        studentName = input.nextLine(); 

                        //find index of the student in students array of course object using findStudent() method and store it
                        studentIndex = courses[courseIndex].findStudent(studentName);

                        //student exists (index!=-1), addComment() for student 
                        if (studentIndex != -1) { 
                            //let students refer to the same array as the one in the course object for easier to understand code 
                            students = courses[courseIndex].students; 
                            students[studentIndex].addComment(); 
                        }
                    }

                }

                //user wants to get the comments they entered for a student  
                else if (choice == 5) {
                    //make sure course exists (courseIndex!=-1) to get the comments of a student in that course 
                    if (courseIndex != -1) {
                        System.out.print("Enter the student's name to get their comments you entered: ");  
                        studentName = input.nextLine(); 

                        //find index of the student in students array of course object using findStudent() method and store it
                        studentIndex = courses[courseIndex].findStudent(studentName); 

                        //student exists (index!=-1), print out the comments by calling getComments() 
                        if (studentIndex != -1) { 
                            //let students refer to the same array as the one in the course object for easier to understand code 
                            students = courses[courseIndex].students; 

                            System.out.print("Comment(s): "); 
                            System.out.println(students[studentIndex].getComments()); 
                        }
                    } 
                }

                //user wants to get information about a student  
                else if (choice == 6) { 
                    //make sure course exists (courseIndex!=-1) to get the information about a student in that course 
                    if (courseIndex != -1) {
                        System.out.print("Enter the student's name that you want to get information about: ");  
                        studentName = input.nextLine(); 
                        
                        //find index of the student in students array of course object using findStudent() method and store it
                        studentIndex = courses[courseIndex].findStudent(studentName); 

                        //student exists (index!=-1), so print out all information using toString() of student object 
                        if (studentIndex != -1) { 
                            //let students refer to the same array as the one in the course object for easier to understand code 
                            students = courses[courseIndex].students; 

                            System.out.println(students[studentIndex].toString()); 
                        }
                    } 
                }

                //user has not entered a valid choice for the Student Menu 
                else { 
                    System.out.println("Please enter a valid choice in the Student Menu from 1-6");
                }
               
            }


            //user has not entered a valid choice for the Main Menu 
            else if (menuInput != -1) { 
                System.out.println("Please enter valid input (-1, 1, or 2) in the Main Menu");  

            } 
        }

 
        //user chooses to end the program 
        menu.endMenu(); //print out thank you and goodbye messages in end menu 
        input.close(); //close Scanner  

    }

} 