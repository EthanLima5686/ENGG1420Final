package com.example;

public class Line {
    int startX;
    int startY;
    int endX;
    int endY;
    int border_Line;

    public Line(int startX, int startY, int endX, int endY, int border_Line){
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.border_Line = border_Line;
    }

    public void setStartX(int startX){
        this.startX = startX;
    }

    public int getStartX(int startX){
        return startX;
    }

    public void setStartY(int startY){
        this.startY = startY;
    }

    public int getStartY(int startY){
        return startY;
    }

    public void setEndX(int endX){
        this.endX = endX;
    }

    public int getEndX(int endX){
        return endX;
    }

    public void setEndY(int endY){
        this.endY = endY;
    }

    public int getEndY(int endY){
        return endY;
    }

    public void setBorder_Line(int border_Line){
        this.border_Line = border_Line;
    }

    public int getBorder_Line(int border_Line){
        return border_Line;
    }
    
}
