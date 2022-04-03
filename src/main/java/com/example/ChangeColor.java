package com.example;
import javafx.scene.paint.Color;

public class ChangeColor extends Effect{
    
    Color changeColor;

    public ChangeColor(int start, Color changeColor){
        super(start);
        this.changeColor = changeColor;
    }
}
