package org.example;
//"2. Design a class for a basic shape. The class should have the following features:
//        - An instance variable for the shape's type (e.g. triangle, rectangle, circle).
//        - An instance variable for the shape's dimensions (e.g. side lengths for a triangle, length and width for a rectangle, radius for a circle).
//        - A constructor that allows the user to create a shape with a given type and dimensions.
//        - A method that calculates and returns the perimeter of the shape.
//        - A method that calculates and returns the area of the shape. "


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
}
