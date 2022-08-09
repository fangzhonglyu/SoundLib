
package lwjgl3;

import com.badlogic.gdx.Application;
import edu.cornell.gdiac.audio.desktop.backend.GDXAudio;

public interface Lwjgl3ApplicationBase extends Application {

	GDXAudio createAudio (Lwjgl3ApplicationConfiguration config);

	Lwjgl3Input createInput (Lwjgl3Window window);
}
