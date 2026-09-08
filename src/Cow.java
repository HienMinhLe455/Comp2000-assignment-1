import java.awt.*;

public class Cow extends Animal implements AnimalBehaviours {
    // stats can change later for balancing
    private static float defaultHealth = 8f;
    private static float defaultSpeed = 3f;
    private static int defaultHunger = 10;
    private static int defaultDamage = 0; //purely prey

    Cow() //default spawn
    {
        setStats();
        x = 0;
        y = 0;
    }

    Cow(int x, int y) //position specific spawn
    {
        setStats();
        this.x = x;
        this.y = y;
    }

    @Override
    public void setStats(){
        this.health = defaultHealth;
        this.speed = defaultSpeed;
        this.hunger = defaultHunger;
        this.damage = defaultDamage;
    }

    @Override
    public void createNest(){
    }

    @Override
    public void draw(Graphics2D g2) {
        // Body (rounded rectangle, boxier than the dinosaur's oval)
        g2.setColor(new Color(180, 130, 90)); // light brown
        g2.fillRoundRect(x, y + 4, 11, 6, 3, 3);
    
        // Spots
        g2.setColor(new Color(90, 60, 40));
        g2.fillOval(x + 2, y + 5, 3, 2);
        g2.fillOval(x + 6, y + 7, 3, 2);
    
        // Head (short, low, no long neck)
        g2.setColor(new Color(180, 130, 90));
        g2.fillOval(x + 9, y + 3, 4, 4);
    
        // Snout
        g2.setColor(new Color(230, 210, 195));
        g2.fillOval(x + 12, y + 5, 2, 2);
    
        // Nostrils
        g2.setColor(Color.BLACK);
        g2.fillOval(x + 12, y + 5, 1, 1);
        g2.fillOval(x + 13, y + 5, 1, 1);
    
        // Ears (floppy, off to the sides of the head)
        g2.setColor(new Color(160, 110, 75));
        g2.fillOval(x + 9, y + 2, 2, 1);
        g2.fillOval(x + 11, y + 2, 2, 1);
    
        // Horns (small, on top of head)
        g2.setColor(new Color(210, 200, 190));
        g2.fillOval(x + 10, y + 1, 1, 1);
        g2.fillOval(x + 11, y + 1, 1, 1);
    
        // Eye
        g2.setColor(Color.BLACK);
        g2.fillOval(x + 11, y + 4, 1, 1);
    
        // Tail (thin curved line, not a triangle)
        g2.setColor(new Color(160, 110, 75));
        g2.setStroke(new BasicStroke(1));
        g2.drawLine(x, y + 8, x - 2, y + 10);
        g2.fillOval(x - 3, y + 9, 1, 1); // tail tuft
    
        // Legs (four, evenly spaced - reads as a quadruped, not two-legged)
        g2.setColor(new Color(160, 110, 75));
        g2.fillRect(x + 1, y + 10, 1, 4);
        g2.fillRect(x + 3, y + 10, 1, 4);
        g2.fillRect(x + 6, y + 10, 1, 4);
        g2.fillRect(x + 9, y + 10, 1, 4);
    
        // Udder
        g2.setColor(new Color(230, 180, 180));
        g2.fillOval(x + 4, y + 9, 3, 2);
        
    }
}