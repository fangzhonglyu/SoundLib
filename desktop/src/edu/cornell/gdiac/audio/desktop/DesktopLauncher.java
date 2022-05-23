package edu.cornell.gdiac.audio.desktop;

import edu.cornell.gdiac.backend.*;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import edu.cornell.gdiac.audio.GDXRoot;

import java.nio.IntBuffer;
import java.nio.ByteBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.AL10;

public class DesktopLauncher {
	public static void main (String[] arg) {
		GDXAppSettings config = new GDXAppSettings();
		config.x = 200;
		new GDXApp( new GDXRoot(), config );
		/*
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.disableAudio = true;
		//OGGBuffer buffer1 = new OGGBuffer( "Failure.ogg" );
		//OGGBuffer buffer2 = new OGGBuffer( "Victory.ogg" );

		try {
			AL.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}

		int sourceId = AL10.alGenSources();
		int state = AL10.alGetSourcei(sourceId, AL10.AL_SOURCE_STATE);
		System.out.println("State is "+state);

		AL10.alSourceStop(sourceId);
		AL10.alSourcei(sourceId, AL10.AL_BUFFER, 0);

		AL10.alSourcef(sourceId, AL10.AL_GAIN, 1);
		AL10.alSourcef(sourceId, AL10.AL_PITCH, 1);
		AL10.alSource3f(sourceId, AL10.AL_POSITION, 0, 0, 1f);

		int bufferID1 = buffer1.open();
		System.out.println("Buffer "+bufferID1);
		int bufferID2 = buffer2.open();
		System.out.println("Buffer "+bufferID2);

		//AL10.alSourcei(sourceId, AL10.AL_LOOPING, AL10.AL_FALSE);
		AL10.alSourcef(sourceId, AL10.AL_GAIN, 1);

		ByteBuffer temp = ByteBuffer.allocateDirect(16);
		IntBuffer names = temp.asIntBuffer();
		names.put( bufferID2 );
		names.put( bufferID1 );
		names.rewind();

		temp = ByteBuffer.allocateDirect(16);
		IntBuffer dones = temp.asIntBuffer();

		AL10.alSourceQueueBuffers(sourceId,1);
		AL10.alSourcePlay( sourceId );
		try {
			Thread.sleep( 5000 );
		} catch (InterruptedException ignored) {
		}
		System.out.println("Initial");

		//AL10.alSourceUnqueueBuffers(sourceId);
		AL10.alSourceStop( sourceId );
		AL10.alSourceQueueBuffers(sourceId,bufferID2);
		AL10.alSourceQueueBuffers(sourceId,bufferID1);
		AL10.alSourceQueueBuffers(sourceId,1);
		AL10.alSourcePlay( sourceId );
		int buffers = AL10.alGetSourcei(sourceId, AL10.AL_BUFFERS_PROCESSED);
		System.out.println("Processed "+buffers);

		//boolean finished = false;
		//while (!finished) {
		//	int buffers = AL10.alGetSourcei(sourceId, AL10.AL_BUFFERS_PROCESSED);
		//	if (buffers == 0) {
		//		try {
		//			Thread.sleep( 1000 );
		//		} catch (InterruptedException ignored) {
		//		}
		//	} else {
		//		System.out.println("Finished "+buffers);
		//		finished = true;
		//	}
		//}
		System.out.println("First done");

		//AL10.alSourcei(sourceId, AL10.AL_LOOPING, AL10.AL_TRUE);
		//System.out.println("Looping");
		try {
			Thread.sleep( 5000 );
		} catch (InterruptedException ignored) {
		}
		buffers = AL10.alGetSourcei(sourceId, AL10.AL_BUFFERS_PROCESSED);
		System.out.println("Processed2 "+buffers);
		System.out.println("Unqueued "+AL10.alSourceUnqueueBuffers( sourceId ));
		try {
			Thread.sleep( 5000 );
		} catch (InterruptedException ignored) {
		}

		System.out.println("Processed2 "+buffers);
		buffers = AL10.alGetSourcei(sourceId, AL10.AL_BUFFERS_PROCESSED);
		System.out.println("Unqueued "+AL10.alSourceUnqueueBuffers( sourceId ));
		//AL10.alSourceQueueBuffers(sourceId,bufferID2);
		System.out.println("Finally");
		new LwjglApplication(new GDXRoot(), config);

		 */
	}

}
