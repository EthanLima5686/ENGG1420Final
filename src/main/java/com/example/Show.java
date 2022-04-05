package com.example;

public class Show extends Effect{

    int start;
    /**
     * Creates a Show effect
     * @param start When the effect should take place
     */
    public Show(int start){
        super(start);
    }
    /**
     * Shows a shape
     * @param shape The shape to show
     */
    public void EffectTrigger(MasterShape shape){
        shape.Show();
    }
}
