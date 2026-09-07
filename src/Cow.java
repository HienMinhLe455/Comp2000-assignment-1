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
        // Body (oval)
        g2.setColor(Color.WHITE);
        g2.fillOval(x, y - 40, 100, 60);

        // Spots
        g2.setColor(new Color(90, 60, 40));
        g2.fillOval(x + 10, y - 35, 25, 20);
        g2.fillOval(x + 50, y - 10, 30, 22);

        // Tail
        g2.setColor(Color.WHITE);
        int[] tailX = {x, x - 40, x};
        int[] tailY = {y - 30, y - 10, y};
        g2.fillPolygon(tailX, tailY, 3);
        g2.setColor(Color.BLACK); // tail tuft
        g2.fillOval(x - 45, y - 15, 10, 10);

        // Neck + head
        g2.setColor(Color.WHITE);
        g2.fillOval(x + 80, y - 80, 30, 50);   // neck
        g2.fillOval(x + 95, y - 100, 35, 30);  // head

        // Horns
        g2.setColor(new Color(210, 200, 190));
        g2.fillOval(x + 98, y - 108, 8, 12);
        g2.fillOval(x + 118, y - 108, 8, 12);

        // Legs
        g2.setColor(Color.WHITE);
        g2.fillRect(x + 15, y + 10, 12, 30);
        g2.fillRect(x + 65, y + 10, 12, 30);

        // Udder
        g2.setColor(new Color(230, 180, 180));
        g2.fillOval(x + 30, y + 5, 20, 15);

        // Eye
        g2.setColor(Color.BLACK);
        g2.fillOval(x + 112, y - 95, 4, 4);
    }
}