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
import edu.cornell.gdiac.audio.EffectFilter;


public class EffectFactory implements edu.cornell.gdiac.audio.EffectFactory {
    /**
     * Create a reverb effect object based on the ReverbDef object
     *
     * @param def the ReverbDef object to create from
     */
    public EffectFilter createReverb(ReverbDef def) {
        EffectFilter reverb = new Effect();
        updateReverb(reverb, def);
        return reverb;
    }

    /**
     * Create default reverb object
     */
    public EffectFilter createReverb() {
        return createReverb(new ReverbDef());
    }

    /**
     * Update an existing reverb effect based on the ReverbDef
     *
     * @param reverb the reverb effect to edit
     * @param def    the ReverbDef object to create from
     */
    public void updateReverb(EffectFilter reverb, ReverbDef def) {
        ((Effect)reverb).setAttribute(AL_EFFECT_TYPE, AL_EFFECT_REVERB);
        ((Effect)reverb).setAttribute(AL_REVERB_DENSITY, def.REVERB_DENSITY);
        ((Effect)reverb).setAttribute(AL_REVERB_DIFFUSION, def.REVERB_DIFFUSION);
        ((Effect)reverb).setAttribute(AL_REVERB_GAIN, def.REVERB_GAIN);
        ((Effect)reverb).setAttribute(AL_REVERB_GAINHF, def.REVERB_GAINHF);
        ((Effect)reverb).setAttribute(AL_REVERB_DECAY_TIME, def.REVERB_DECAY_TIME);
        ((Effect)reverb).setAttribute(AL_REVERB_DECAY_HFRATIO, def.REVERB_DECAY_HFRATIO);
        ((Effect)reverb).setAttribute(AL_REVERB_REFLECTIONS_GAIN, def.REVERB_REFLECTIONS_GAIN);
        ((Effect)reverb).setAttribute(AL_REVERB_REFLECTIONS_DELAY, def.REVERB_REFLECTIONS_DELAY);
        ((Effect)reverb).setAttribute(AL_REVERB_LATE_REVERB_GAIN, def.REVERB_LATE_REVERB_GAIN);
        ((Effect)reverb).setAttribute(AL_REVERB_LATE_REVERB_DELAY, def.REVERB_LATE_REVERB_DELAY);
        ((Effect)reverb).setAttribute(AL_REVERB_AIR_ABSORPTION_GAINHF, def.REVERB_AIR_ABSORPTION_GAINHF);
        ((Effect)reverb).setAttribute(AL_REVERB_ROOM_ROLLOFF_FACTOR, def.REVERB_ROOM_ROLLOFF_FACTOR);
    }

    /**
     * Create a EAXReverb effect object based on the ReverbDef object
     *
     * @param def the EAXReverbDef object to create from
     */
    public EffectFilter createEAXReverb(EAXReverbDef def) {
        EffectFilter eaxReverb = new Effect();
        updateEAXReverb(eaxReverb, def);
        return eaxReverb;
    }

    /**
     * Create default EAXReverb object
     */
    public EffectFilter createEAXReverb() {
        return createEAXReverb(new EAXReverbDef());
    }

    /**
     * Update an existing EAXReverb effect based on the EAXReverbDef
     *
     * @param eaxReverb the EaxReverb effect to edit
     * @param def       the EAxReverbDef object to create from
     */
    public void updateEAXReverb(EffectFilter eaxReverb, EAXReverbDef def) {
        ((Effect)eaxReverb).setAttribute(AL_EFFECT_TYPE, AL_EFFECT_EAXREVERB);
        ((Effect)eaxReverb).setAttribute(AL_EAXREVERB_DENSITY, def.EAXREVERB_DENSITY);
        ((Effect)eaxReverb).setAttribute(AL_EAXREVERB_DIFFUSION, def.EAXREVERB_DIFFUSION);
        ((Effect)eaxReverb).setAttribute(AL_EAXREVERB_GAIN, def.EAXREVERB_GAIN);
        ((Effect)eaxReverb).setAttribute(AL_EAXREVERB_GAINHF, def.EAXREVERB_GAINHF);
        ((Effect)eaxReverb).setAttribute(AL_EAXREVERB_GAINLF, def.EAXREVERB_GAINLF);
        ((Effect)eaxReverb).setAttribute(AL_EAXREVERB_REFLECTIONS_PAN,def.EAXREVERB_REFLECTIONS_PAN);
        ((Effect)eaxReverb).setAttribute(AL_EAXREVERB_LATE_REVERB_PAN,def.EAXREVERB_LATE_REVERB_PAN);
        ((Effect)eaxReverb).setAttribute(AL_EAXREVERB_DECAY_TIME, def.EAXREVERB_DECAY_TIME);
        ((Effect)eaxReverb).setAttribute(AL_EAXREVERB_DECAY_HFRATIO, def.EAXREVERB_DECAY_HFRATIO);
        ((Effect)eaxReverb).setAttribute(AL_EAXREVERB_DECAY_LFRATIO, def.EAXREVERB_DECAY_LFRATIO);
        ((Effect)eaxReverb).setAttribute(AL_EAXREVERB_REFLECTIONS_GAIN, def.EAXREVERB_REFLECTIONS_GAIN);
        ((Effect)eaxReverb).setAttribute(AL_EAXREVERB_REFLECTIONS_DELAY, def.EAXREVERB_REFLECTIONS_DELAY);
        ((Effect)eaxReverb).setAttribute(AL_EAXREVERB_LATE_REVERB_GAIN, def.EAXREVERB_LATE_REVERB_GAIN);
        ((Effect)eaxReverb).setAttribute(AL_EAXREVERB_LATE_REVERB_DELAY, def.EAXREVERB_LATE_REVERB_DELAY);
        ((Effect)eaxReverb).setAttribute(AL_EAXREVERB_ECHO_TIME, def.EAXREVERB_ECHO_TIME);
        ((Effect)eaxReverb).setAttribute(AL_EAXREVERB_ECHO_DEPTH, def.EAXREVERB_ECHO_DEPTH);
        ((Effect)eaxReverb).setAttribute(AL_EAXREVERB_MODULATION_TIME, def.EAXREVERB_MODULATION_TIME);
        ((Effect)eaxReverb).setAttribute(AL_EAXREVERB_MODULATION_DEPTH, def.EAXREVERB_MODULATION_DEPTH);
        ((Effect)eaxReverb).setAttribute(AL_EAXREVERB_AIR_ABSORPTION_GAINHF, def.EAXREVERB_AIR_ABSORPTION_GAINHF);
        ((Effect)eaxReverb).setAttribute(AL_EAXREVERB_HFREFERENCE, def.EAXREVERB_HFREFERENCE);
        ((Effect)eaxReverb).setAttribute(AL_EAXREVERB_LFREFERENCE, def.EAXREVERB_LFREFERENCE);
        ((Effect)eaxReverb).setAttribute(AL_EAXREVERB_ROOM_ROLLOFF_FACTOR, def.EAXREVERB_ROOM_ROLLOFF_FACTOR);
    }

    /**
     * Create a Chorus effect object based on the ChorusDef object
     *
     * @param def the ChorusDef object to create from
     */
    public EffectFilter createChorus(ChorusDef def) {
        EffectFilter chorus = new Effect();
        updateChorus(chorus, def);
        return chorus;
    }

    /**
     * Create default Chorus object
     */
    public EffectFilter createChorus() {
        return createChorus(new ChorusDef());
    }

    /**
     * Update an existing chorus effect based on the ChorusDef
     *
     * @param chorus    the chorus effect to edit
     * @param def       the ChorusDef object to create from
     */
    public void updateChorus(EffectFilter chorus, ChorusDef def) {
        ((Effect)chorus).setAttribute(AL_EFFECT_TYPE, AL_EFFECT_CHORUS);
        ((Effect)chorus).setAttribute(AL_CHORUS_WAVEFORM,def.CHORUS_WAVEFORM);
        ((Effect)chorus).setAttribute(AL_CHORUS_PHASE,def.CHORUS_PHASE);
        ((Effect)chorus).setAttribute(AL_CHORUS_RATE,def.CHORUS_RATE);
        ((Effect)chorus).setAttribute(AL_CHORUS_DEPTH,def.CHORUS_DEPTH);
        ((Effect)chorus).setAttribute(AL_CHORUS_FEEDBACK,def.CHORUS_FEEDBACK);
        ((Effect)chorus).setAttribute(AL_CHORUS_DELAY,def.CHORUS_DELAY);
    }

    /**
     * Create a Distortion effect object based on the DistortionDef object
     *
     * @param def the DistortionDef object to create from
     */
    public EffectFilter createDistortion(DistortionDef def) {
        EffectFilter distortion = new Effect();
        updateDistortion(distortion, def);
        return distortion;
    }

    /**
     * Create default Distortion object
     */
    public EffectFilter createDistortion() {
        return createDistortion(new DistortionDef());
    }

    /**
     * Update an existing distortion effect based on the DistortionDef
     *
     * @param distortion    the distortion effect to edit
     * @param def       the distortion object to create from
     */
    public void updateDistortion(EffectFilter distortion, DistortionDef def) {
        ((Effect)distortion).setAttribute(AL_EFFECT_TYPE, AL_EFFECT_DISTORTION);
        ((Effect)distortion).setAttribute(AL_DISTORTION_EDGE, def.DISTORTION_EDGE);
        ((Effect)distortion).setAttribute(AL_DISTORTION_GAIN, def.DISTORTION_GAIN);
        ((Effect)distortion).setAttribute(AL_DISTORTION_LOWPASS_CUTOFF, def.DISTORTION_LOWPASS_CUTOFF);
        ((Effect)distortion).setAttribute(AL_DISTORTION_EQCENTER, def.DISTORTION_EQCENTER);
        ((Effect)distortion).setAttribute(AL_DISTORTION_EQBANDWIDTH, def.DISTORTION_EQBANDWIDTH);
    }

    /**
     * Create an Echo effect object based on the EchoDef object
     *
     * @param def the EchoDef object to create from
     */
    public EffectFilter createEcho(EchoDef def) {
        EffectFilter echo = new Effect();
        updateEcho(echo, def);
        return echo;
    }

    /**
     * Create default Echo object
     */
    public EffectFilter createEcho() {
        return createEcho(new EchoDef());
    }

    /**
     * Update an existing echo effect based on the EchoDef
     *
     * @param echo the echo effect to edit
     * @param def the echo object to create from
     */
    public void updateEcho(EffectFilter echo, EchoDef def) {
        ((Effect)echo).setAttribute(AL_EFFECT_TYPE, AL_EFFECT_ECHO);
        ((Effect)echo).setAttribute(AL_ECHO_DELAY, def.ECHO_DELAY);
        ((Effect)echo).setAttribute(AL_ECHO_LRDELAY, def.ECHO_LRDELAY);
        ((Effect)echo).setAttribute(AL_ECHO_DAMPING, def.ECHO_DAMPING);
        ((Effect)echo).setAttribute(AL_ECHO_FEEDBACK, def.ECHO_FEEDBACK);
        ((Effect)echo).setAttribute(AL_ECHO_SPREAD, def.ECHO_SPREAD);
    }

    /**
     * Create an Flanger effect object based on the FlangerDef object
     *
     * @param def the FlangerDef object to create from
     */
    public EffectFilter createFlanger(FlangerDef def) {
        EffectFilter flanger = new Effect();
        updateFlanger(flanger, def);
        return flanger;
    }

    /**
     * Create default Flanger object
     */
    public EffectFilter createFlanger() {
        return createFlanger(new FlangerDef());
    }

    /**
     * Update an existing flanger effect based on the FlangerDef
     *
     * @param flanger the flanger effect to edit
     * @param def the FlangerDef object to create from
     */
    public void updateFlanger(EffectFilter flanger, FlangerDef def) {
        ((Effect)flanger).setAttribute(AL_EFFECT_TYPE, AL_EFFECT_FLANGER);
        ((Effect)flanger).setAttribute(AL_FLANGER_WAVEFORM, def.FLANGER_WAVEFORM);
        ((Effect)flanger).setAttribute(AL_FLANGER_PHASE, def.FLANGER_PHASE);
        ((Effect)flanger).setAttribute(AL_FLANGER_RATE, def.FLANGER_RATE);
        ((Effect)flanger).setAttribute(AL_FLANGER_DEPTH, def.FLANGER_DEPTH);
        ((Effect)flanger).setAttribute(AL_FLANGER_FEEDBACK, def.FLANGER_FEEDBACK);
        ((Effect)flanger).setAttribute(AL_FLANGER_DELAY, def.FLANGER_DELAY);
    }

    /**
     * Create an FreqShift effect object based on the FreqShiftDef object
     *
     * @param def the FreqShiftDef object to create from
     */
    public EffectFilter createFreqShift(FreqShiftDef def) {
        EffectFilter freqShift = new Effect();
        updateFreqShift(freqShift, def);
        return freqShift;
    }

    /**
     * Create default FreqShift object
     */
    public EffectFilter createFreqShift() {
        return createFreqShift(new FreqShiftDef());
    }

    /**
     * Update an existing freqShift effect based on the FreqShiftDef
     *
     * @param freqShift the freqShift effect to edit
     * @param def the FreqShiftDef object to create from
     */
    public void updateFreqShift(EffectFilter freqShift, FreqShiftDef def) {
        ((Effect)freqShift).setAttribute(AL_EFFECT_TYPE, AL_EFFECT_FREQUENCY_SHIFTER);
        ((Effect)freqShift).setAttribute(AL_FREQUENCY_SHIFTER_FREQUENCY,def.FREQUENCY_SHIFTER_FREQUENCY);
        ((Effect)freqShift).setAttribute(AL_FREQUENCY_SHIFTER_LEFT_DIRECTION,def.FREQUENCY_SHIFTER_LEFT_DIRECTION);
        ((Effect)freqShift).setAttribute(AL_FREQUENCY_SHIFTER_RIGHT_DIRECTION,def.FREQUENCY_SHIFTER_RIGHT_DIRECTION);
    }

    /**
     * Create an VocalMorpher effect object based on the VocalMorpher object
     *
     * @param def the VocalMorpherDef object to create from
     */
    public EffectFilter createVocalMorpher(VocalMorpherDef def) {
        EffectFilter vocalMorpher = new Effect();
        updateVocalMorpher(vocalMorpher, def);
        return vocalMorpher;
    }

    /**
     * Create default VocalMorpher object
     */
    public EffectFilter createVocalMorpher() {
        return createVocalMorpher(new VocalMorpherDef());
    }

    /**
     * Update an existing vocalMorpher effect based on the VocalMorpherDef
     *
     * @param vocalMorpher the vocalMorpher effect to edit
     * @param def the VocalMorpherDef object to create from
     */
    public void updateVocalMorpher(EffectFilter vocalMorpher, VocalMorpherDef def) {
        ((Effect)vocalMorpher).setAttribute(AL_EFFECT_TYPE, AL_EFFECT_VOCAL_MORPHER);
        ((Effect)vocalMorpher).setAttribute(AL_VOCMORPHER_RATE,def.VOCAL_MORPHER_RATE);
        ((Effect)vocalMorpher).setAttribute(AL_VOCMORPHER_PHONEMEA,def.VOCAL_MORPHER_PHONEMEA);
        ((Effect)vocalMorpher).setAttribute(AL_VOCMORPHER_PHONEMEB,def.VOCAL_MORPHER_PHONEMEB);
        ((Effect)vocalMorpher).setAttribute(AL_VOCMORPHER_WAVEFORM,def.VOCAL_MORPHER_WAVEFORM);
        ((Effect)vocalMorpher).setAttribute(AL_VOCMORPHER_PHONEMEA_COARSE_TUNING,def.VOCAL_MORPHER_PHONEMEA_COARSE_TUNING);
        ((Effect)vocalMorpher).setAttribute(AL_VOCMORPHER_PHONEMEB_COARSE_TUNING,def.VOCAL_MORPHER_PHONEMEB_COARSE_TUNING);
    }

    /**
     * Create an PitchShifter effect object based on the PitchShifter object
     *
     * @param def the PitchShifterDef object to create from
     */
    public EffectFilter createPitchShifter(PitchShifterDef def) {
        EffectFilter pitchShifter = new Effect();
        updatePitchShifter(pitchShifter, def);
        return pitchShifter;
    }

    /**
     * Create default PitchShifter object
     */
    public EffectFilter createPitchShifter() {
        return createPitchShifter(new PitchShifterDef());
    }

    /**
     * Update an existing PitchShifter effect based on the PitchShifterDef
     *
     * @param pitchShifter the pitchShifter effect to edit
     * @param def the PitchShifterDef object to create from
     */
    public void updatePitchShifter(EffectFilter pitchShifter, PitchShifterDef def) {
        ((Effect)pitchShifter).setAttribute(AL_EFFECT_TYPE, AL_EFFECT_PITCH_SHIFTER);
        ((Effect)pitchShifter).setAttribute(AL_EFFECT_TYPE, AL_EFFECT_PITCH_SHIFTER);
        ((Effect)pitchShifter).setAttribute(AL_PITCH_SHIFTER_COARSE_TUNE,def.AL_PITCH_SHIFTER_DEFAULT_COARSE_TUNE);
        ((Effect)pitchShifter).setAttribute(AL_PITCH_SHIFTER_FINE_TUNE,def.AL_PITCH_SHIFTER_DEFAULT_FINE_TUNE);
    }

    /**
     * Create a RingModulator effect object based on the RingModDef object
     *
     * @param def the RingModDef object to create from
     */
    public EffectFilter createRingMod(RingModDef def) {
        EffectFilter ringMod = new Effect();
        updateRingMod(ringMod, def);
        return ringMod;
    }

    /**
     * Create default Ring Modulator object
     */
    public EffectFilter createRingMod() {
        return createRingMod(new RingModDef());
    }

    /**
     * Update an existing RingModulator effect based on the RingModDef
     *
     * @param ringMod the RingMod effect to edit
     * @param def the RingModDef object to create from
     */
    public void updateRingMod(EffectFilter ringMod, RingModDef def) {
        ((Effect)ringMod).setAttribute(AL_EFFECT_TYPE, AL_EFFECT_RING_MODULATOR);
        ((Effect)ringMod).setAttribute(AL_RING_MODULATOR_FREQUENCY,def.RING_MODULATOR_FREQUENCY);
        ((Effect)ringMod).setAttribute(AL_RING_MODULATOR_HIGHPASS_CUTOFF,def.RING_MODULATOR_HIGHPASS_CUTOFF);
        ((Effect)ringMod).setAttribute(AL_RING_MODULATOR_WAVEFORM,def.RING_MODULATOR_WAVEFORM);
    }

    /**
     * Create a AutoWAH effect object based on the AutoWAHDef object
     *
     * @param def the AutoWAHDef object to create from
     */
    public EffectFilter createAutoWAH(AutoWAHDef def) {
        EffectFilter AutoWAH = new Effect();
        updateAutoWAH(AutoWAH, def);
        return AutoWAH;
    }

    /**
     * Create default AutoWAH object
     */
    public EffectFilter createAutoWAH() {
        return createAutoWAH(new AutoWAHDef());
    }

    /**
     * Update an existing AutoWAH effect based on the AutoWAHDef
     *
     * @param AutoWAH the AutoWAH effect to edit
     * @param def the AutoWAHDef object to create from
     */
    public void updateAutoWAH(EffectFilter AutoWAH, AutoWAHDef def) {
        ((Effect)AutoWAH).setAttribute(AL_EFFECT_TYPE, AL_EFFECT_AUTOWAH);
        ((Effect)AutoWAH).setAttribute(AL_AUTOWAH_ATTACK_TIME,def.AUTOWAH_ATTACK_TIME);
        ((Effect)AutoWAH).setAttribute(AL_AUTOWAH_RELEASE_TIME,def.AUTOWAH_RELEASE_TIME);
        ((Effect)AutoWAH).setAttribute(AL_AUTOWAH_RESONANCE,def.AUTOWAH_RESONANCE);
        ((Effect)AutoWAH).setAttribute(AL_AUTOWAH_PEAK_GAIN,def.AUTOWAH_PEAK_GAIN);
    }

    /**
     * Create a Compressor effect object based on the CompressorDef object
     *
     * @param def the CompressorDef object to create from
     */
    public EffectFilter createCompressor(CompressorDef def) {
        EffectFilter Compressor = new Effect();
        updateCompressor(Compressor, def);
        return Compressor;
    }

    /**
     * Create default Compressor object
     */
    public EffectFilter createCompressor() {
        return createCompressor(new CompressorDef());
    }

    /**
     * Update an existing Compressor effect based on the CompressorDef
     *
     * @param Compressor the Compressor effect to edit
     * @param def the CompressorDef object to create from
     */
    public void updateCompressor(EffectFilter Compressor, CompressorDef def) {
        ((Effect)Compressor).setAttribute(AL_EFFECT_TYPE, AL_EFFECT_COMPRESSOR);
        ((Effect)Compressor).setAttribute(AL_COMPRESSOR_ONOFF,def.AL_COMPRESSOR_DEFAULT_ONOFF);
    }

    /**
     * Create a Equalizer effect object based on the EqualizerDef object
     *
     * @param def the EqualizerDef object to create from
     */
    public EffectFilter createEqualizer(EqualizerDef def) {
        EffectFilter Equalizer = new Effect();
        updateEqualizer(Equalizer, def);
        return Equalizer;
    }

    /**
     * Create default Equalizer object
     */
    public EffectFilter createEqualizer() {
        return createEqualizer(new EqualizerDef());
    }

    /**
     * Update an existing Equalizer effect based on the EqualizerDef
     *
     * @param Equalizer the Equalizer effect to edit
     * @param def the EqualizerDef object to create from
     */
    public void updateEqualizer(EffectFilter Equalizer, EqualizerDef def) {
        ((Effect)Equalizer).setAttribute(AL_EFFECT_TYPE, AL_EFFECT_EQUALIZER);
        ((Effect)Equalizer).setAttribute(AL_EQUALIZER_LOW_GAIN,def.EQUALIZER_LOW_GAIN);
        ((Effect)Equalizer).setAttribute(AL_EQUALIZER_LOW_CUTOFF,def.EQUALIZER_LOW_CUTOFF);
        ((Effect)Equalizer).setAttribute(AL_EQUALIZER_MID1_GAIN,def.EQUALIZER_MID1_GAIN);
        ((Effect)Equalizer).setAttribute(AL_EQUALIZER_MID1_CENTER,def.EQUALIZER_MID1_CENTER);
        ((Effect)Equalizer).setAttribute(AL_EQUALIZER_MID1_WIDTH,def.EQUALIZER_MID1_WIDTH);
        ((Effect)Equalizer).setAttribute(AL_EQUALIZER_MID2_GAIN,def.EQUALIZER_MID2_GAIN);
        ((Effect)Equalizer).setAttribute(AL_EQUALIZER_MID2_CENTER,def.EQUALIZER_MID2_CENTER);
        ((Effect)Equalizer).setAttribute(AL_EQUALIZER_MID2_WIDTH,def.EQUALIZER_MID2_WIDTH);
        ((Effect)Equalizer).setAttribute(AL_EQUALIZER_HIGH_GAIN,def.EQUALIZER_HIGH_GAIN);
        ((Effect)Equalizer).setAttribute(AL_EQUALIZER_HIGH_CUTOFF,def.EQUALIZER_HIGH_CUTOFF);
    }
}