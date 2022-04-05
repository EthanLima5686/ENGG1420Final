package com.example;

import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class MasterShape {
    int x;
    int y;
    int r;
    int g;
    int b;
    boolean hidden = false;
    ArrayList<Effect> effects = new ArrayList<>();

    /**
     * The master shape class that all shapes are based on
     * @param x The x-position of the shape
     * @param y The y-position of the shape
     * @param effects The effects that will occur to the shape
     */
    public MasterShape(int x, int y, ArrayList<Effect> effects){
        this.x = x;
        this.y = y;
        this.effects = effects;
    }

    public Shape DrawBorder() throws Exception {
        return null;
    }

    public Shape Draw() {
        return null;
    }
    
    public void ChangeColour(Color color){
        this.r = (int)Math.round(color.getRed() * 255);
        this.g = (int)Math.round(color.getGreen() * 255);
        this.b = (int)Math.round(color.getBlue() * 255);
    }
    public void Hide(){
        this.hidden = true;
    }
    public void Show(){
        this.hidden = false;
    }
    public void Jump(int xTrans, int yTrans){
        return;
    }
}
