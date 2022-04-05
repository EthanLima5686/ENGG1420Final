package com.example;

import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Cir extends MasterShape {
    int radius;
    int x;
    int y;
    int border_Circle;
    int r = 0;
    int g = 0;
    int b = 0;
    int r_border = 0;
    int g_border = 255;
    int b_border = 0;
    public ArrayList<Effect> effects;
    /**
     * The Circle class of our animation library.
     * @param radius The radius of the circle
     * @param x The x [horizontal] position of the circle
     * @param y The y [vertical] position of the circle
     * @param border_Circle The width of the border of the circle
     * @param effects The effects that will be applied to the circle
     */
    public Cir(int radius, int x, int y, int border_Circle, ArrayList<Effect> effects){
        super(x, y, effects);
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.border_Circle = border_Circle;
        this.effects = effects;
    }

    public void setRadius(int radius){
        this.radius = radius;
    }

    public int getRadius(int radius){
        return radius;
    }

    public void setX_Circle(int x){
        this.x = x;
    }

    public int getX_Circle(int x){
        return x;
    }

    public void setY_Circle(int y){
        this.y = y;
    }

    public int getY_Circle(int y){
        return y;
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

    /**
     * Creates a circle with the settings provided in this object
     * @return JavaFX Circle Class
     */

    public Circle Draw(){
        if (!this.hidden){
            Circle c = new Circle(x, y, radius);
            c.setFill(Color.rgb(r, g, b));
            return c;
        } else {
            return null;
        }
    }

    /**
     * Creates a border of a circle with the settings provided in this object
     * @return JavaFX Circle Class
     */

    public Circle DrawBorder() throws Exception{
        if (!this.hidden){
            if (border_Circle < 0){
                throw new Exception("Invalid border thickness");
            } else {
                Circle c_border = new Circle(x, y, radius+border_Circle);
                c_border.setFill(Color.rgb(r_border, g_border, b_border));
                return c_border;
            }
        } else {
            return null;
        }
    }

    /**
     * Changes the colour of the circle
     */

    public void ChangeColour(Color colour){
        this.r = (int)Math.round(colour.getRed() * 255);
        this.g = (int)Math.round(colour.getGreen() * 255);
        this.b = (int)Math.round(colour.getBlue() * 255);
    }

    /**
     * Hides the circle
     */

    public void Hide(){
        this.hidden = true;
    }

    /**
     * Moves the circle to a new position
     */
    public void Jump(int xTrans, int yTrans){
        x = xTrans;
        y = yTrans;
    }
    
}
