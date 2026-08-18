import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/// Draws the window and gui using JFrame and java swing libraries
public class Gui extends JFrame implements AppConstants {
    public Gui() {
        super("Predator-Prey: Team 2");
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setLocationRelativeTo(null); // centres the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        // Title text
        JLabel title = new JLabel("Predator-Prey: Team 2 Final Project");
        title.setFont(DEFAULT_FONT);
        title.setBounds(SCREEN_HEIGHT / 2, SCREEN_HEIGHT / 4, 300, 50);
        add(title);

        // instantiate buttons
        JButton startGame = startButton();
        JButton quitGame = quitButton();
        add(startGame);
        add(quitGame);
        // Update / redraw screen
        setVisible(true);
    }

    private JButton startButton() {
        JButton startGame = new JButton("Start Game");
        startGame.setBounds(SCREEN_WIDTH / 2 - 50, SCREEN_HEIGHT / 2, 100, 50);
        startGame.setFont(DEFAULT_FONT);
        //startGame.setBackground(Color.CYAN);
        startGame.setForeground(Color.BLACK);
        startGame.setFocusPainted(false);

        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Continue through to the game.
                System.out.println("Button clicked - game starting");
            }
        });
        return startGame;
    }

    private JButton quitButton() {
        JButton quitGame = new JButton("Quit");
        quitGame.setBounds(SCREEN_WIDTH / 2 - 50, SCREEN_HEIGHT / 2 + 50, 100, 50);
        quitGame.setFont(DEFAULT_FONT);
        quitGame.setBackground(Color.CYAN);
        quitGame.setForeground(Color.BLACK);
        quitGame.setFocusPainted(false);

        quitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked - game quiting");
                System.exit(0); // Safely Closes the app.
            }
        });
        return quitGame;
    }
}
