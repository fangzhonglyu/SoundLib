import lwjgl3.Lwjgl3Application;
import lwjgl3.Lwjgl3ApplicationConfiguration;
import edu.cornell.gdiac.audio.GDXRoot;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
    public static void main (String[] arg) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setForegroundFPS(60);
        config.setTitle("SoundLib");
        new Lwjgl3Application(new GDXRoot(), config);
    }
}