import javax.swing.*;
import java.awt.*;


public class Main {
    public static void main(String[] args) {
        Gui GUI = new Gui();

        JFrame frame = new JFrame("Dinosaur and Human Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 350);
        frame.add(new DrawingPanel());
        frame.setVisible(true);

        

    }
}