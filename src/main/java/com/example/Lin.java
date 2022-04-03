package com.example;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class Lin extends MasterShape{
    int startX;
    int startY;
    int endX;
    int endY;
    int border_Line;
    int r = 125;
    int g = 125;
    int b = 125;
    int r_border = 50;
    int g_border = 50;
    int b_border = 50;

    public Lin(int startX, int startY, int endX, int endY, int border_Line){
        super(startX, startY);
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

    public int getB_Border(int b_border){
        return b_border;
    }

    public Line Draw(){
        if (!this.hidden){
            Line lin = new Line(startX, startY, endX, endY);
            lin.setStroke(Color.rgb(r, g, b));
            return lin;
        } else {
            return null;
        }
    }

    public Shape DrawBorder(){
        if (!this.hidden){
            Circle circ1 = new Circle(startX, startY, border_Line);
            Circle circ2 = new Circle(endX, endY, border_Line);
            Polygon poly = new Polygon();
            poly.getPoints().addAll(new Double[]{
                (double)startX, (double)(startY + border_Line),
                (double)startX, (double)(startY - border_Line),
                (double)endX, (double)(endY - border_Line),
                (double)endX, (double)(endY + border_Line)
            });
            Shape temp = Shape.union(circ1, poly);
            Shape border = Shape.union(temp, circ2);
            border.setFill(Color.rgb(r_border, g_border, b_border));
            return border;
        } else {
            return null;
        }
    }

    public void ChangeColour(Color color){
        this.r = (int)Math.round(color.getRed() * 255);
        this.g = (int)Math.round(color.getGreen() * 255);
        this.b = (int)Math.round(color.getBlue() * 255);
    }
    public void Hide(){
        this.hidden = true;
    }
}
