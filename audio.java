import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.*;

public class audio {
    public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        Scanner sc = new Scanner(System.in);
        File file = new File("audio.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        String response = "";

        while (!response.equals("Q")) {
            System.out.println("P=Play, S=Stop, R=Reset, Q=Quit");
            System.out.println("Enter your choice:");
            response = sc.next();
            response = response.toUpperCase();
            switch (response) {
                case ("P"):
                    clip.start();
                    break;
                case ("S"):
                    clip.stop();
                    break;
                case ("R"):
                    clip.setMicrosecondPosition(0);
                    break;
                case ("Q"):
                    clip.close();
                    break;
                default:
                    System.out.println("Not a valid response");
            }
        }

    }
}