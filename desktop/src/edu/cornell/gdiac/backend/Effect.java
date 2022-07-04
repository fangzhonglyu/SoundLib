/*
 * SoundEffect.java
 *
 * @author Barry Lyu
 * @date   6/25/22
 */

package edu.cornell.gdiac.backend;

import static org.lwjgl.openal.EXTEfx.*;

/**
 * This class represents sound effects in OpenAL
 *
 * The contents of this class should only be accessed using {@link EffectFactory} except for {@link #dispose()}
 * Effects need to be disposed with {@link #dispose()}
 *
 * */
public class Effect implements edu.cornell.gdiac.audio.EffectFilter {
    /** The id of the effect in openAL engine*/
    private int id;
    /** The id of the auxiliary slot the effect is in*/
    public int slot = -1;

    public static GDXAudio engine;

    /**
     * Dispose the sound effect and release its resources
     * */
    public void dispose(){
        if(slot != -1)
            engine.unloadEffect(slot);
        alDeleteEffects(id);
    }

    public Effect(){
        id = alGenEffects();
        //engine.loadEffect(this);
    }

    /**
     * Set the attributes of an effect
     * */
    public void setAttribute(int att, int value){
        alEffecti(id,att,value);
    }

    public void setAttribute(int att, float value){
        alEffectf(id,att,value);
    }

    /**
     * @return the id of the effect in openAL
     * */
    public int getId(){
        return id;
    }
}