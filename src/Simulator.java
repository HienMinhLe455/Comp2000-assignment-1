import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Simulator extends JPanel {
    

    private List<Animal> animals = new ArrayList<>(); //will contain all the animals in the scene

    private final Timer timer;
 
    public Simulator() {
        setBackground(Color.WHITE);

        //add some initial dinosaurs and cavemen
        createDinosaur(getWidth()/2, getHeight() /2);

        timer = new Timer(16, e -> {
                for(int i = 0; i < animals.size(); i++) {
                    animals.get(i).update(getWidth(), getHeight()); //getWidth and getHeight are the size of window
                }
                repaint();
        });
        timer.start();
    } //timer is the engine for the simulation, repaint() calls paintComponent below to draw everything.
 
    @Override //this sets up the graphics to be able to draw stuff, can draw stuff in other classes with g.rectangle() etc
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    
        for(int i = 0; i < animals.size(); i++) {
                    animals.get(i).draw(g2);
                }
                //draws all of the dinosaurs and humans into the scene from animals List()
    }    
    
    
    public void createDinosaur(int SpawnX, int SpawnY) {
            animals.add(new Dinosaur(SpawnX, SpawnY));
        }
    
    public void createCaveman(int SpawnX, int SpawnY) {
        animals.add(new Caveman(SpawnX, SpawnY));
    }
    
}
