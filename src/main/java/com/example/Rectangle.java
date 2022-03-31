package com.example;

public class Rectangle {
    int length;
    int width;
    int border_Rectangle;
    int x;
    int y;

    public Rectangle(int length, int width, int border_Rectangle, int x, int y){
        this.length = length;
        this.width = width;
        this.border_Rectangle = border_Rectangle;
        this.x = x;
        this.y = y;
    }

    public void setLength(int length){
        this.length = length;
    }

    public int getLength(int length){
        return length;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public int getWidth(int width){
        return width;
    }

    public void setBorder(int border_Rectangle){
        this.border_Rectangle = border_Rectangle;
    }

    public int getBorder(int border_Rectangle){
        return border_Rectangle;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getX(int x){
        return x;
    }

    public void setY(int y){
        this.y = y;
    }
    
    public int getY(int y){
        return y;
    }
}



