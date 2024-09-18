import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.*;

public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
      File file = new File("I_Feel_Great.wav");
      AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
      Clip clip = AudioSystem.getClip();
      clip.open(audioStream);

      Scanner scanner = new Scanner(System.in);

      String result = "";

      while (!result.equals("Q")) {
        System.out.println("P = play, R = reset, S = stop, Q = quit");
        System.out.print("Enter your choice: ");
        result = scanner.next();
        result = result.toUpperCase();

        switch (result) {
            case "P":
                clip.start();
                break;
            case "R":
                clip.setMicrosecondPosition(0);
                clip.start();
                break;
            case "S":
                clip.stop();;
                break;
            case "Q":
                clip.stop();
                break;
            default:
                System.out.println("Incorrect Input, please try again.");
                break;
        }
      }
      scanner.close();
      System.out.println("Good bye!");
    }
}