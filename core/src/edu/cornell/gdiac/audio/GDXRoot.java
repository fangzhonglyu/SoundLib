package edu.cornell.gdiac.audio;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.AudioDevice;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Timer;
import edu.cornell.gdiac.assets.*;
import edu.cornell.gdiac.audio.*;
import edu.cornell.gdiac.audio.EffectFactory.*;

public class GDXRoot extends ApplicationAdapter implements SoundEffect.OnCompletionListener, Music.OnCompletionListener, MusicQueue.OnTransitionListener {
	SpriteBatch batch;
	Texture img;
	TextureRegion reg;

	SoundEffect sound1;
	SoundEffect sound2;
	SoundEffect sound3;

	MusicQueue music1;
	MusicQueue music2;
	MusicQueue music3;
	AudioEngine engine;
	long first = -1L;
	AssetDirectory manager;

	private class KeyHandler extends InputAdapter {
		long soundId;

		boolean music1Chorus = false, music1Echo = false;
		EffectFactory f = engine.getEffectFactory();
		EffectFilter s = f.createChorus();
		EffectFilter s2 = f.createEAXReverb();
		EffectFilter s3 = f.createAutoWAH();
		FlangerDef fDef = new FlangerDef();

		EffectFilter s4 = f.createFlanger();

		@Override
		public boolean keyDown(int keycode) {
			System.out.println("Checking key "+keycode);
			EffectFilter dsafd = f.createCompressor();
			switch (keycode) {
				case Input.Keys.NUM_1:
					if (sound1 != null) {
						System.out.println("Playing sound 1");
						first = sound1.play();
						sound1.addEffect(first,s4);
					}
					return true;
				case Input.Keys.NUM_2:
					fDef.FLANGER_FEEDBACK = 0.5f;
					fDef.FLANGER_RATE = 10.0f;
					f.updateFlanger(s4,fDef);

					/*
					if (music1 != null ) {

						if(music1Chorus) {
							music1.removeEffect(s);
							music1Chorus = false;
						}
						else {
							music1.addEffect(s);
							music1Chorus = true;
						}
					}

					 */
					return true;
				case Input.Keys.NUM_3:
					if (music1 != null) {
						if(music1Echo) {
							music1.removeEffect(s2);
							music1Echo = false;
						}
						else {
							music1.addEffect(s2);
							music1Echo = true;
						}
					}
					return true;
				case Input.Keys.NUM_4:
					if (sound2 != null) {
						soundId = sound2.play();
						sound2.addEffect(soundId,s);
					}
					return true;
				case Input.Keys.NUM_5:
					if(sound2.isPlaying(soundId))
						sound2.removeEffect(soundId,s);
					//music1.setPosition( 20.0f );
					return true;
				case Input.Keys.NUM_6:
					//music1.jumpToSource(0);
					//((AudioEngine)Gdx.audio).resume();
					//System.out.println("Position "+music1.getPosition());
					//music1.setLoopBehavior( false );
					//music1.setPosition( 29.0f );
					if (music1 != null) {
						music1.setLooping( true );
						music1.play();
						Timer.schedule( new Timer.Task() {
							@Override
							public void run() {
								float position = music1.getPosition();
								if (music1.getNumberOfSources() > 0) {
									music1.clearSources();
								}
								System.out.println("Reseting to "+position);
								music1.setPosition( position );
								music1.play();
							}
						}, 5, 2 );
					}
					/*
					if (music3 != null) {
						music3.play();
					}

					 */
					return true;
				case Input.Keys.NUM_7:

			}
			return false;
		}
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		manager = new AssetDirectory("core/assets/assets.json");
		manager.loadAssets();
		engine = (AudioEngine)Gdx.audio;

		//manager.load("MarkerFelt.ttf", BitmapFont.class );
		manager.finishLoading();
		img = manager.getEntry("logo",Texture.class);
		reg = manager.getEntry("progress.background", TextureRegion.class);
		//reg = manager.get("badlogic.jpg:all",TextureRegion.class);
		//System.out.println(manager.get("assets.json",JsonValue.class));


		sound1 = manager.getEntry("key18", SoundEffect.class);
		sound2 = manager.getEntry("dodgemp3", SoundEffect.class);
		sound3 = manager.getEntry("failuremp3", SoundEffect.class);
		//music1 = manager.getEntry("twofer", MusicQueue.class);
		music1 = engine.newMusic( Gdx.files.internal("Dodge.wav" ));
		music2 = engine.newMusic( Gdx.files.internal("Failure.ogg" ));
		music3 = engine.newMusic( Gdx.files.internal("Failure.mp3" ));
		Gdx.input.setInputProcessor( new KeyHandler() );

		//music1.addSource( audio.newSource( Gdx.files.internal("Failure.wav" ) ) )
		System.out.println("Music 1 sample rate: "+music1.getSampleRate() );
		System.out.println("Music Buffer 0 sample rate: "+music1.getSource(0).getSampleRate() );
		//System.out.println("Music Buffer 1 sample rate: "+music1.getSource(1).getSampleRate() );
		sound1.setOnCompletionListener( this );
		sound2.setOnCompletionListener( this );
		sound3.setOnCompletionListener( this );
		music1.setOnCompletionListener( this );
		music2.setOnCompletionListener( this );
		music3.setOnCompletionListener( this );
		music1.setOnTransitionListener( this );
		music2.setOnTransitionListener( this );
		music3.setOnTransitionListener( this );
		music1.setLooping( true );
		music1.setLoopBehavior( true );
		System.out.println("Duration :" + music1.getDuration());
		music1.setVolume(1);
		EffectFactory f = engine.getEffectFactory();
		EffectFilter flanger = f.createFlanger();
		EffectFilter chorus = f.createChorus();
		EffectFilter com = f.createAutoWAH();
		//music1.addEffect(flanger);
		//music1.addEffect(chorus);
		//music1.addEffect(com);
		//music1.play();
		//music1.addEffect(chorus);




		//sample = audio.newSource( Gdx.files.internal("Dodge.wav" ) );

		/*
		AudioSampler sampler = (AudioSampler)Gdx.audio;
		FileHandle file1 = Gdx.files.internal( "Failure.wav" );
		Sample sample1 = sampler.newSample( file1 );
		System.out.println("File 1 channels: "+sample1.getChannels());
		System.out.println("File 1 sample rate: "+sample1.getSampleRate());
		System.out.println("File 1 duration: "+sample1.getDuration());

		FileHandle file2 = Gdx.files.internal( "Failure.ogg" );
		Sample sample2 = sampler.newSample( file2 );
		System.out.println("File 2 channels: "+sample2.getChannels());
		System.out.println("File 2 sample rate: "+sample2.getSampleRate());
		System.out.println("File 2 duration: "+sample2.getDuration());

		FileHandle file3 = Gdx.files.internal( "Failure.mp3" );
		Sample sample3 = sampler.newSample( file3 );
		System.out.println("File 3 channels: "+sample3.getChannels());
		System.out.println("File 3 sample rate: "+sample3.getSampleRate());
		System.out.println("File 3 duration: "+sample3.getDuration());
		*/



	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img,0,0);
		batch.draw(reg,1000,500);
		batch.draw(manager.getEntry( "progress.foreground",TextureRegion.class ),1000,1000);
		batch.end();
	}
	
	@Override
	public void dispose () {
		if(music1!=null)
			music1.dispose();
		if(music2!=null)
			music2.dispose();
		if(music3!=null)
			music3.dispose();
		if(sound1!=null)
			sound1.dispose();
		if(sound2!=null)
			sound2.dispose();
		if(sound3!=null)
			sound3.dispose();
		batch.dispose();
		img.dispose();
	}

	@Override
	public void pause () {
		System.out.println("Pausing!");
	}


	@Override
	public void resume () {
		System.out.println("Resuming!");
	}

	public void onCompletion(SoundEffect buffer, long sound) {
		System.out.println("Finished sound "+sound+" of "+buffer.getFile());
	}

	@Override
	public void onCompletion(Music music) {
		System.out.println("Finished music "+music);
	}

	@Override
	public void onLoopback(MusicQueue buffer, AudioSource sample) {
		System.out.println("Looping back in music "+buffer+" on sample "+sample);
	}

	@Override
	public void onTransition(MusicQueue buffer, AudioSource sample1, AudioSource sample2) {
		System.out.println("Transitioning in music "+buffer+" from sample "+sample1+" to sample "+sample2);
	}

	@Override
	public void onCompletion(MusicQueue buffer, AudioSource sample) {
		System.out.println("Completing music "+buffer+" with sample "+sample);
	}

	private void play(AudioSource sample, AudioDevice device) {
		System.out.println("Start play");
		AudioStream stream = sample.getStream();
		byte[] tempBytes = new byte[4096 * 10];
		float[] tempShort = new float[tempBytes.length/2];
		while (stream.getSampleOffset() != stream.getSampleSize()) {
			int length = stream.read( tempShort );
			device.writeSamples( tempShort, 0, length );
		}
		System.out.println("End play");
	}
}
