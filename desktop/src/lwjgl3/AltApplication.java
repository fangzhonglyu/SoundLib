/*
 * AltApplication.java
 *
 * This replaces the original audio engine with the new audio engine.
 *
 * @author Barry Lyu
 * @data June 12, 2022
 */
package lwjgl3;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.LifecycleListener;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.audio.mock.MockAudio;
import com.badlogic.gdx.utils.Array;
import edu.cornell.gdiac.backend.GDXApp;
import edu.cornell.gdiac.backend.GDXAudio;
import org.lwjgl.glfw.GLFW;

/**
 * This class is a modification of {@link Lwjgl3ApplicationConfiguration}.
 * It adds a new audio engine and simply diregards the native audio engine.
 */
public class AltApplication extends Lwjgl3Application {
    /** The new audio engine instance **/
    protected GDXAudio audio;
    /** Whether the app is running **/
    private volatile boolean running = true;

    public AltApplication(ApplicationListener listener, Lwjgl3ApplicationConfiguration config){
        super(listener);
        this.audio = createAudio(config);
        Gdx.audio = audio;
    }

    public AltApplication(ApplicationListener listener) {
        this(listener, new Lwjgl3ApplicationConfiguration());
    }

    /** Creates an instance of the GDXAudio class according to specifications. **/
    private GDXAudio createAudio(Lwjgl3ApplicationConfiguration config) {
        return new GDXAudio(config.audioDeviceSimultaneousSources, config.audioDeviceBufferCount,
                config.audioDeviceBufferSize);
    }

    /**
     * This returns the audio engine currently in use
     * **/
    @Override
    public Audio getAudio () {
        return audio;
    }

    @Override
    public void exit () {
        running = false;
        super.exit();
    }

    /*
    protected void loop () {
        Array<Lwjgl3Window> closedWindows = new Array<Lwjgl3Window>();
        while (running && windows.size > 0) {
            // FIXME put it on a separate thread
            audio.update();

            boolean haveWindowsRendered = false;
            closedWindows.clear();
            int targetFramerate = -2;
            for (Lwjgl3Window window : windows) {
                window.makeCurrent();
                currentWindow = window;
                if (targetFramerate == -2) targetFramerate = window.getConfig().foregroundFPS;
                synchronized (lifecycleListeners) {
                    haveWindowsRendered |= window.update();
                }
                if (window.shouldClose()) {
                    closedWindows.add(window);
                }
            }
            GLFW.glfwPollEvents();

            boolean shouldRequestRendering;
            synchronized (runnables) {
                shouldRequestRendering = runnables.size > 0;
                executedRunnables.clear();
                executedRunnables.addAll(runnables);
                runnables.clear();
            }
            for (Runnable runnable : executedRunnables) {
                runnable.run();
            }
            if (shouldRequestRendering) {
                // Must follow Runnables execution so changes done by Runnables are reflected
                // in the following render.
                for (Lwjgl3Window window : windows) {
                    if (!window.getGraphics().isContinuousRendering()) window.requestRendering();
                }
            }

            for (Lwjgl3Window closedWindow : closedWindows) {
                if (windows.size == 1) {
                    // Lifecycle listener methods have to be called before ApplicationListener methods. The
                    // application will be disposed when _all_ windows have been disposed, which is the case,
                    // when there is only 1 window left, which is in the process of being disposed.
                    for (int i = lifecycleListeners.size - 1; i >= 0; i--) {
                        LifecycleListener l = lifecycleListeners.get(i);
                        l.pause();
                        l.dispose();
                    }
                    lifecycleListeners.clear();
                }
                closedWindow.dispose();

                windows.removeValue(closedWindow, false);
            }

            if (!haveWindowsRendered) {
                // Sleep a few milliseconds in case no rendering was requested
                // with continuous rendering disabled.
                try {
                    Thread.sleep(1000 / config.idleFPS);
                } catch (InterruptedException e) {
                    // ignore
                }
            } else if (targetFramerate > 0) {
                sync.sync(targetFramerate); // sleep as needed to meet the target framerate
            }

     */
}
