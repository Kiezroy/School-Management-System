package com.company;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Student> system = new ArrayList<>();
    public static boolean start = true;

    public static void main(String[] args) {
	    while(start){
            Scanner input = new Scanner(System.in);
            System.out.println("-----Welcome to PGHS Synergy!-----");

            System.out.println("•Login(1)");
            System.out.println("•Create Account(2)");

            String option = input.nextLine();
            if(option.equals("1")){
                //Goes to Login Class
                login();
            }else if(option.equals("2")){
                //Creates a new student
                create();
            }else{
                System.out.println("Please input numbers 1 or 2!\n");
            }
        }
    }

    public static Student create(){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter first name: ");
        String firstName = input.nextLine();

        System.out.println("Enter last name: ");
        String lastName = input.nextLine();

        System.out.println("Enter new password here: ");
        String password = input.nextLine();

        System.out.println("Generating Student ID...\n");

        Student PGstudent = new Student(firstName, lastName, "", password);
        //Generate unique 8 digit ID starts with 997
        PGstudent.setID(PGstudent.generateID());

        System.out.println(firstName + " " + lastName + " " + PGstudent.getID() + "\n");
        System.out.println("Done! Please login!\n");

        //Add student to system
        system.add(new Student(firstName, lastName, PGstudent.getID(), password));

        return PGstudent;
    }

    public static void login(){
        Scanner input = new Scanner(System.in);
        boolean success = false;

        System.out.println("ID: ");
        String ID = input.nextLine();
        System.out.println("Password: ");
        String pass = input.nextLine();

        //iterate through system arraylist & check login
        for(Student stu: system){
            if(stu.getID().equals(ID) && stu.getPassword().equals(pass)) {
                success = true;
                start = false;
                System.out.println("Login Successful! Loading...");
                mainPage(stu);
            }
        }
        System.out.println(!success ? "Invalid Login! Please try again.\n" : "");
    }

    public static void mainPage(Student stu){
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------------------");
        System.out.println("        Welcome, " + stu.getFirstName() + ".\n");

        //Make randomized courses & randomized grades + teacher comments later
        //BUT assign the same courses & randomized content to student
        System.out.println("| Enrolled Courses: ");

        ArrayList<Course> student_classes =  stu.courses();
        int num = 1;

        for(Course core : student_classes){
            System.out.println("| (" + Integer.toString(num) + ") "+ core.getCourseName());
            num++;
        }

        System.out.println("Please enter a course number or type Q to sign out.\n");
        String str = input.nextLine();

        if(str.equalsIgnoreCase("q")){
            start = true;
        }
        else{
           switch(str){
               //Each case is a different class
               case "1":
                   System.out.println("Course Subject: " + student_classes.get(0).getCourseName() +
                           "\nGrade: " + student_classes.get(0).getCourseGrade() +
                           "\nTeacher Comment: " + student_classes.get(0).randomComment(student_classes.get(0).getCourseGrade()));
                   goBackToCourses(stu, student_classes);
                   break;
               case "2":
                   System.out.println("Course Subject: " + student_classes.get(1).getCourseName() +
                           "\nGrade: " + student_classes.get(1).getCourseGrade() +
                           "\nTeacher Comment: " + student_classes.get(1).randomComment(student_classes.get(1).getCourseGrade()));
                   goBackToCourses(stu, student_classes);
                   break;
               case "3":
                   System.out.println("Course Subject: " + student_classes.get(2).getCourseName() +
                           "\nGrade: " + student_classes.get(2).getCourseGrade() +
                           "\nTeacher Comment: " + student_classes.get(2).randomComment(student_classes.get(2).getCourseGrade()));
                   goBackToCourses(stu, student_classes);
                   break;
               default:
                   System.out.println("Invalid course number!\n");
                   mainPage2(stu, student_classes);
           }
        }
    }

    public static void goBackToCourses(Student stu, ArrayList<Course> student_classes){
        Scanner input = new Scanner(System.in);
        System.out.println("\nType B to go back!");
        String choice = input.nextLine();
        while(!choice.equalsIgnoreCase("B")){
            System.out.println("Please type B to go back!");
            choice = input.nextLine();
        }
        mainPage2(stu, student_classes);
    }

    public static void mainPage2(Student stu, ArrayList<Course> student_classes){
        Scanner input = new Scanner(System.in);
        System.out.println("| Enrolled Courses: ");

        //Accidentally re randomizes the courses
        //student_classes =  stu.courses();
        int num = 1;

        for(Course core : student_classes){
            System.out.println("| (" + Integer.toString(num) + ") "+ core.getCourseName());
            num++;
        }

        System.out.println("Please enter a course number or type Q to sign out.\n");
        String str = input.nextLine();

        if(str.equalsIgnoreCase("q")){
            start = true;
        }
        else{
            switch(str){
                //Each case is a different class
                case "1":
                    System.out.println("Course Subject: " + student_classes.get(0).getCourseName() +
                            "\nGrade: " + student_classes.get(0).getCourseGrade() +
                            "\nTeacher Comment: " + student_classes.get(0).randomComment(student_classes.get(0).getCourseGrade()));
                    goBackToCourses(stu, student_classes);
                    break;
                case "2":
                    System.out.println("Course Subject: " + student_classes.get(1).getCourseName() +
                            "\nGrade: " + student_classes.get(1).getCourseGrade() +
                            "\nTeacher Comment: " + student_classes.get(1).randomComment(student_classes.get(1).getCourseGrade()));
                    goBackToCourses(stu, student_classes);
                    break;
                case "3":
                    System.out.println("Course Subject: " + student_classes.get(2).getCourseName() +
                            "\nGrade: " + student_classes.get(2).getCourseGrade() +
                            "\nTeacher Comment: " + student_classes.get(2).randomComment(student_classes.get(2).getCourseGrade()));
                    goBackToCourses(stu, student_classes);
                    break;
                default:
                    System.out.println("Invalid course number!\n");
                    mainPage2(stu, student_classes);
            }
        }
    }

}

