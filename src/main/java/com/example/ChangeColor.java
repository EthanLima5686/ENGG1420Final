package com.example;
import javafx.scene.paint.Color;

/**
 * ChangeColor Effect: Changes the colour of an object.
 */
public class ChangeColor extends Effect{
    
    Color changeColour;
    /**
     * 
     * @param start An integer for what frame the effect should trigger
     * @param changeColour The colour that the shape changes to
     */
    public ChangeColor(int start, Color changeColour){
        super(start);
        this.changeColour = changeColour;
    }

    public void EffectTrigger(MasterShape shape){
        shape.ChangeColour(changeColour);
    }
}
