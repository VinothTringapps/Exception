package org.example;

import java.util.*;
import java.util.logging.*;

public class ExpectionCls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Logger l = Logger.getLogger("Expection");
        try {

            l.info("\t1.Bank\t2.Basic Shape\t3.SchoolTest\t4.Connection Pool\t5.Basic Point\t6.Basic Credit Card");
            int choice = sc.nextInt();
            String s = "----------------------------------";
            do {
                switch (choice) {
                    case 1 -> {
                        l.info("Bank Application");
                        l.info(s);
                        String name;
                        int number;
                        double amount;
                        double depositAmount;
                        double withDrawAmount;
                        sc.nextLine();
                        l.info("Enter the Name :");
                        name = sc.nextLine();
                        l.info("\nEnter the Account Number :");
                        number = sc.nextInt();
                        l.info("\nEnter the Balance :");
                        amount = sc.nextDouble();
                        Bank bank = new Bank(name, number, amount);
                        l.info("Welcome TO The Bank");
                        do {
                            l.info("1.Deposit \n 2.Withdraw \n 3.Show");
                            l.info("Enter the Choice :");
                            choice = sc.nextInt();
                            switch (choice) {
                                case 1 -> {
                                    l.info("Deposit :");
                                    l.info(" Enter the Amount To Deposit :");
                                    depositAmount = sc.nextDouble();
                                    bank.deposit(depositAmount);
                                }
                                case 2 -> {
                                    l.info("WithDraw :");
                                    l.info("Enter the Amount To Withdraw :");
                                    withDrawAmount = sc.nextDouble();
                                    bank.withDraw(withDrawAmount);
                                }
                                case 3 -> {
                                    l.info("Show Details :");
                                    bank.display();
                                }
                                default -> l.info("Enter the Correct Choice !");

                            }
                        } while (choice >= 3);
                    }
                    case 2 -> {
                        l.info("Basic Shape");
                        l.info(s);
                        String shape;
                        do {
                            l.info("\nTriangle \nRectangle \nCircle");
                            l.info("Enter the Type You Want :");
                            sc.nextLine();
                            shape = sc.nextLine();
                            if (shape.equalsIgnoreCase("triangle")) {
                                l.info("Enter the length of first Side :");
                                double triangleLength1 = sc.nextDouble();
                                l.info("Enter the Length of Second Side :");
                                double triangleLength2 = sc.nextDouble();
                                l.info("Enter the Length of Third Side :");
                                double triangleLength3 = sc.nextDouble();
                                BasicShape t = new BasicShape(shape, triangleLength1, triangleLength2, triangleLength3);
                                l.info("\nTriangle \n-------");
                                String area = "Area of the Triangle :" + t.triangleArea();
                                l.info(area);
                                String perimeter = "Perimeter of the Triangle :" + t.trianglePerimeter();
                                l.info(perimeter);
                                l.info(s);
                                sc.nextLine();
                            } else if (shape.equalsIgnoreCase("rectangle")) {
                                l.info("Enter the Length of the Rectangle :");
                                double rectangleLength = sc.nextDouble();
                                l.info("Enter the Width of the Rectangle :");
                                double rectangleWidth = sc.nextDouble();
                                BasicShape r = new BasicShape(shape, rectangleLength, rectangleWidth);
                                l.info("\n Rectangle\n---------");
                                String area = "Area of the Rectangle :" + r.rectangleArea();
                                l.info(area);
                                String perimeter = "Perimeter of the Rectangle :" + r.rectanglePerimeter();
                                l.info(perimeter);
                                l.info(s);

                                sc.nextLine();

                            } else if (shape.equalsIgnoreCase("Circle")) {
                                l.info("Enter the Radius of the Circle :");
                                double circleRadius = sc.nextDouble();
                                BasicShape c = new BasicShape(shape, circleRadius);
                                l.info("\n Circle \n------");
                                String area = "Area of the Circle :" + c.circleArea();
                                l.info(area);
                                String perimeter = "Perimeter of the Circle :" + c.circlePerimeter();
                                l.info(perimeter);
                                l.info(s);
                                sc.nextLine();
                            } else {
                                l.info("Wrong shape !");
                                l.info(s);

                            }
                        } while (shape.isEmpty());
                    }
                    case 3 -> {
                        l.info("School Test ");
                        l.info(s);
                        School school = new School(null, null, 0);
                        String name;
                        String grade;
                        double gradePoints;
                        sc.nextLine();
                        l.info("Enter the Name :");
                        name = sc.nextLine();
                        school.update();
                        grade = school.grade;
                        gradePoints = school.gradePoints;
                        School s1 = new School(name, grade, gradePoints);
                        while (true) {
                            l.info("1.display /n 2.Update");
                            choice = sc.nextInt();
                            switch (choice) {
                                case 1 -> s1.display();
                                case 2 -> s1.update();
                                default -> l.info("Wrong Choice !");
                            }

                        }
                    }
                    case 4 -> {
                        l.info("Connection Pool");
                        l.info(s);
                        while (true) {
                            l.info("1.Create Connection \t2.Close Connection");
                            choice = sc.nextInt();
                            sc.nextLine();
                            switch (choice) {
                                case 1 -> {
                                    l.info("\nEnter the Database Name :");
                                    String databaseName = sc.nextLine();
                                    String url = "jdbc:mysql://localhost:3306/" + databaseName;
                                    l.info("\nEnter the User Name :");
                                    String userName = sc.nextLine();
                                    l.info("\nEnter the Password :");
                                    String userPassword = sc.nextLine();
                                    ConnectionPool connection = ConnectionPool.getInstance();
                                    connection.create(url, userName, userPassword);
                                }
                                case 2 -> {
                                    ConnectionPool connection = ConnectionPool.getInstance();
                                    connection.closeConnection();
                                }
                                default -> l.info("\n Enter the Correct Choice !");
                            }

                        }
                    }
                    case 5 -> {
                        l.info("Basic Point");
                        l.info(s);
                        double x;
                        double y;
                        l.info("Enter the Value of X :");
                        x = sc.nextDouble();
                        l.info("Enter the Value of Y :");
                        y = sc.nextDouble();
                        BasicPoint b = new BasicPoint(x, y);
                        //Clone the b object into b1
                        BasicPoint b1 = (BasicPoint) b.clone();
                        l.info("Enter the Value of X :");
                        x = sc.nextDouble();
                        l.info("Enter the Value of Y :");
                        y = sc.nextDouble();
                        BasicPoint b2 = new BasicPoint(x, y);
                        boolean eql = b1.eql(b2);
                        String s1 = "Objects are b && b1 are Equal  : " + eql;
                        l.info(s1);
                    }
                    case 6 -> {
                        l.info("Basic Credit Card");
                        l.info(s);
                        sc.nextLine();
                        l.info("Enter the  Card Holder Name :");
                        String name = sc.nextLine();
                        l.info("Enter the Card Number :");
                        String cardNumber = sc.nextLine();
                        l.info("Enter the Expiry Date :");
                        String expiryDate = sc.nextLine();
                        BasicCreditCard b = new BasicCreditCard(name, cardNumber, expiryDate);
                        BasicCreditCard b2 = (BasicCreditCard) b.clone();
                        l.info("Enter the Card holder Name :");
                        String name2 = sc.nextLine();
                        l.info("Enter the Card Number :");
                        String cardNumber2 = sc.nextLine();
                        l.info("Enter the Expiry Dated :");
                        String expiryDate2 = sc.nextLine();
                        BasicCreditCard b3 = new BasicCreditCard(name2, cardNumber2, expiryDate2);
                        String checkEql = "Details are Equal : " + b2.checkEqual(b3);
                        l.info(checkEql);
                    }
                    default -> l.info("Wrong Choice !");

                }

            } while (choice < 7);
        } catch (InputMismatchException e) {
            l.info("InputMismatched !");
        } catch (Exception e) {
            l.info("The Connection was not Close !");
        }
    }
}
