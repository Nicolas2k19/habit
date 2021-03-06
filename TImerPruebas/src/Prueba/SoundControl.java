package Prueba;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;


public class SoundControl {

	private Clip clip;
	
	SoundControl(String nombreSonido){
		try {
			AudioInputStream input = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
			 clip = AudioSystem.getClip();
		     clip.open(input);
		    
			}
		catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex)
			{System.out.println(ex.getCause());}

		}

	protected void start() {
			this.clip.setFramePosition(0);
			this.clip.start();}
	
	
	protected void stop() {
		this.clip.stop();
	//	this.clip.flush();
	//	this.clip.close();
		}



}
	

	