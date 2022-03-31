package com.example;

public class Circle {
    int radius;
    int x_circle;
    int y_circle;
    int border_Circle;

    public Circle(int radius, int x_circle, int y_circle, int border_Circle){
        this.radius = radius;
        this.x_circle = x_circle;
        this.y_circle = y_circle;
        this.border_Circle = border_Circle;
    }

    public void setRadius(int radius){
        this.radius = radius;
    }

    public int getRadius(int radius){
        return radius;
    }

    public void setX_Circle(int x_circle){
        this.x_circle = x_circle;
    }

    public int getX_Circle(int x_circle){
        return x_circle;
    }

    public void setY_Circle(int y_circle){
        this.y_circle = y_circle;
    }

    public int getY_Circle(int y_circle){
        return y_circle;
    }

    public void setBorder_Circle(int border_Circle){
        this.border_Circle = border_Circle;
    }

    public int getBorder_Circle(int border_Circle){
        return border_Circle;
    }
}
