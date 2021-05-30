package com.company;

import java.util.Random;

//BUG: courses are all the same, not different

public class Course {
    private String courseName;
    private String courseGrade;

    public Course(){
        this.courseName = randomName();
        this.courseGrade = randomGrade();
    }

    public String getCourseName(){
        return courseName;
    }

    public String getCourseGrade(){
        return courseGrade;
    }

    public static String randomName(){
        Random rand = new Random();
        String[] courses = new String[]{"Dance", "Physical Education", "Math", "English", "History", "Science", "Spanish", "French", "Government", "Economics"};
        return courses[rand.nextInt(10)];
    }

    public static String randomGrade(){
        Random rand = new Random();
        boolean feelingLucky = rand.nextBoolean();
        boolean feelingUnlucky = rand.nextBoolean();
        String[] grades = new String[]{"A", "B", "C", "D", "F"};
        String selected_grade = grades[rand.nextInt(5)];
        if(!feelingLucky && !feelingUnlucky){
            //if both statements are false do nothing so grades remain the same
        }else if(feelingLucky){
            //Adds an A+ or B+ etc..
            selected_grade += "+";
        }else{
            selected_grade += "-";
        }
        return selected_grade;
    }

    public String randomComment(String grade){
        //Prints out good comment if grade is an A or B

        Random rand = new Random();
        String[] goodComments = new String[]{"Outstanding work!", "Keep up the great work!", "Absolutely splendid student.", "Great listener.", "Active participant and always ready for class.",
        "Love your effort in class.", "Always on time.", "Never late and never fails to make me laugh.", "Keep striving for success.", "Superb achievements.", "YES!"};

        String[] badComments = new String[]{"Many missing assignments.", "Horrible grades. Speak up in class.", "Little to no class participation.", "Constantly slacks off during class time.",
        "Interrupts class with off topic subjects.", "Please ask questions!", "Try a little harder...", "Get your ASS up and work.", "Too much talking.", "Inappropriate behavior and language.", "Try harder please."};

        return "A-A+AB+B-B".contains(grade) ? goodComments[rand.nextInt(11)]: badComments[rand.nextInt(11)];
    }


}
