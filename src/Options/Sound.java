package Options;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

	private double volume = 0.50;
	private Clip audioClip;

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public Clip getAudioClip() {
		return audioClip;
	}

	public void setAudioClip(Clip audioClip) {
		this.audioClip = audioClip;
	}

	public void playSound(File soundFile) {
		try {
			audioClip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
			audioClip.open(ais);

		} catch (Exception ex) {
			System.out.println("Kann die Sounddatei nicht abspielen.");
			ex.printStackTrace();

		}
	}
	
	public void playSoundAgain() {
		audioClip.setFramePosition(0);
		audioClip.start();
	}
}
