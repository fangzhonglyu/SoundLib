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
     * This class contains definitions for constructing a reverberation sound effect
     *
     * Edit properties of a ReverbDef object then use {@link #createReverb()} or {@link #updateReverb(EffectFilter, ReverbDef)}
     * to transfer properties from ReverbDef to the effect object.
     */
    public class ReverbDef {

        // Below are the default Settings for reverb effects
        // [] denote the ranges of the values

        /**
         * Reverb density controls the coloration of the late reverb.
         * Lowering the value adds more coloration to the late reverb.
         *
         * MAX: 1.0f
         * MIN: 0.0f
         */
        public float REVERB_DENSITY = 1.0f,

        /**
         * Reverb diffusion controls the echo density in the reverberation decay.
         * Reducing diffusion gives the reverberation a more “grainy” character that is especially noticeable with
         * percussive sound sources.
         * Setting the diffusion to 0.0f will make reverberation sound like a succession of distinct echoes.
         *
         * MAX: 1.0f
         * MIN: 0.0f
         */
            REVERB_DIFFUSION = 1.0f,

        /**
         * The Reverb Gain property is the master volume control for the reflected sound (both early reflections and
         * reverberation) that the reverb effect adds to all sound sources. It sets the maximum amount of reflections
         * and reverberation added to the final sound mix.
         *
         * MAX: 1.0f (0db)
         * MIN: 0.0f (-100db)
         */
            REVERB_GAIN = 0.32f,

        /**
         * The Reverb Gain HF property further tweaks reflected sound by attenuating it at high frequencies. It controls
         * a low-pass filter that applies globally to the reflected sound of all sound sources feeding the particular
         * instance of the reverb effect.
         *
         * MAX: 1.0f (0db)
         * MIN: 0.0f (-100db)
         */
            REVERB_GAINHF = 0.89f,
        /**
         * The Decay Time property sets the reverberation decay time.
         *
         * MAX: 20.0f
         * MIN: 0.1f
         */
            REVERB_DECAY_TIME = 1.49f,

        /**
         * The Decay HF Ratio property sets the spectral quality of the Decay Time parameter. It is the ratio of
         * high-frequency decay time relative to the time set by Decay Time.
         *
         * The Decay HF Ratio value 1.0 is neutral: the decay time is equal for all frequencies. As Decay HF Ratio
         * increases above 1.0, the high-frequency decay time increases, so it’s longer than the decay time at low
         * frequencies. You hear a more brilliant reverberation with a longer decay at high frequencies. As the Decay
         * HF Ratio value decreases below 1.0, the high-frequency decay time decreases, so it’s shorter than the decay
         * time of the low frequencies. You hear a more natural reverberation.
         *
         * MAX: 2.0f
         * MIN: 0.1f
         */
            REVERB_DECAY_HFRATIO = 0.83f,

        /**
         * The Reflections Gain property controls the overall amount of initial reflections relative to the Gain
         * property.
         *
         * You can increase the amount of initial reflections to simulate a more narrow space or closer
         * walls, especially effective if you associate the initial reflections increase with a reduction in
         * reflections delays by lowering the value of the Reflection Delay property. To simulate open or semi-open
         * environments, you can maintain the amount of early reflections while reducing the value of the Late Reverb
         * Gain property, which controls later reflections.
         *
         * MAX: 3.16f (+10db)
         * MIN: 0.0f (-100db)
         */
            REVERB_REFLECTIONS_GAIN = 0.05f,

        /**
         * The Reflections Delay property is the amount of delay between the arrival time of the direct path from the
         * source to the first reflection from the source.
         *
         * You can reduce or increase Reflections Delay to simulate closer or more distant reflective surfaces—and
         * therefore control the perceived size of the room.
         *
         * MAX: 0.3f (300ms)
         * MIN: 0.0f (0ms)
         */
            REVERB_REFLECTIONS_DELAY = 0.007f,

        /**
         * The Late Reverb Gain property controls the overall amount of later reverberation relative to the Gain
         * property. (The Gain property sets the overall amount of both initial reflections and later reverberation.)
         *
         * MAX: 10.0f (+20db)
         * MIN: 0.0f (-100db)
         */
            REVERB_LATE_REVERB_GAIN = 1.26f,

        /**
         * The Late Reverb Delay property defines the begin time of the late reverberation relative to the time of the
         * initial reflection (the first of the early reflections).
         *
         * MAX: 0.1f (100ms)
         * MIN: 0.0f (0ms)
         */
            REVERB_LATE_REVERB_DELAY = 0.011f,

        /**
         * The Air Absorption Gain HF property controls the distance-dependent attenuation at high frequencies caused
         * by the propagation medium. It applies to reflected sound only.
         *
         * You can use Air Absorption Gain HF to simulate sound transmission through foggy air, dry air, smoky
         * atmosphere, and so on. The default value is 0.994 (-0.05 dB) per meter, which roughly corresponds to typical
         * condition of atmospheric humidity, temperature, and so on. Lowering the value simulates a more absorbent
         * medium (more humidity in the air, for example); raising the value simulates a less absorbent medium
         * (dry desert air, for example).
         *
         * MAX: 1.0f
         * MIN: 0.892f
         */
            REVERB_AIR_ABSORPTION_GAINHF = 0.994f,

        /**
         * The Room Rolloff Factor property is one of two methods available to attenuate the reflected sound
         * (containing both reflections and reverberation) according to source-listener distance.
         *
         * Setting the Room Rolloff Factor value to 1.0 specifies that the reflected sound will decay by 6 dB every
         * time the distance doubles. Any value other than 1.0 is equivalent to a scaling factor applied to the
         * quantity specified by ((Source listener distance) - (Reference Distance)). Reference Distance is an OpenAL
         * source parameter that specifies the inner border for distance rolloff effects: if the source comes closer to
         * the listener than the reference distance, the direct-path sound isn’t increased as the source comes closer
         * to the listener, and neither is the reflected sound.
         *
         * MAX: 10.0f
         * MIN: 0.0f
         */
            REVERB_ROOM_ROLLOFF_FACTOR = 0.0f;
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
     * EAXReverb is a superset of the standard reverb effect with additional control over the reverb tone,
     * reverb directivity, and reverb granularity.
     *
     * The EAX Reverb is natively supported on any devices that support the EAX 3.0 or above standard, including:
     * SoundBlaster Audigy series soundcards
     * SoundBlaster X-Fi series soundcards
     *
     * The EAX Reverb will be emulated on devices that only support EAX 2.0. Note: The “Generic Software” device falls
     * into this category as the software mixer supports the EAX 2.0 Reverb effect.
     *
     * Edit properties of a EAXReverbDef object then use {@link #createEAXReverb()} or {@link #updateEAXReverb(EffectFilter, EAXReverbDef)}
     * to transfer properties from EAXReverbDef to the effect object.
     */
    public class EAXReverbDef {
        // Default Settings for EAX reverb effects
        /** These settings are the same as their standard reverb counterparts, refer to {@link ReverbDef} */
        public float                                        // [] denote the ranges of the values
                EAXREVERB_DENSITY = 1.0f,                   // [0.0f,1.0f]
                EAXREVERB_DIFFUSION = 1.0f,                 // [0.0f,1.0f]
                EAXREVERB_GAIN = 0.32f,                     // [0.0f,1.0f]
                EAXREVERB_GAINHF = 0.89f,                   // [0.0f,1.0f]
                EAXREVERB_DECAY_TIME = 1.49f,               // [0.1f,20.0f]
                EAXREVERB_DECAY_HFRATIO = 0.83f,            // [0.1f,2.0f]
                EAXREVERB_REFLECTIONS_GAIN = 0.05f,         // [0.0f,3.16f]
                EAXREVERB_REFLECTIONS_DELAY = 0.007f,       // [0.0f,0.3f]
                EAXREVERB_LATE_REVERB_GAIN = 1.26f,         // [0.0f,10.0f]
                EAXREVERB_LATE_REVERB_DELAY = 0.011f,       // [0.0f,0.1f]
                EAXREVERB_AIR_ABSORPTION_GAINHF = 0.994f,   // [0.892f,1.0f]
                EAXREVERB_ROOM_ROLLOFF_FACTOR = 0.0f;       // [0.0f,10.0f]

        /**
         * The Reverb Gain LF property further tweaks reflected sound by attenuating it at low frequencies.
         *
         * It controls a high-pass filter that applies globally to the reflected sound of all sound sources feeding the
         * particular instance of the reverb effect.
         * ({@link #EAXREVERB_LFREFERENCE } sets the frequency at which the value of this property is measured.)
         *
         * MAX: 1.0f (0db)
         * MIN: 0.0f (-100db)
         */
        public float EAXREVERB_GAINLF = 1.0f,                    // [0.0f,1.0f]

        /**
         * The Decay LF Ratio property adjusts the spectral quality of the Decay Time parameter.
         *
         * It is the ratio of low-frequency decay time relative to the time set by Decay Time.
         * The Decay LF Ratio value 1.0 is neutral: the decay time is equal for all frequencies.
         * As Decay LF Ratio increases above 1.0, the low-frequency decay time increases so it’s longer than the decay
         * time at mid frequencies. You hear a more booming reverberation with a longer decay at low frequencies.
         * As the Decay LF Ratio value decreases below 1.0, the low-frequency decay time decreases so it’s shorter
         * than the decay time of the mid frequencies. You hear a more tinny reverberation.
         *
         * MAX: 2.0f
         * MIN: 0.1f
         */
            EAXREVERB_DECAY_LFRATIO = 1.0f,

        /**
         * Echo Depth introduces a cyclic echo in the reverberation decay, which will be noticeable with transient or
         * percussive sounds. A larger value of Echo Depth will make this effect more prominent.
         *
         * MAX: 1.0f
         * MIN: 0.0f
         */
            EAXREVERB_ECHO_DEPTH = 0.0f,

        /**
         * Echo Time controls the rate at which the cyclic echo repeats itself along the reverberation decay.
         * For example, the default setting for Echo Time is 250 ms. causing the echo to occur 4 times per second.
         * Therefore, if you were to clap your hands in this type of environment, you will hear four repetitions of
         * clap per second.
         *
         * MAX: 0.25f
         * MIN: 0.075f
         */
            EAXREVERB_ECHO_TIME = 0.25f,

        /**
         * Using Modulation time and Modulation Depth, you can create a pitch modulation in the reverberant sound.
         * This will be most noticeable applied to sources that have tonal color or pitch. You can use this to make
         * some trippy effects!
         *
         * Modulation Time controls the speed of the vibrato (rate of periodic changes in pitch).
         *
         * MAX: 4.0f
         * MIN: 0.04f
         */
            EAXREVERB_MODULATION_TIME = 0.25f,          // [0.04f,4.0f]

        /**
         * Modulation Depth controls the amount of pitch change. Low values of Diffusion will contribute to reinforcing
         * the perceived effect by reducing the mixing of overlapping reflections in the reverberation decay.
         *
         * MAX: 1.0f
         * MIN: 0.0f
         */
            EAXREVERB_MODULATION_DEPTH = 0.0f,          // [0.0f,1.0f]

        /**
         * The properties HF Reference and LF Reference determine respectively the frequencies at which the
         * high-frequency effects and the low-frequency effects created by EAX Reverb properties are measured,
         * for example Decay HF Ratio and Decay LF Ratio.  Note that it is necessary to maintain a factor of at least
         * 10 between these two reference frequencies so that low frequency and high frequency properties can be
         * accurately controlled and will produce independent effects. In other words, the LF Reference value should
         * be less than 1/10 of the HF Reference value.
         *
         * HF MAX: 20000.0f
         * HF MIN: 1000.0f
         *
         * LF MAX: 1000.0f
         * LF MIN: 20.0f
         */
            EAXREVERB_HFREFERENCE = 5000.0f,
            EAXREVERB_LFREFERENCE = 250.0f;


        /**
         * The Reflections Pan property is a 3D vector that controls the spatial distribution of the cluster of early
         * reflections.
         *
         * The direction of this vector controls the global direction of the reflections, while its magnitude controls
         * how focused the reflections are towards this direction.  It is important to note that the direction of the
         * vector is interpreted in the coordinate system of the user, without taking into account the orientation of
         * the virtual listener. For instance, assuming a four-point loudspeaker playback system, setting Reflections
         * Pan to (0., 0., 0.7) means that the reflections are panned to the front speaker pair, whereas as setting
         * of (0., 0., −0.7) pans the reflections towards the rear speakers. These vectors follow the a left-handed
         * co-ordinate system, unlike OpenAL uses a right-handed co-ordinate system.  If the magnitude of Reflections
         * Pan is zero (the default setting), the early reflections come evenly from all directions. As the magnitude
         * increases, the reflections become more focused in the direction pointed to by the vector. A magnitude of
         * 1.0 would represent the extreme case, where all reflections come from a single direction.
         *
         * THE VECTOR SHOULD HAVE A MAGNITUDE BETWEEN 0 AND 1
         *
         * MAX: [1.0f,1.0f,1.0f]
         * MIN: [-1.0f,-1.0f,-1.0f]
         */
        public float[] EAXREVERB_REFLECTIONS_PAN = {0.0f,0.0f,0.0f},

        /**
         * The Late Reverb Pan property is a 3D vector that controls the spatial distribution of the late
         * reverb. T
         *
         * The direction of this vector controls the global direction of the reverb, while its magnitude
         * controls how focused the reverb are towards this direction.
         *
         * The details under {@link #EAXREVERB_REFLECTIONS_PAN} also apply to Late Reverb Pan.
         */
            EAXREVERB_LATE_REVERB_PAN = {0.0f,0.0f,0.0f};
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
     * This class contains definitions for constructing a chorus effect filter object
     *
     * The chorus effect essentially replays the input audio accompanied by another slightly delayed version of the
     * signal, creating a ‘doubling’ effect. This was originally intended to emulate the effect of several musicians
     * playing the same notes simultaneously, to create a thicker, more satisfying sound.
     *
     * To add some variation to the effect, the delay time of the delayed versions of the input signal is modulated by
     * an adjustable oscillating waveform. This causes subtle shifts in the pitch of the delayed signals, emphasizing
     * the thickening effect.
     *
     * Edit properties of a ChorusDef object then use {@link #createChorus()} or {@link #updateChorus(EffectFilter, ChorusDef)}
     * to transfer properties from ChorusDef to the effect object.
     */
    public class ChorusDef {

        // Default Settings for Chorus effects
        // [] denote the ranges of the values
        /**
         * This property sets the waveform shape of the LFO that controls the delay time of the delayed signals.
         * THIS IS EITHER 0 or 1
         *
         * 0: Sin waveform
         * 1: Triangle waveform
         */
        public int CHORUS_WAVEFORM = 1,

        /**
         * This property controls the phase difference between the left and right LFO’s. At zero degrees the two LFOs
         * are synchronized. Use this parameter to create the illusion of an expanded stereo field of the output
         * signal.
         *
         * MAX: 180
         * MIN: -180
         */
            CHORUS_PHASE = 90;

        /**
         * This property sets the modulation rate of the LFO that controls the delay time of the delayed signals.
         *
         * MAX: 10.0f
         * MIN: 0.0f
         */
        public float CHORUS_RATE = 1.1f,

        /**
         * This property controls the amount by which the delay time is modulated by the LFO.
         *
         * MAX: 1.0f
         * MIN: 0.0f
         */
            CHORUS_DEPTH = 0.1f,

        /**
         * This property controls the amount of processed signal that is fed back to the input of the chorus effect.
         *
         * Negative values will reverse the phase of the feedback signal. At full magnitude the identical sample will
         * repeat endlessly. At lower magnitudes the sample will repeat and fade out over time. Use this parameter to
         * create a “cascading” chorus effect.
         *
         * MAX: 1.0f
         * MIN: -1.0f
         */
            CHORUS_FEEDBACK = 0.25f,

        /**
         * This property controls the average amount of time the sample is delayed before it is played back, and with
         * feedback, the amount of time between iterations of the sample.
         *
         * Larger values lower the pitch. Smaller values make the chorus sound like a {@link FlangerDef}, but with
         * different frequency characteristics.
         *
         * MAX: 0.016f
         * MIN: 0.0f
         */
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
     * The distortion effect simulates turning up (overdriving) the gain stage on a guitar amplifier or adding a
     * distortion pedal to an instrument’s output.  It is achieved by clipping the signal (adding more square wave-like
     * components) and adding rich harmonics.  The distortion effect could be very useful for adding extra dynamics to
     * engine sounds in a driving simulator, or modifying samples such as vocal communications. 
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
