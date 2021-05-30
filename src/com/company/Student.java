package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Student {
    //Student characteristics include: unique ID, grade level, name
    private String firstName;
    private String lastName;
    private String password;
    private String ID;

    public Student(String firstName, String lastName, String ID, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.password = password;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getID(){
        return this.ID;
    }

    public String getPassword(){return this.password;}

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setID(String ID){this.ID = ID;}

    public void setPassword(String password){this.password = password;}

    public String generateID() {
        //Generates new ID then adds to database

        //Should try to implement something that catches duplicates

        Random rand = new Random();

        String start = "997";

        for(int i = 0; i < 5; i++){
            start += Integer.toString(rand.nextInt(10));
        }

        return start;
    }

    public ArrayList<Course> courses(){
        Random rand = new Random();
        //list of courses to randomize (course name, course grade, teacher comment)
        ArrayList<Course> courses = new ArrayList<>();
        //3 random classes

        //BUG DUPLICATE COURSES also when go back to login wipes memory of other students courses (need to store for specific student)

        for(int i = 0; i < 3; i++){
            courses.add(new Course());
        }

        return courses;
    }

}
