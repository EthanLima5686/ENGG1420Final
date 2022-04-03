package com.example;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class MasterShape {
    int x;
    int y;
    int r;
    int g;
    int b;
    boolean hidden = false;
    public MasterShape(int x, int y){
        this.x = x;
        this.y = y;
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
}
