package org.example;
//"2. Design a class for a basic shape. The class should have the following features:
//        - An instance variable for the shape's type (e.g. triangle, rectangle, circle).
//        - An instance variable for the shape's dimensions (e.g. side lengths for a triangle, length and width for a rectangle, radius for a circle).
//        - A constructor that allows the user to create a shape with a given type and dimensions.
//        - A method that calculates and returns the perimeter of the shape.
//        - A method that calculates and returns the area of the shape. "

import java.util.*;
import java.util.logging.Logger;

public class BasicShape {
    String shapeType;
    double triangleLength1;
    double triangleLength2;
    double triangleLength3;
    double rectangleLength;
    double rectangleWidth;
    double circleRadius;
    double area;
    double perimeter;

    public static final double PI = 3.14;

    BasicShape(String shape,double triangleLength1,double triangleLength2,double triangleLength3){
        this.shapeType=shape;
        this.triangleLength1=triangleLength1;
        this.triangleLength2=triangleLength2;
        this.triangleLength3=triangleLength3;
    }
    BasicShape(String shape,double length,double width){
        this.shapeType=shape;
        this.rectangleLength=length;
        this.rectangleWidth=width;
    }
    BasicShape(String shape,double radius){
        this.shapeType=shape;
        this.circleRadius=radius;
    }
    public double trianglePerimeter(){
        perimeter=this.triangleLength1+this.triangleLength2+this.triangleLength3;
        return perimeter;
    }
    public double triangleArea(){
        double height=(this.triangleLength1*this.triangleLength2)/2;
        area=(0.5)*height*this.triangleLength3;
        return area;
    }
    public double circlePerimeter(){
        perimeter=2*PI*this.circleRadius;
        return perimeter;
    }
    public double circleArea(){
        area=PI*this.circleRadius*this.circleRadius;
        return area;
    }
    public double rectangleArea(){
        area=this.rectangleWidth*this.rectangleLength;
        return area;
    }
    public double rectanglePerimeter(){
        perimeter=(2*this.rectangleLength)+(2*this.rectangleWidth);
        return perimeter;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Logger l=Logger.getLogger("com.api.jar");
        String shape;
        String decoration="-----------------------------------------------------";
        try {


            do {

                l.info("\nTriangle \nRectangle \nCircle");
                l.info("Enter the Type You Want :");
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
                    l.info(decoration);
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
                    l.info(decoration);

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
                    l.info(decoration);

                    sc.nextLine();
                } else {
                    l.info("Wrong shape !");
                    l.info(decoration);

                }
            } while (shape.isEmpty());
        }
        catch (InputMismatchException e){
            l.info("Input Mismatched Error !");
        }

    }
}
