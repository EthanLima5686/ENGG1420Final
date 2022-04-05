package com.example;

/**
 * The master effect class, all effects are based on this.
 */
public class Effect {
    int start;
    public Effect(int start){
        this.start = start;
    }

    /**
     * The function to check if the effect is ready
     * @param frame The frame to trigger the effect on
     * @param shape The shape to afflict the effect on
     */
    public void TestEffect(int frame, MasterShape shape){
        if (frame > start){
            EffectTrigger(shape);
        }
    }

    /**
     * Placeholder function for sub-classes
     * @param shape The shape to afflect the effect on
     */
    public void EffectTrigger(MasterShape shape){
        return;
    }
}
