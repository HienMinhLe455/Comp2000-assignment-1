import javax.swing.*;
import java.awt.*;


public class Main {
    public static void main(String[] args) {
        final int frameWidth = 1000; //pixels
        final int frameHeight = 700; //pixels
        Gui GUI = new Gui();

        JFrame frame = new JFrame("Dinosaur and Human Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.add(new Simulator());
        frame.setVisible(true);

        
    }
}