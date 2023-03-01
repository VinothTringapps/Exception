package org.example;



import java.util.*;
import java.util.logging.*;


 class School {

    String studentName;
    String grade;
    double gradePoints;

    Scanner sc=new Scanner(System.in);
    Logger l=Logger.getLogger("com.api.jar");
    School(String name,String grade,double gradePoints){
        this.studentName=name;
        this.grade=grade;
        this.gradePoints=gradePoints;
    }
    public void display(){
        String s=this.studentName+" has a "+this.gradePoints+" GPA";
        l.info(s);
    }
    public void update(){

        l.info("Enter the Number of Subject :");
        int n=sc.nextInt();
        Double gpa=0.0;

        String[] a=new String[n];
        sc.nextLine();
        try {
            l.info("A/B/C/D/E/F");
            for (int i = 0; i < n; i++) {
                l.info("Enter the Grade for subject  :");
                a[i] = sc.nextLine();
                if(a[i].length()>=2)
                    throw new MyException("");
                gpa += gradeCal(a[i]);
            }
        }
        catch(MyException e){
            l.info("You need to Enter Single Character !");

        }
            if (gpa > 23) {
                grade = "A";
                gradePoints = 5.0;
            } else if (gpa > 20) {
                grade = "B";
                gradePoints = 4.5;
            } else if (gpa > 18) {
                grade = "C";
                gradePoints = 4.0;
            } else if (gpa > 15) {
                grade = "D";
                gradePoints = 3.5;
            } else if (gpa > 10) {
                grade = "E";
                gradePoints = 3.0;
            } else {
                grade = "F";
                gradePoints = 2.5;
            }


    }

    private Double gradeCal(String s) {
        if (s.equalsIgnoreCase("A")) {
            gradePoints = 5.0;
        } else if (s.equalsIgnoreCase("B")) {
            gradePoints = 4.5;
        } else if (s.equalsIgnoreCase("C")) {
            gradePoints = 4.0;
        } else if (s.equalsIgnoreCase("D")) {
            gradePoints = 3.5;
        } else if (s.equalsIgnoreCase("E")) {
            gradePoints = 3.0;
        }
        else {
            gradePoints = 2;
        }
        return gradePoints;
    }



}
