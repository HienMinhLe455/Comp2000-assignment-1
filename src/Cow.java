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
    g2.fillRoundRect(x, y - 50, 110, 55, 25, 25);

    // Spots
    g2.setColor(new Color(90, 60, 40));
    g2.fillOval(x + 15, y - 45, 28, 22);
    g2.fillOval(x + 60, y - 20, 30, 20);

    // Head (short, low, no long neck)
    g2.setColor(new Color(180, 130, 90));
    g2.fillOval(x + 95, y - 55, 40, 35);

    // Snout
    g2.setColor(new Color(230, 210, 195));
    g2.fillOval(x + 120, y - 40, 20, 18);

    // Nostrils
    g2.setColor(Color.BLACK);
    g2.fillOval(x + 126, y - 33, 3, 3);
    g2.fillOval(x + 133, y - 33, 3, 3);

    // Ears (floppy, off to the sides of the head)
    g2.setColor(new Color(160, 110, 75));
    g2.fillOval(x + 92, y - 60, 14, 10);
    g2.fillOval(x + 118, y - 62, 14, 10);

    // Horns (small, on top of head)
    g2.setColor(new Color(210, 200, 190));
    g2.fillOval(x + 100, y - 65, 6, 10);
    g2.fillOval(x + 112, y - 65, 6, 10);

    // Eye
    g2.setColor(Color.BLACK);
    g2.fillOval(x + 118, y - 48, 4, 4);

    // Tail (thin curved line, not a triangle)
    g2.setColor(new Color(160, 110, 75));
    g2.setStroke(new BasicStroke(4));
    g2.drawLine(x, y - 10, x - 20, y + 5);
    g2.fillOval(x - 25, y, 8, 10); // tail tuft

    // Legs (four, evenly spaced - reads as a quadruped, not two-legged)
    g2.setColor(new Color(160, 110, 75));
    g2.fillRect(x + 10, y, 10, 28);
    g2.fillRect(x + 35, y, 10, 28);
    g2.fillRect(x + 65, y, 10, 28);
    g2.fillRect(x + 90, y, 10, 28);

    // Udder
    g2.setColor(new Color(230, 180, 180));
    g2.fillOval(x + 40, y - 8, 25, 16);
}


}