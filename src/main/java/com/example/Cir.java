package com.example;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Cir {
    int radius;
    int x_circle;
    int y_circle;
    int border_Circle;
    int r = 0;
    int g = 0;
    int b = 0;
    int r_border = 0;
    int g_border = 255;
    int b_border = 0;

    public Cir(int radius, int x_circle, int y_circle, int border_Circle){
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

    public void setR(int r){
        this.r = r;
    }

    public int getR(int r){
        return r;
    }

    public void setG(int g){
        this.g = g;
    }

    public int getG(int g){
        return g;
    }

    public void setB(int b){
        this.b = b;
    }

    public int getB(int b){
        return b;
    }

    public void setR_Border(int r_border){
        this.r_border = r_border;
    }

    public int getR_Border(int r_border){
        return r_border;
    }

    public void setG_Border(int g_border){
        this.g_border = g_border;
    }

    public int getG_Border(int g_border){
        return g_border;
    }

    public void setB_Border(int b_border){
        this.b_border = b_border;
    }

    public int getB_border(int b_border){
        return b_border;
    }

    public Circle Draw(){
        Circle c = new Circle(x_circle, y_circle, radius);
        c.setFill(Color.rgb(r, g, b));
        return c;
    }

    public Circle DrawBorder() throws Exception{
        if (border_Circle < 0){
            throw new Exception("Invalid border thickness");
        } else {
            Circle c_border = new Circle(x_circle, y_circle, radius+border_Circle);
            c_border.setFill(Color.rgb(r_border, g_border, b_border));
            return c_border;
        }
    }
}
