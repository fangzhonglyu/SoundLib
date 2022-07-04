package edu.cornell.gdiac.audio;

/**
 * This is a factory class for creating {@link EffectFilter} Objects
 *
 * The following openAL effects are supported,
 * for more details on effect parameters, see openAL
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
public interface EffectFactory {
    /**
     * This class contains definitions for constructing a reverb object
     *
     * Edit properties of a ReverbDef object then use {@link #createReverb()} or {@link #updateReverb(EffectFilter, ReverbDef)}
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
    public EffectFilter createReverb(ReverbDef def);

    /**
     * Create default reverb object
     */
    public EffectFilter createReverb();
    /**
     * Update an existing reverb effect based on the ReverbDef
     *
     * @param reverb the reverb effect to edit
     * @param def    the ReverbDef object to create from
     */
    public void updateReverb(EffectFilter reverb, ReverbDef def);

    /**
     * This class contains definitions for constructing a EAXReverb object
     *
     * Edit properties of a EAXReverbDef object then use {@link #createEAXReverb()} or {@link #updateEAXReverb(EffectFilter, EAXReverbDef)}
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
    public EffectFilter createEAXReverb(EAXReverbDef def);

    /**
     * Create default EAXReverb object
     */
    public EffectFilter createEAXReverb();

    /**
     * Update an existing EAXReverb effect based on the EAXReverbDef
     *
     * @param eaxReverb the EaxReverb effect to edit
     * @param def       the EAxReverbDef object to create from
     */
    public void updateEAXReverb(EffectFilter eaxReverb, EAXReverbDef def);

    /**
     * This class contains definitions for constructing a chorus object
     *
     * Edit properties of a ChorusDef object then use {@link #createChorus()} or {@link #updateChorus(EffectFilter, ChorusDef)}
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
    public EffectFilter createChorus(ChorusDef def);

    /**
     * Create default Chorus object
     */
    public EffectFilter createChorus();

    /**
     * Update an existing chorus effect based on the ChorusDef
     *
     * @param chorus    the chorus effect to edit
     * @param def       the ChorusDef object to create from
     */
    public void updateChorus(EffectFilter chorus, ChorusDef def);

    /**
     * This class contains definitions for constructing a distortion object
     *
     * Edit properties of a DistortionDef object then use {@link #createDistortion()} or {@link #updateDistortion(EffectFilter, DistortionDef)} )}
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
    public EffectFilter createDistortion(DistortionDef def);

    /**
     * Create default Distortion object
     */
    public EffectFilter createDistortion();

    /**
     * Update an existing distortion effect based on the DistortionDef
     *
     * @param distortion    the distortion effect to edit
     * @param def       the distortion object to create from
     */
    public void updateDistortion(EffectFilter distortion, DistortionDef def);

    /**
     * This class contains definitions for constructing an echo object
     *
     * Edit properties of a EchoDef object then use {@link #createEcho()} or {@link #updateEcho(EffectFilter, EchoDef)} )}
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
    public EffectFilter createEcho(EchoDef def) ;

    /**
     * Create default Echo object
     */
    public EffectFilter createEcho();

    /**
     * Update an existing echo effect based on the EchoDef
     *
     * @param echo the echo effect to edit
     * @param def the echo object to create from
     */
    public void updateEcho(EffectFilter echo, EchoDef def);

    /**
     * This class contains definitions for constructing a flanger object
     *
     * Edit properties of a FlangerDef object then use {@link #createFlanger()} or {@link #updateFlanger(EffectFilter, FlangerDef)} )}
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
    public EffectFilter createFlanger(FlangerDef def);

    /**
     * Create default Flanger object
     */
    public EffectFilter createFlanger();

    /**
     * Update an existing flanger effect based on the FlangerDef
     *
     * @param flanger the flanger effect to edit
     * @param def the FlangerDef object to create from
     */
    public void updateFlanger(EffectFilter flanger, FlangerDef def);

    /**
     * This class contains definitions for constructing a FrequencyShifter object
     *
     * Edit properties of a FreqShiftDef object then use {@link #createFreqShift()} or {@link #updateFreqShift(EffectFilter, FreqShiftDef)} )}
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
    public EffectFilter createFreqShift(FreqShiftDef def);

    /**
     * Create default FreqShift object
     */
    public EffectFilter createFreqShift();

    /**
     * Update an existing freqShift effect based on the FreqShiftDef
     *
     * @param freqShift the freqShift effect to edit
     * @param def the FreqShiftDef object to create from
     */
    public void updateFreqShift(EffectFilter freqShift, FreqShiftDef def);

    /**
     * This class contains definitions for constructing a VocalMorpher object
     *
     * Edit properties of a VocalMorpherDef object then use {@link #createVocalMorpher()} or {@link #updateVocalMorpher(EffectFilter, VocalMorpherDef)} )}
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
    public EffectFilter createVocalMorpher(VocalMorpherDef def);

    /**
     * Create default VocalMorpher object
     */
    public EffectFilter createVocalMorpher();

    /**
     * Update an existing vocalMorpher effect based on the VocalMorpherDef
     *
     * @param vocalMorpher the vocalMorpher effect to edit
     * @param def the VocalMorpherDef object to create from
     */
    public void updateVocalMorpher(EffectFilter vocalMorpher, VocalMorpherDef def);

    /**
     * This class contains definitions for constructing a Pitch Shifter object
     *
     * Edit properties of a PitchShifterDef object then use {@link #createPitchShifter()} or {@link #updatePitchShifter(EffectFilter, PitchShifterDef)} )}
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
    public EffectFilter createPitchShifter(PitchShifterDef def);

    /**
     * Create default PitchShifter object
     */
    public EffectFilter createPitchShifter();

    /**
     * Update an existing PitchShifter effect based on the PitchShifterDef
     *
     * @param pitchShifter the pitchShifter effect to edit
     * @param def the PitchShifterDef object to create from
     */
    public void updatePitchShifter(EffectFilter pitchShifter, PitchShifterDef def);

    /**
     * This class contains definitions for constructing a Ring Modulator object
     *
     * Edit properties of a RingModDef object then use {@link #createRingMod()} or {@link #updateRingMod(EffectFilter, RingModDef)} )}
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
    public EffectFilter createRingMod(RingModDef def);

    /**
     * Create default Ring Modulator object
     */
    public EffectFilter createRingMod();

    /**
     * Update an existing RingModulator effect based on the RingModDef
     *
     * @param ringMod the RingMod effect to edit
     * @param def the RingModDef object to create from
     */
    public void updateRingMod(EffectFilter ringMod, RingModDef def);


    /**
     * This class contains definitions for constructing a AutoWAH object
     *
     * Edit properties of a AutoWAHDef object then use {@link #createAutoWAH()} or {@link #updateAutoWAH(EffectFilter, AutoWAHDef)} )}
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
    public EffectFilter createAutoWAH(AutoWAHDef def);

    /**
     * Create default AutoWAH object
     */
    public EffectFilter createAutoWAH();

    /**
     * Update an existing AutoWAH effect based on the AutoWAHDef
     *
     * @param AutoWAH the AutoWAH effect to edit
     * @param def the AutoWAHDef object to create from
     */
    public void updateAutoWAH(EffectFilter AutoWAH, AutoWAHDef def);

    /**
     * This class contains definitions for constructing a Compressor object
     *
     * Edit properties of a CompressorDef object then use {@link #createCompressor()} or {@link #updateCompressor(EffectFilter, CompressorDef)} )}
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
    public EffectFilter createCompressor(CompressorDef def);

    /**
     * Create default Compressor object
     */
    public EffectFilter createCompressor();

    /**
     * Update an existing Compressor effect based on the CompressorDef
     *
     * @param Compressor the Compressor effect to edit
     * @param def the CompressorDef object to create from
     */
    public void updateCompressor(EffectFilter Compressor, CompressorDef def);

    /**
     * This class contains definitions for constructing a Equalizer object
     *
     * Edit properties of a EqualizerDef object then use {@link #createEqualizer()} or {@link #updateEqualizer(EffectFilter, EqualizerDef)} )}
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
    public EffectFilter createEqualizer(EqualizerDef def);

    /**
     * Create default Equalizer object
     */
    public EffectFilter createEqualizer();

    /**
     * Update an existing Equalizer effect based on the EqualizerDef
     *
     * @param Equalizer the Equalizer effect to edit
     * @param def the EqualizerDef object to create from
     */
    public void updateEqualizer(EffectFilter Equalizer, EqualizerDef def);
}
