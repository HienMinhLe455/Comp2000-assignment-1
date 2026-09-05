import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class DrawingPanel extends JPanel {
    private List<Animal> creatures = new ArrayList<>();
 
    public DrawingPanel() {
        setBackground(Color.WHITE);
    }
 
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    public void createAnimal(Animal a) {
        
    }
}
