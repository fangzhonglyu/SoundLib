/*
 * GDXApp.java
 *
 * This is a (necessary) replacement for LwjglApplication. It allows us to disable audio and then
 * re-enable it later. It also allows us to force GL30.
 *
 * @author Walker M. White
 * @data April 10, 2020
 */
package edu.cornell.gdiac.backend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ApplicationListener;
import lwjgl3.Lwjgl3Application;

/**
 * This class represents a desktop game application using Lwjgl.
 *
 * This class is preferable to {@link Lwjgl3Application} because it is guaranteed to use GL30, and it has
 * a slightly more useful audio engine.
 */
public class GDXApp extends Lwjgl3Application {
    /** Settings, remembered for second initialization phase */
    protected GDXAppSettings config;

    /** Local version of audio engine to prevent thread problems. */
    protected GDXAudio audioEngine;

    /**
     * Creates a game application with the given listener and settings.
     *
     * The application listener drives the primary game loop.  It should be a platform-independent class
     * in the core package.
     *
     * @param listener  The game driver
     * @param config    The game settings
     */
    public GDXApp(ApplicationListener listener, GDXAppSettings config) {
        super( listener, config.getLwjgl3Configuration() );
        this.config = config;
        if (config.useAudio) {
            try {
                audio = new GDXAudio( config.audioDeviceSimultaneousSources,
                        config.audioDeviceBufferCount,
                        config.audioDeviceBufferSize );
                Gdx.audio = audio;
                //Lwjgl3ApplicationConfiguration = false;
            } catch (Throwable t) {
                log( "GDXApp", "Couldn't initialize audio, disabling audio", t );
                //Lwjgl3ApplicationConfiguration.disableAudio = true;
                config.useAudio = false;
            }
        }
    }
}