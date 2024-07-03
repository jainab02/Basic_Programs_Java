import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class audio {
	public static void main(String[] args) throws UnsupportedAudioFileException,IOException, LineUnavailableException {
        Scanner s = new Scanner(System.in);
        File file = new File("Joy To The World - DJ Williams.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        String response = "";    
        while (!response.equals("Q")) {
            System.out.println("Click P for Play , S for Stop , Q for Quit");
            System.out.println("Enter your choice");
            response = s.next();
            response = response.toUpperCase(); 
            switch (response) {
                case "P":
                    clip.start();
                    break;  
                    case "S":
                    clip.stop();
                    break;
                default:
                    break;
            }
        }
        // clip.start();
        s.close();
          
    }
    
}
