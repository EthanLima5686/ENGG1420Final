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

    public void setRed(int red){
        this.red = red;
    }

    public int getRed(int red){
        return red;
    }

    public void setBlue(int blue){
        this.blue = blue;
    }

    public int getBlue(int blue){
        return blue;
    }

    public void setGreen(int green){
        this.green = green;
    }

    public int getGreen(int green){
        return green;
    }

    public void setRed_Border(int red_border){
        this.red_border = red_border;
    }

    public int getRed_Border(int red_border){
        return red_border;
    }

    public void setBlue_Border(int blue_border){
        this.blue_border = blue_border;
    }

    public int getBlue_Border(int blue_border){
        return blue_border;
    }

    public void setGreen_Border(int green_border){
        this.green_border = green_border;
    }

    public int getGreen_Border(int green_border){
        return green_border;
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


