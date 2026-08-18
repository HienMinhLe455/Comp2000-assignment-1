import javax.swing.*;

/// Draws the window and gui using JFrame and java swing libraries
public class Gui extends JFrame implements AppConstants {
    public Gui() {
        super("Predator-Prey: Team 2");
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setLocationRelativeTo(null); // centres the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        //Demo button.
        JButton button = new JButton("Button that does nothing at the moment");
        add(button);
        repaint();
        revalidate();
    }
}
