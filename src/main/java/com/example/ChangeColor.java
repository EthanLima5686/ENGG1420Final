package com.example;
import javafx.scene.paint.Color;

public class ChangeColor extends Effect{
    
    Color changeColour;

    public ChangeColor(int start, Color changeColour){
        super(start);
        this.changeColour = changeColour;
    }

    public void EffectTrigger(MasterShape shape){
        shape.ChangeColour(changeColour);
    }
}
