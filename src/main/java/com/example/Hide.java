package com.example;

/**
 * Hide Effect: Hides an object.
 */
public class Hide extends Effect{

    int start;

    public Hide(int start){
        super(start);
    }
    /**
     * Hides a shape
     * @param shape The shape to hide
     */
    public void EffectTrigger(MasterShape shape){
        shape.Hide();
    }
}
