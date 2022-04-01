package com.example;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class Lin {
    int startX;
    int startY;
    int endX;
    int endY;
    int border_Line;
    int r = 125;
    int g = 125;
    int b = 125;
    int r_border = 10;
    int g_border = 10;
    int b_border = 10;

    public Lin(int startX, int startY, int endX, int endY, int border_Line){
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

    public Line Draw(){
        Line lin = new Line(startX, startY, endX, endY);
        lin.setStroke(Color.rgb(r, g, b));
        return lin;
    }

    public Shape DrawBorder(){
        Circle circ1 = new Circle(startX, startY, border_Line);
        Circle circ2 = new Circle(endX, endY, border_Line);
        Polygon poly = new Polygon();
        poly.getPoints().addAll(new Double[]{
            (double)startX, (double)(startY + border_Line + 1),
            (double)startX, (double)(startY - border_Line - 1),
            (double)endX, (double)(endY - border_Line - 1),
            (double)endX, (double)(endY + border_Line + 1)
        });
        Shape temp = Shape.union(circ1, poly);
        Shape border = Shape.union(temp, circ2);
        return border;
    }
}
