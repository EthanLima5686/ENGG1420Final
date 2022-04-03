package com.example;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Rect extends MasterShape {
    int length;
    int width;
    int border_Rectangle = 0;
    int x;
    int y;
    int r = 0;
    int b = 255;
    int g = 0;
    int red_border = 255;
    int blue_border = 0;
    int green_border = 0;

    public Rect(int length, int width, int x, int y, int border_Rectangle){
        super(x, y);
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

    public void setR(int r){
        this.r = r;
    }

    public int getR(int r){
        return r;
    }

    public void setB(int b){
        this.b = b;
    }

    public int getB(int b){
        return b;
    }

    public void setG(int g){
        this.g = g;
    }

    public int getG(int g){
        return g;
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
        if (!this.hidden){
            Rectangle rec = new Rectangle(x, y, x+length, y+width);
            rec.setFill(Color.rgb(r, g, b));
            return rec;
        } else {
            return null;
        }
    }

    public Rectangle DrawBorder() throws Exception{
        if (!this.hidden){
            if(border_Rectangle < 0)
            {
                throw new Exception("Invalid border thickness");
            } else {
                Rectangle rBorder = new Rectangle(x-border_Rectangle, y-border_Rectangle, x+length+(2*border_Rectangle), y+width+(2*border_Rectangle));
                rBorder.setFill(Color.rgb(red_border, blue_border, green_border));
                return rBorder;
            }
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


