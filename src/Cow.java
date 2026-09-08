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
        g2.fillRoundRect(x, y + 10, 28, 15, 8, 8);
    
        // Spots
        g2.setColor(new Color(90, 60, 40));
        g2.fillOval(x + 5, y + 12, 8, 5);
        g2.fillOval(x + 15, y + 17, 8, 5);
    
        // Head (short, low, no long neck)
        g2.setColor(new Color(180, 130, 90));
        g2.fillOval(x + 22, y + 7, 10, 10);
    
        // Snout
        g2.setColor(new Color(230, 210, 195));
        g2.fillOval(x + 30, y + 12, 5, 5);
    
        // Nostrils
        g2.setColor(Color.BLACK);
        g2.fillOval(x + 31, y + 13, 2, 2);
        g2.fillOval(x + 33, y + 13, 2, 2);
    
        // Ears (floppy, off to the sides of the head)
        g2.setColor(new Color(160, 110, 75));
        g2.fillOval(x + 22, y + 5, 4, 3);
        g2.fillOval(x + 27, y + 5, 4, 3);
    
        // Horns (small, on top of head)
        g2.setColor(new Color(210, 200, 190));
        g2.fillOval(x + 24, y + 2, 2, 3);
        g2.fillOval(x + 27, y + 2, 2, 3);
    
        // Eye
        g2.setColor(Color.BLACK);
        g2.fillOval(x + 27, y + 9, 2, 2);
    
        // Tail (thin curved line, not a triangle)
        g2.setColor(new Color(160, 110, 75));
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(x, y + 20, x - 5, y + 25);
        g2.fillOval(x - 7, y + 23, 3, 3); // tail tuft
    
        // Legs (four, evenly spaced - reads as a quadruped, not two-legged)
        g2.setColor(new Color(160, 110, 75));
        g2.fillRect(x + 3, y + 25, 3, 10);
        g2.fillRect(x + 8, y + 25, 3, 10);
        g2.fillRect(x + 16, y + 25, 3, 10);
        g2.fillRect(x + 22, y + 25, 3, 10);
    
        // Udder
        g2.setColor(new Color(230, 180, 180));
        g2.fillOval(x + 10, y + 22, 7, 5);
        
        // Stat
        drawStats(g2);
    }
}