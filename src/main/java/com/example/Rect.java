package com.example;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Rect {
    int length;
    int width;
    int border_Rectangle = 0;
    int x;
    int y;
    int red = 0;
    int blue = 255;
    int green = 0;
    int red_border = 255;
    int blue_border = 0;
    int green_border = 0;

    public Rect(int length, int width, int x, int y, int border_Rectangle){
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

    public Rectangle Draw(){
        Rectangle r = new Rectangle(x, y, x+length, y+width);
        r.setFill(Color.rgb(red, green, blue));
        return r;
    }

    public Rectangle DrawBorder() throws Exception{
        if(border_Rectangle < 0)
        {
            throw new Exception("Invalid border thickness");
        } else {
            Rectangle rBorder = new Rectangle(x-border_Rectangle, y-border_Rectangle, x+length+(2*border_Rectangle), y+width+(2*border_Rectangle));
            rBorder.setFill(Color.rgb(red_border, blue_border, green_border));
            return rBorder;
        }
    }
}


