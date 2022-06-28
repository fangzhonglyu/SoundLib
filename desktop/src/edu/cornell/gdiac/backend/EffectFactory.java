/*
 * EffectFactory.java
 *
 * This is the factory class for SoundEffects
 *
 * @author Barry Lyu
 * @date   6/25/22
 */

package edu.cornell.gdiac.backend;

import org.lwjgl.openal.EXTEfx;
import static org.lwjgl.openal.EXTEfx.*;

/**
 * This is a factory class for creating {@link SoundEffect} Objects
 *
 * The following openAL effects are supported,
 * for more details on effect parameters, see {@link EXTEfx}
 *
 *  AL_EFFECT_NULL
 *  AL_EFFECT_REVERB
 *  AL_EFFECT_CHORUS
 *  AL_EFFECT_DISTORTION
 *  AL_EFFECT_ECHO
 *  AL_EFFECT_FLANGER
 *  AL_EFFECT_FREQUENCY_SHIFTER
 *  AL_EFFECT_VOCAL_MORPHER
 *  AL_EFFECT_PITCH_SHIFTER
 *  AL_EFFECT_RING_MODULATOR
 *  AL_EFFECT_AUTOWAH
 *  AL_EFFECT_COMPRESSOR
 *  AL_EFFECT_EQUALIZER
 *  AL_EFFECT_EAXREVERB
 *
 * */
public class EffectFactory {

    /**
     * This class contains definitions for constructing a reverb object
     *
     * Edit properties of a ReverbDef object then use {@link #createReverb()} or {@link #updateReverb(SoundEffect, ReverbDef)}
     * to transfer properties from ReverbDef to the effect object.
     */
    public class ReverbDef {
        /**
         * Default Settings for reverb effects
         */
        public float                                    // [] denote the ranges of the values
                REVERB_DENSITY = 1.0f,                  // [0.0f,1.0f]
                REVERB_DIFFUSION = 1.0f,                // [0.0f,1.0f]
                REVERB_GAIN = 0.32f,                    // [0.0f,1.0f]
                REVERB_GAINHF = 0.89f,                  // [0.0f,1.0f]
                REVERB_DECAY_TIME = 1.49f,              // [0.1f,20.0f]
                REVERB_DECAY_HFRATIO = 0.83f,           // [0.1f,2.0f]
                REVERB_REFLECTIONS_GAIN = 0.05f,        // [0.0f,3.16f]
                REVERB_REFLECTIONS_DELAY = 0.007f,      // [0.0f,0.3f]
                REVERB_LATE_REVERB_GAIN = 1.26f,        // [0.0f,10.0f]
                REVERB_LATE_REVERB_DELAY = 0.011f,      // [0.0f,0.1f]
                REVERB_AIR_ABSORPTION_GAINHF = 0.994f,  // [0.892f,1.0f]
                REVERB_ROOM_ROLLOFF_FACTOR = 0.0f;      // [0.0f,10.0f]
    }

    /**
     * Create a reverb effect object based on the ReverbDef object
     *
     * @param def the ReverbDef object to create from
     */
    public SoundEffect createReverb(ReverbDef def) {
        SoundEffect reverb = new SoundEffect();
        updateReverb(reverb, def);
        return reverb;
    }

    /**
     * Create default reverb object
     */
    public SoundEffect createReverb() {
        return createReverb(new ReverbDef());
    }

    /**
     * Update an existing reverb effect based on the ReverbDef
     *
     * @param reverb the reverb effect to edit
     * @param def    the ReverbDef object to create from
     */
    public void updateReverb(SoundEffect reverb, ReverbDef def) {
        reverb.setAttribute(AL_EFFECT_TYPE, AL_EFFECT_REVERB);
        reverb.setAttribute(AL_REVERB_DENSITY, def.REVERB_DENSITY);
        reverb.setAttribute(AL_REVERB_DIFFUSION, def.REVERB_DIFFUSION);
        reverb.setAttribute(AL_REVERB_GAIN, def.REVERB_GAIN);
        reverb.setAttribute(AL_REVERB_GAINHF, def.REVERB_GAINHF);
        reverb.setAttribute(AL_REVERB_DECAY_TIME, def.REVERB_DECAY_TIME);
        reverb.setAttribute(AL_REVERB_DECAY_HFRATIO, def.REVERB_DECAY_HFRATIO);
        reverb.setAttribute(AL_REVERB_REFLECTIONS_GAIN, def.REVERB_REFLECTIONS_GAIN);
        reverb.setAttribute(AL_REVERB_REFLECTIONS_DELAY, def.REVERB_REFLECTIONS_DELAY);
        reverb.setAttribute(AL_REVERB_LATE_REVERB_GAIN, def.REVERB_LATE_REVERB_GAIN);
        reverb.setAttribute(AL_REVERB_LATE_REVERB_DELAY, def.REVERB_LATE_REVERB_DELAY);
        reverb.setAttribute(AL_REVERB_AIR_ABSORPTION_GAINHF, def.REVERB_AIR_ABSORPTION_GAINHF);
        reverb.setAttribute(AL_REVERB_ROOM_ROLLOFF_FACTOR, def.REVERB_ROOM_ROLLOFF_FACTOR);
    }

    /**
     * This class contains definitions for constructing a EAXReverb object
     *
     * Edit properties of a EAXReverbDef object then use {@link #createEAXReverb()} or {@link #updateEAXReverb(SoundEffect, EAXReverbDef)}
     * to transfer properties from EAXReverbDef to the effect object.
     */
    public class EAXReverbDef {
        /**
         * Default Settings for EAX reverb effects
         */
        public float                                        // [] denote the ranges of the values
                EAXREVERB_DENSITY = 1.0f,                   // [0.0f,1.0f]
                EAXREVERB_DIFFUSION = 1.0f,                 // [0.0f,1.0f]
                EAXREVERB_GAIN = 0.32f,                     // [0.0f,1.0f]
                EAXREVERB_GAINHF = 0.89f,                   // [0.0f,1.0f]
                EAXREVERB_GAINLF = 1.0f,                    // [0.0f,1.0f]
                EAXREVERB_DECAY_TIME = 1.49f,               // [0.1f,20.0f]
                EAXREVERB_DECAY_HFRATIO = 0.83f,            // [0.1f,2.0f]
                EAXREVERB_DECAY_LFRATIO = 1.0f,             // [0.1f,2.0f]
                EAXREVERB_REFLECTIONS_GAIN = 0.05f,         // [0.0f,3.16f]
                EAXREVERB_REFLECTIONS_DELAY = 0.007f,       // [0.0f,0.3f]
                EAXREVERB_LATE_REVERB_GAIN = 1.26f,         // [0.0f,10.0f]
                EAXREVERB_LATE_REVERB_DELAY = 0.011f,       // [0.0f,0.1f]
                EAXREVERB_ECHO_TIME = 0.25f,                // [0.075f,0.25f]
                EAXREVERB_ECHO_DEPTH = 0.0f,                // [0.0f,1.0f]
                EAXREVERB_MODULATION_TIME = 0.25f,          // [0.04f,4.0f]
                EAXREVERB_MODULATION_DEPTH = 0.0f,          // [0.0f,1.0f]
                EAXREVERB_AIR_ABSORPTION_GAINHF = 0.994f,   // [0.892f,1.0f]
                EAXREVERB_HFREFERENCE = 5000.0f,            // [1000.0f,20000.0f]
                EAXREVERB_LFREFERENCE = 250.0f,             // [20.0f,1000.0f]
                EAXREVERB_ROOM_ROLLOFF_FACTOR = 0.0f;       // [0.0f,10.0f]
    }

    /**
     * Create a EAXReverb effect object based on the ReverbDef object
     *
     * @param def the EAXReverbDef object to create from
     */
    public SoundEffect createEAXReverb(EAXReverbDef def) {
        SoundEffect eaxReverb = new SoundEffect();
        updateEAXReverb(eaxReverb, def);
        return eaxReverb;
    }

    /**
     * Create default EAXReverb object
     */
    public SoundEffect createEAXReverb() {
        return createEAXReverb(new EAXReverbDef());
    }

    /**
     * Update an existing EAXReverb effect based on the EAXReverbDef
     *
     * @param eaxReverb the EaxReverb effect to edit
     * @param def       the EAxReverbDef object to create from
     */
    public void updateEAXReverb(SoundEffect eaxReverb, EAXReverbDef def) {
        eaxReverb.setAttribute(AL_EFFECT_TYPE, AL_EFFECT_EAXREVERB);
        eaxReverb.setAttribute(AL_EAXREVERB_DENSITY, def.EAXREVERB_DENSITY);
        eaxReverb.setAttribute(AL_EAXREVERB_DIFFUSION, def.EAXREVERB_DIFFUSION);
        eaxReverb.setAttribute(AL_EAXREVERB_GAIN, def.EAXREVERB_GAIN);
        eaxReverb.setAttribute(AL_EAXREVERB_GAINHF, def.EAXREVERB_GAINHF);
        eaxReverb.setAttribute(AL_EAXREVERB_GAINLF, def.EAXREVERB_GAINLF);
        eaxReverb.setAttribute(AL_EAXREVERB_DECAY_TIME, def.EAXREVERB_DECAY_TIME);
        eaxReverb.setAttribute(AL_EAXREVERB_DECAY_HFRATIO, def.EAXREVERB_DECAY_HFRATIO);
        eaxReverb.setAttribute(AL_EAXREVERB_DECAY_LFRATIO, def.EAXREVERB_DECAY_LFRATIO);
        eaxReverb.setAttribute(AL_EAXREVERB_REFLECTIONS_GAIN, def.EAXREVERB_REFLECTIONS_GAIN);
        eaxReverb.setAttribute(AL_EAXREVERB_REFLECTIONS_DELAY, def.EAXREVERB_REFLECTIONS_DELAY);
        eaxReverb.setAttribute(AL_EAXREVERB_LATE_REVERB_GAIN, def.EAXREVERB_LATE_REVERB_GAIN);
        eaxReverb.setAttribute(AL_EAXREVERB_LATE_REVERB_DELAY, def.EAXREVERB_LATE_REVERB_DELAY);
        eaxReverb.setAttribute(AL_EAXREVERB_ECHO_TIME, def.EAXREVERB_ECHO_TIME);
        eaxReverb.setAttribute(AL_EAXREVERB_ECHO_DEPTH, def.EAXREVERB_ECHO_DEPTH);
        eaxReverb.setAttribute(AL_EAXREVERB_MODULATION_TIME, def.EAXREVERB_MODULATION_TIME);
        eaxReverb.setAttribute(AL_EAXREVERB_MODULATION_DEPTH, def.EAXREVERB_MODULATION_DEPTH);
        eaxReverb.setAttribute(AL_EAXREVERB_AIR_ABSORPTION_GAINHF, def.EAXREVERB_AIR_ABSORPTION_GAINHF);
        eaxReverb.setAttribute(AL_EAXREVERB_HFREFERENCE, def.EAXREVERB_HFREFERENCE);
        eaxReverb.setAttribute(AL_EAXREVERB_LFREFERENCE, def.EAXREVERB_LFREFERENCE);
        eaxReverb.setAttribute(AL_EAXREVERB_ROOM_ROLLOFF_FACTOR, def.EAXREVERB_ROOM_ROLLOFF_FACTOR);
    }

    /**
     * This class contains definitions for constructing a chorus object
     *
     * Edit properties of a ChorusDef object then use {@link #createChorus()} or {@link #updateChorus(SoundEffect, ChorusDef)}
     * to transfer properties from ChorusDef to the effect object.
     */
    public class ChorusDef {
        /** Default Settings for Chorus effects */
        public int                              // [] denote the ranges of the values
                CHORUS_WAVEFORM = 1,            // [0,1]
                CHORUS_PHASE = 90;              // [-180,180]

        /** Default Settings for Chorus effects */
        public float
                CHORUS_RATE = 1.1f,             // [0.0f,10.0f]
                CHORUS_DEPTH = 0.1f,            // [0.0f,1.0f]
                CHORUS_FEEDBACK = 0.25f,        // [-1.0f,1.0f]
                CHORUS_DELAY = 0.016f;          // [0.0f,0.016f]
    }

    /**
     * Create a Chorus effect object based on the ChorusDef object
     *
     * @param def the ChorusDef object to create from
     */
    public SoundEffect createChorus(ChorusDef def) {
        SoundEffect chorus = new SoundEffect();
        updateChorus(chorus, def);
        return chorus;
    }

    /**
     * Create default Chorus object
     */
    public SoundEffect createChorus() {
        return createChorus(new ChorusDef());
    }

    /**
     * Update an existing chorus effect based on the ChorusDef
     *
     * @param chorus    the chorus effect to edit
     * @param def       the ChorusDef object to create from
     */
    public void updateChorus(SoundEffect chorus, ChorusDef def) {
        chorus.setAttribute(AL_EFFECT_TYPE, AL_EFFECT_CHORUS);
        chorus.setAttribute(AL_CHORUS_WAVEFORM,def.CHORUS_WAVEFORM);
        chorus.setAttribute(AL_CHORUS_PHASE,def.CHORUS_PHASE);
        chorus.setAttribute(AL_CHORUS_RATE,def.CHORUS_RATE);
        chorus.setAttribute(AL_CHORUS_DEPTH,def.CHORUS_DEPTH);
        chorus.setAttribute(AL_CHORUS_FEEDBACK,def.CHORUS_FEEDBACK);
        chorus.setAttribute(AL_CHORUS_DELAY,def.CHORUS_DELAY);
    }

    /**
     * This class contains definitions for constructing a distortion object
     *
     * Edit properties of a DistortionDef object then use {@link #createDistortion()} or {@link #updateDistortion(SoundEffect, DistortionDef)} )}
     * to transfer properties from DistortionDef to the effect object.
     */
    public class DistortionDef {
        /** Default Settings for Distortion effects */
        public float                                    // [] denote the ranges of the values
                DISTORTION_EDGE = 0.2f,                 // [0.0f,1.0f]
                DISTORTION_GAIN = 0.05f,                // [0.01f,1.0f]
                DISTORTION_LOWPASS_CUTOFF = 8000.0f,    // [80.0f,24000.0f]
                DISTORTION_EQCENTER = 3600.0f,          // [80.0f,24000.0f]
                DISTORTION_EQBANDWIDTH = 3600.0f;       // [80.0f,24000.0f]
    }

    /**
     * Create a Distortion effect object based on the DistortionDef object
     *
     * @param def the DistortionDef object to create from
     */
    public SoundEffect createDistortion(DistortionDef def) {
        SoundEffect distortion = new SoundEffect();
        updateDistortion(distortion, def);
        return distortion;
    }

    /**
     * Create default Distortion object
     */
    public SoundEffect createDistortion() {
        return createDistortion(new DistortionDef());
    }

    /**
     * Update an existing distortion effect based on the DistortionDef
     *
     * @param distortion    the distortion effect to edit
     * @param def       the distortion object to create from
     */
    public void updateDistortion(SoundEffect distortion, DistortionDef def) {
        distortion.setAttribute(AL_EFFECT_TYPE, AL_EFFECT_DISTORTION);
        distortion.setAttribute(AL_DISTORTION_EDGE, def.DISTORTION_EDGE);
        distortion.setAttribute(AL_DISTORTION_GAIN, def.DISTORTION_GAIN);
        distortion.setAttribute(AL_DISTORTION_LOWPASS_CUTOFF, def.DISTORTION_LOWPASS_CUTOFF);
        distortion.setAttribute(AL_DISTORTION_EQCENTER, def.DISTORTION_EQCENTER);
        distortion.setAttribute(AL_DISTORTION_EQBANDWIDTH, def.DISTORTION_EQBANDWIDTH);
    }

    /**
     * This class contains definitions for constructing an echo object
     *
     * Edit properties of a EchoDef object then use {@link #createEcho()} or {@link #updateEcho(SoundEffect, EchoDef)} )}
     * to transfer properties from EchoDef to the effect object.
     */
    public class EchoDef {
        /** Default Settings for Echo effects */
        public float                        // [] denote the ranges of the values
                ECHO_DELAY    = 0.1f,       // [0.0f,0.207f]
                ECHO_LRDELAY  = 0.1f,       // [0.0f, 0.404f]
                ECHO_DAMPING  = 0.5f,       // [0.0f,0.99f]
                ECHO_FEEDBACK = 0.5f,       // [0.0f, 1.0f]
                ECHO_SPREAD   = -1.0f;      // [-1.0f, 1.0f]
    }

    /**
     * Create an Echo effect object based on the EchoDef object
     *
     * @param def the EchoDef object to create from
     */
    public SoundEffect createEcho(EchoDef def) {
        SoundEffect echo = new SoundEffect();
        updateEcho(echo, def);
        return echo;
    }

    /**
     * Create default Echo object
     */
    public SoundEffect createEcho() {
        return createDistortion(new DistortionDef());
    }

    /**
     * Update an existing echo effect based on the EchoDef
     *
     * @param echo the echo effect to edit
     * @param def the echo object to create from
     */
    public void updateEcho(SoundEffect echo, EchoDef def) {
        echo.setAttribute(AL_EFFECT_TYPE, AL_EFFECT_ECHO);
        echo.setAttribute(AL_ECHO_DELAY, def.ECHO_DELAY);
        echo.setAttribute(AL_ECHO_LRDELAY, def.ECHO_LRDELAY);
        echo.setAttribute(AL_ECHO_DAMPING, def.ECHO_DAMPING);
        echo.setAttribute(AL_ECHO_FEEDBACK, def.ECHO_FEEDBACK);
        echo.setAttribute(AL_ECHO_SPREAD, def.ECHO_SPREAD);
    }

    /**
     * This class contains definitions for constructing a flanger object
     *
     * Edit properties of a FlangerDef object then use {@link #createFlanger()} or {@link #updateFlanger(SoundEffect, FlangerDef)} )}
     * to transfer properties from FlangerDef to the effect object.
     */
    public class FlangerDef {
        /** Default Settings for Flanger effects */
        public int                              // [] denote the ranges of the values
                FLANGER_WAVEFORM  = 1,          // [0,1]
                FLANGER_PHASE     = 0;          // [-180, 180]

        public float
                FLANGER_RATE     = 0.27f,       // [0.0f,10.0f]
                FLANGER_DEPTH    = 1.0f,        // [0.0f,1.0f]
                FLANGER_FEEDBACK = -0.5f,       // [-1.0f,1.0f]
                FLANGER_DELAY    = 0.002f;      //[0.0f,0.004f]
    }

    /**
     * Create an Flanger effect object based on the FlangerDef object
     *
     * @param def the FlangerDef object to create from
     */
    public SoundEffect createFlanger(FlangerDef def) {
        SoundEffect flanger = new SoundEffect();
        updateFlanger(flanger, def);
        return flanger;
    }

    /**
     * Create default Flanger object
     */
    public SoundEffect createFlanger() {
        return createFlanger(new FlangerDef());
    }

    /**
     * Update an existing flanger effect based on the FlangerDef
     *
     * @param flanger the flanger effect to edit
     * @param def the FlangerDef object to create from
     */
    public void updateFlanger(SoundEffect flanger, FlangerDef def) {
        flanger.setAttribute(AL_EFFECT_TYPE, AL_EFFECT_FLANGER);
        flanger.setAttribute(AL_FLANGER_WAVEFORM, def.FLANGER_WAVEFORM);
        flanger.setAttribute(AL_FLANGER_PHASE, def.FLANGER_PHASE);
        flanger.setAttribute(AL_FLANGER_RATE, def.FLANGER_RATE);
        flanger.setAttribute(AL_FLANGER_DEPTH, def.FLANGER_DEPTH);
        flanger.setAttribute(AL_FLANGER_FEEDBACK, def.FLANGER_FEEDBACK);
        flanger.setAttribute(AL_FLANGER_DELAY, def.FLANGER_DELAY);
    }

    /**
     * This class contains definitions for constructing a FrequencyShifter object
     *
     * Edit properties of a FreqShiftDef object then use {@link #createFreqShift()} or {@link #updateFreqShift(SoundEffect, FreqShiftDef)} )}
     * to transfer properties from FreqShiftDef to the effect object.
     */
    public class FreqShiftDef {
        /** Default Settings for frequency shifter effects */
        public float                                        // [] denote the ranges of the values
                FREQUENCY_SHIFTER_FREQUENCY = 0.0f;         //[0.0f,24000.0f]
        public int                                          // For the two options below: DOWN = 0, UP = 1, OFF = 2
                FREQUENCY_SHIFTER_LEFT_DIRECTION  = 0,      // [0,2]
                FREQUENCY_SHIFTER_RIGHT_DIRECTION = 0;      // [0,2]
    }

    /**
     * Create an FreqShift effect object based on the FreqShiftDef object
     *
     * @param def the FreqShiftDef object to create from
     */
    public SoundEffect createFreqShift(FreqShiftDef def) {
        SoundEffect freqShift = new SoundEffect();
        updateFreqShift(freqShift, def);
        return freqShift;
    }

    /**
     * Create default FreqShift object
     */
    public SoundEffect createFreqShift() {
        return createFreqShift(new FreqShiftDef());
    }

    /**
     * Update an existing freqShift effect based on the FreqShiftDef
     *
     * @param freqShift the freqShift effect to edit
     * @param def the FreqShiftDef object to create from
     */
    public void updateFreqShift(SoundEffect freqShift,FreqShiftDef def) {
        freqShift.setAttribute(AL_EFFECT_TYPE, AL_EFFECT_FREQUENCY_SHIFTER);
        freqShift.setAttribute(AL_FREQUENCY_SHIFTER_FREQUENCY,def.FREQUENCY_SHIFTER_FREQUENCY);
        freqShift.setAttribute(AL_FREQUENCY_SHIFTER_LEFT_DIRECTION,def.FREQUENCY_SHIFTER_LEFT_DIRECTION);
        freqShift.setAttribute(AL_FREQUENCY_SHIFTER_RIGHT_DIRECTION,def.FREQUENCY_SHIFTER_RIGHT_DIRECTION);
    }

    /**
     * This class contains definitions for constructing a VocalMorpher object
     *
     * Edit properties of a VocalMorpherDef object then use {@link #createVocalMorpher()} or {@link #updateVocalMorpher(SoundEffect, VocalMorpherDef)} )}
     * to transfer properties from VocalMorpherDef to the effect object.
     */
    public class VocalMorpherDef {
        /** Default Settings for vocal morpher effects */
        public float                            // [] denote the ranges of the values
                VOCAL_MORPHER_RATE = 1.41f;     // [0.0f,10.0f]
        public int
                /*  For the four options below:
                    AL_VOCAL_MORPHER_PHONEME_A                      = 0,
                    AL_VOCAL_MORPHER_PHONEME_E                      = 1,
                    AL_VOCAL_MORPHER_PHONEME_I                      = 2,
                    AL_VOCAL_MORPHER_PHONEME_O                      = 3,
                    AL_VOCAL_MORPHER_PHONEME_U                      = 4,
                    AL_VOCAL_MORPHER_PHONEME_AA                     = 5,
                    AL_VOCAL_MORPHER_PHONEME_AE                     = 6,
                    AL_VOCAL_MORPHER_PHONEME_AH                     = 7,
                    AL_VOCAL_MORPHER_PHONEME_AO                     = 8,
                    AL_VOCAL_MORPHER_PHONEME_EH                     = 9,
                    AL_VOCAL_MORPHER_PHONEME_ER                     = 10,
                    AL_VOCAL_MORPHER_PHONEME_IH                     = 11,
                    AL_VOCAL_MORPHER_PHONEME_IY                     = 12,
                    AL_VOCAL_MORPHER_PHONEME_UH                     = 13,
                    AL_VOCAL_MORPHER_PHONEME_UW                     = 14,
                    AL_VOCAL_MORPHER_PHONEME_B                      = 15,
                    AL_VOCAL_MORPHER_PHONEME_D                      = 16,
                    AL_VOCAL_MORPHER_PHONEME_F                      = 17,
                    AL_VOCAL_MORPHER_PHONEME_G                      = 18,
                    AL_VOCAL_MORPHER_PHONEME_J                      = 19,
                    AL_VOCAL_MORPHER_PHONEME_K                      = 20,
                    AL_VOCAL_MORPHER_PHONEME_L                      = 21,
                    AL_VOCAL_MORPHER_PHONEME_M                      = 22,
                    AL_VOCAL_MORPHER_PHONEME_N                      = 23,
                    AL_VOCAL_MORPHER_PHONEME_P                      = 24,
                    AL_VOCAL_MORPHER_PHONEME_R                      = 25,
                    AL_VOCAL_MORPHER_PHONEME_S                      = 26,
                    AL_VOCAL_MORPHER_PHONEME_T                      = 27,
                    AL_VOCAL_MORPHER_PHONEME_V                      = 28,
                    AL_VOCAL_MORPHER_PHONEME_Z                      = 29,
                */
                VOCAL_MORPHER_PHONEMEA               = 0,   // [0,29]
                VOCAL_MORPHER_PHONEMEA_COARSE_TUNING = 0,   // [-24,24]
                VOCAL_MORPHER_PHONEMEB               = 10,  // [0,29]
                VOCAL_MORPHER_PHONEMEB_COARSE_TUNING = 0,   // [-24,24]
                VOCAL_MORPHER_WAVEFORM               = 0;   // [0,2]
    }

    /**
     * Create an VocalMorpher effect object based on the VocalMorpher object
     *
     * @param def the VocalMorpherDef object to create from
     */
    public SoundEffect createVocalMorpher(VocalMorpherDef def) {
        SoundEffect vocalMorpher = new SoundEffect();
        updateVocalMorpher(vocalMorpher, def);
        return vocalMorpher;
    }

    /**
     * Create default VocalMorpher object
     */
    public SoundEffect createVocalMorpher() {
        return createVocalMorpher(new VocalMorpherDef());
    }

    /**
     * Update an existing vocalMorpher effect based on the VocalMorpherDef
     *
     * @param vocalMorpher the vocalMorpher effect to edit
     * @param def the VocalMorpherDef object to create from
     */
    public void updateVocalMorpher(SoundEffect vocalMorpher,VocalMorpherDef def) {
        vocalMorpher.setAttribute(AL_EFFECT_TYPE, AL_EFFECT_VOCAL_MORPHER);
        vocalMorpher.setAttribute(AL_VOCMORPHER_RATE,def.VOCAL_MORPHER_RATE);
        vocalMorpher.setAttribute(AL_VOCMORPHER_PHONEMEA,def.VOCAL_MORPHER_PHONEMEA);
        vocalMorpher.setAttribute(AL_VOCMORPHER_PHONEMEB,def.VOCAL_MORPHER_PHONEMEB);
        vocalMorpher.setAttribute(AL_VOCMORPHER_WAVEFORM,def.VOCAL_MORPHER_WAVEFORM);
        vocalMorpher.setAttribute(AL_VOCMORPHER_PHONEMEA_COARSE_TUNING,def.VOCAL_MORPHER_PHONEMEA_COARSE_TUNING);
        vocalMorpher.setAttribute(AL_VOCMORPHER_PHONEMEB_COARSE_TUNING,def.VOCAL_MORPHER_PHONEMEB_COARSE_TUNING);
    }

    /**
     * This class contains definitions for constructing a Pitch Shifter object
     *
     * Edit properties of a PitchShifterDef object then use {@link #createPitchShifter()} or {@link #updatePitchShifter(SoundEffect, PitchShifterDef)} )}
     * to transfer properties from PitchShifterDef to the effect object.
     */
    public class PitchShifterDef {
        /** Default Settings for pitch shifter effects */
        public int                                          // [] denote the ranges of the values
                AL_PITCH_SHIFTER_DEFAULT_COARSE_TUNE = 12,  // [-12,12]
                AL_PITCH_SHIFTER_DEFAULT_FINE_TUNE   = 0;   // [-50,50]
    }

    /**
     * Create an PitchShifter effect object based on the PitchShifter object
     *
     * @param def the PitchShifterDef object to create from
     */
    public SoundEffect createPitchShifter(PitchShifterDef def) {
        SoundEffect pitchShifter = new SoundEffect();
        updatePitchShifter(pitchShifter, def);
        return pitchShifter;
    }

    /**
     * Create default PitchShifter object
     */
    public SoundEffect createPitchShifter() {
        return createPitchShifter(new PitchShifterDef());
    }

    /**
     * Update an existing PitchShifter effect based on the PitchShifterDef
     *
     * @param pitchShifter the pitchShifter effect to edit
     * @param def the PitchShifterDef object to create from
     */
    public void updatePitchShifter(SoundEffect pitchShifter,PitchShifterDef def) {
        pitchShifter.setAttribute(AL_EFFECT_TYPE, AL_EFFECT_PITCH_SHIFTER);
        pitchShifter.setAttribute(AL_PITCH_SHIFTER_COARSE_TUNE,def.AL_PITCH_SHIFTER_DEFAULT_COARSE_TUNE);
        pitchShifter.setAttribute(AL_PITCH_SHIFTER_FINE_TUNE,def.AL_PITCH_SHIFTER_DEFAULT_FINE_TUNE);
    }

    /**
     * This class contains definitions for constructing a Ring Modulator object
     *
     * Edit properties of a RingModDef object then use {@link #createRingMod()} or {@link #updateRingMod(SoundEffect, RingModDef)} )}
     * to transfer properties from RingModDef to the effect object.
     */
    public class RingModDef {
        /** Default Settings for ring modulator effects */
        public float                                        // [] denote the ranges of the values
                RING_MODULATOR_FREQUENCY       = 440.0f,    // [0.0f,8000.0f]
                RING_MODULATOR_HIGHPASS_CUTOFF = 800.0f;    // [0.0f,24000.0f]

        public int
                RING_MODULATOR_WAVEFORM = 0;                // [0,2]
    }

    /**
     * Create a RingModulator effect object based on the RingModDef object
     *
     * @param def the RingModDef object to create from
     */
    public SoundEffect createRingMod(RingModDef def) {
        SoundEffect ringMod = new SoundEffect();
        updateRingMod(ringMod, def);
        return ringMod;
    }

    /**
     * Create default Ring Modulator object
     */
    public SoundEffect createRingMod() {
        return createRingMod(new RingModDef());
    }

    /**
     * Update an existing RingModulator effect based on the RingModDef
     *
     * @param ringMod the RingMod effect to edit
     * @param def the RingModDef object to create from
     */
    public void updateRingMod(SoundEffect ringMod,RingModDef def) {
        ringMod.setAttribute(AL_EFFECT_TYPE, AL_EFFECT_RING_MODULATOR);
        ringMod.setAttribute(AL_RING_MODULATOR_FREQUENCY,def.RING_MODULATOR_FREQUENCY);
        ringMod.setAttribute(AL_RING_MODULATOR_HIGHPASS_CUTOFF,def.RING_MODULATOR_HIGHPASS_CUTOFF);
        ringMod.setAttribute(AL_RING_MODULATOR_WAVEFORM,def.RING_MODULATOR_WAVEFORM);
    }

    
    /**
     * This class contains definitions for constructing a AutoWAH object
     *
     * Edit properties of a AutoWAHDef object then use {@link #createAutoWAH()} or {@link #updateAutoWAH(SoundEffect, AutoWAHDef)} )}
     * to transfer properties from AutoWAHDef to the effect object.
     */
    public class AutoWAHDef {
        /** Default Settings for AutoWAH effects */
        public float                            // [] denote the ranges of the values
                AUTOWAH_ATTACK_TIME  = 0.06f,   // [1.0E-4f,1.0f]
                AUTOWAH_RELEASE_TIME = 0.06f,   // [1.0E-4f,1.0f]
                AUTOWAH_RESONANCE    = 1000.0f, // [2.0f,1000.0f]
                AUTOWAH_PEAK_GAIN    = 11.22f;  // [3.0E-5f,31621.0]
    }

    /**
     * Create a AutoWAH effect object based on the AutoWAHDef object
     *
     * @param def the AutoWAHDef object to create from
     */
    public SoundEffect createAutoWAH(AutoWAHDef def) {
        SoundEffect AutoWAH = new SoundEffect();
        updateAutoWAH(AutoWAH, def);
        return AutoWAH;
    }

    /**
     * Create default AutoWAH object
     */
    public SoundEffect createAutoWAH() {
        return createAutoWAH(new AutoWAHDef());
    }

    /**
     * Update an existing AutoWAH effect based on the AutoWAHDef
     *
     * @param AutoWAH the AutoWAH effect to edit
     * @param def the AutoWAHDef object to create from
     */
    public void updateAutoWAH(SoundEffect AutoWAH,AutoWAHDef def) {
        AutoWAH.setAttribute(AL_EFFECT_TYPE, AL_EFFECT_AUTOWAH);
        AutoWAH.setAttribute(AL_AUTOWAH_ATTACK_TIME,def.AUTOWAH_ATTACK_TIME);
        AutoWAH.setAttribute(AL_AUTOWAH_RELEASE_TIME,def.AUTOWAH_RELEASE_TIME);
        AutoWAH.setAttribute(AL_AUTOWAH_RESONANCE,def.AUTOWAH_RESONANCE);
        AutoWAH.setAttribute(AL_AUTOWAH_PEAK_GAIN,def.AUTOWAH_PEAK_GAIN);
    }

    /**
     * This class contains definitions for constructing a Compressor object
     *
     * Edit properties of a CompressorDef object then use {@link #createCompressor()} or {@link #updateCompressor(SoundEffect, CompressorDef)} )}
     * to transfer properties from CompressorDef to the effect object.
     */
    public class CompressorDef {
        /** Default Settings for Compressor effects */
        public float                                // [] denote the ranges of the values
                AL_COMPRESSOR_DEFAULT_ONOFF = 1;    // [0,1]
    }

    /**
     * Create a Compressor effect object based on the CompressorDef object
     *
     * @param def the CompressorDef object to create from
     */
    public SoundEffect createCompressor(CompressorDef def) {
        SoundEffect Compressor = new SoundEffect();
        updateCompressor(Compressor, def);
        return Compressor;
    }

    /**
     * Create default Compressor object
     */
    public SoundEffect createCompressor() {
        return createCompressor(new CompressorDef());
    }

    /**
     * Update an existing Compressor effect based on the CompressorDef
     *
     * @param Compressor the Compressor effect to edit
     * @param def the CompressorDef object to create from
     */
    public void updateCompressor(SoundEffect Compressor,CompressorDef def) {
        Compressor.setAttribute(AL_EFFECT_TYPE, AL_EFFECT_COMPRESSOR);
        Compressor.setAttribute(AL_COMPRESSOR_ONOFF,def.AL_COMPRESSOR_DEFAULT_ONOFF);
    }

    /**
     * This class contains definitions for constructing a Equalizer object
     *
     * Edit properties of a EqualizerDef object then use {@link #createEqualizer()} or {@link #updateEqualizer(SoundEffect, EqualizerDef)} )}
     * to transfer properties from EqualizerDef to the effect object.
     */
    public class EqualizerDef {
        /** Default Settings for Equalizer effects */
        public float                                // [] denote the ranges of the values
                EQUALIZER_LOW_GAIN    = 1.0f,       // [0.126f,7.943f]
                EQUALIZER_LOW_CUTOFF  = 200.0f,     // [50.0f, 800.0f]
                EQUALIZER_MID1_GAIN   = 1.0f,       // [0.126f,7.943f]
                EQUALIZER_MID1_CENTER = 500.0f,     // [200.0f,3000.0f]
                EQUALIZER_MID1_WIDTH  = 1.0f,       // [0.01f,1.0f]
                EQUALIZER_MID2_GAIN   = 1.0f,       // [0.126f,7.943f]
                EQUALIZER_MID2_CENTER = 3000.0f,    // [1000.0f,8000.0f]
                EQUALIZER_MID2_WIDTH  = 1.0f,       // [0.01f,1.0f]
                EQUALIZER_HIGH_GAIN   = 1.0f,       // [0.126f,7.943f]
                EQUALIZER_HIGH_CUTOFF = 6000.0f;    // [4000.0f,16000.0f]
    }

    /**
     * Create a Equalizer effect object based on the EqualizerDef object
     *
     * @param def the EqualizerDef object to create from
     */
    public SoundEffect createEqualizer(EqualizerDef def) {
        SoundEffect Equalizer = new SoundEffect();
        updateEqualizer(Equalizer, def);
        return Equalizer;
    }

    /**
     * Create default Equalizer object
     */
    public SoundEffect createEqualizer() {
        return createEqualizer(new EqualizerDef());
    }

    /**
     * Update an existing Equalizer effect based on the EqualizerDef
     *
     * @param Equalizer the Equalizer effect to edit
     * @param def the EqualizerDef object to create from
     */
    public void updateEqualizer(SoundEffect Equalizer,EqualizerDef def) {
        Equalizer.setAttribute(AL_EFFECT_TYPE, AL_EFFECT_EQUALIZER);
        Equalizer.setAttribute(AL_EQUALIZER_LOW_GAIN,def.EQUALIZER_LOW_GAIN);
        Equalizer.setAttribute(AL_EQUALIZER_LOW_CUTOFF,def.EQUALIZER_LOW_CUTOFF);
        Equalizer.setAttribute(AL_EQUALIZER_MID1_GAIN,def.EQUALIZER_MID1_GAIN);
        Equalizer.setAttribute(AL_EQUALIZER_MID1_CENTER,def.EQUALIZER_MID1_CENTER);
        Equalizer.setAttribute(AL_EQUALIZER_MID1_WIDTH,def.EQUALIZER_MID1_WIDTH);
        Equalizer.setAttribute(AL_EQUALIZER_MID2_GAIN,def.EQUALIZER_MID2_GAIN);
        Equalizer.setAttribute(AL_EQUALIZER_MID2_CENTER,def.EQUALIZER_MID2_CENTER);
        Equalizer.setAttribute(AL_EQUALIZER_MID2_WIDTH,def.EQUALIZER_MID2_WIDTH);
        Equalizer.setAttribute(AL_EQUALIZER_HIGH_GAIN,def.EQUALIZER_HIGH_GAIN);
        Equalizer.setAttribute(AL_EQUALIZER_HIGH_CUTOFF,def.EQUALIZER_HIGH_CUTOFF);
    }
}