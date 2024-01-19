package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    Clip clip;
    URL soundURL[] = new URL[30];
    
    public Sound(){
        soundURL[0] = getClass().getResource("/pics/sound/BlueBoyAdventure.wav");
        soundURL[1] = getClass().getResource("/pics/sound/coin.wav");
        soundURL[2] = getClass().getResource("/pics/sound/powerup.wav");
        soundURL[3] = getClass().getResource("/pics/sound/unlock.wav");
        soundURL[4] = getClass().getResource("/pics/sound/fanfare.wav");
        soundURL[5] = getClass().getResource("/pics/sound/hitmonster.wav");
        soundURL[6] = getClass().getResource("/pics/sound/receivedamage.wav");
        soundURL[7] = getClass().getResource("/pics/sound/hitmonster.wav");
        soundURL[8] = getClass().getResource("/pics/sound/levelup.wav");
        soundURL[9] = getClass().getResource("/pics/sound/cursor.wav");
        soundURL[10] = getClass().getResource("/pics/sound/burning.wav");
    }
    public void setFile(int i){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }catch(Exception e){

        }
    }
    public void play(){
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }
}
