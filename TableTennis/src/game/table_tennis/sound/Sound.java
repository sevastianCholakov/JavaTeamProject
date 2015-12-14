package game.table_tennis.sound;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound implements Runnable {
	
	private static final AudioClip hit = Applet.newAudioClip(Sound.class.getResource("hit.wav"));
	private static final AudioClip gameover = Applet.newAudioClip(Sound.class.getResource("gameover.wav"));
	private static final AudioClip scorePlus = Applet.newAudioClip(Sound.class.getResource("scorePlus.wav"));
	private static final AudioClip backgroundMusic = Applet.newAudioClip(Sound.class.getResource("JazzTip.wav"));
	private static final AudioClip select = Applet.newAudioClip(Sound.class.getResource("select.wav"));
	private static final AudioClip back =  Applet.newAudioClip(Sound.class.getResource("back.wav"));
	private static final AudioClip multiPlayerStart =  Applet.newAudioClip(Sound.class.getResource("computerStartGame.wav"));
	private static final AudioClip singlePlayerStart =  Applet.newAudioClip(Sound.class.getResource("powerup.wav"));
	private static final AudioClip blockHit =  Applet.newAudioClip(Sound.class.getResource("blockHit.wav"));
	private static final AudioClip flawless =  Applet.newAudioClip(Sound.class.getResource("flawless.wav"));
	private static final AudioClip jazztip =  Applet.newAudioClip(Sound.class.getResource("jazzTip.wav"));
	
	public static void playBackGroundLooped() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		jazztip.play();
	}
	
	public static void playSinglePlayerStart() {
		singlePlayerStart.play();
	}
	public static void playBlockHit() {
		blockHit.play();	
	}
	
	public static void playMultiStart() {
		multiPlayerStart.play();
	}
	
	public static void playSelectSound() {
		select.play();
	}
	
	public static void playBackSound() {
		back.play();
	}
	
	public static void playHitSound() {
		hit.play();
		
	}
	public static void playGameOverSound() {
		gameover.play();
	}
	public static void playflawlessSound() {
		flawless.play();
	}
	
	public static void playScoreSound() {
		scorePlus.play();
	}
	
	public static void playBackgroundMusic() {
		
		backgroundMusic.play();
	
		
	}
	
    /*AudioClip clip; 
    public SoundOne(AudioClip clip)
    {
        this.clip=clip;
    }*/
    public void run() {
        hit.play();
    }
    
    
}

