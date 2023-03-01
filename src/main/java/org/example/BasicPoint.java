package org.example;
//        2. Design a class for a basic point in 2D space. The class should have the following features:
//        - Instance variables for the x and y coordinates of the point.
//        - A constructor that allows the user to create a point with given x and y coordinates.
//        - An equals method that returns true if the given object is a point with the same x and y coordinates, and false otherwise.
//        - A clone method that creates and returns a new point with the same x and y coordinates as the original point.

public class BasicPoint implements Cloneable {
    double x;
    double y;

    double x1;
    double y1;
    BasicPoint(double x,double y){
        this.x=x;
        this.y=y;

    }


    public boolean eql(BasicPoint points){
        this.x1= points.x;
        this.y1= points.y;
        return this.x == x1 && this.y == y1;
    }


    public Object clone()  {
        try{
            return super.clone();
        }
        catch (CloneNotSupportedException e){
            return this;
        }
    }
}