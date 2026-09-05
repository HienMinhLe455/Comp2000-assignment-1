import java.awt.*;


public class Caveman extends Animal implements AnimalBehaviours{
    // stats can change later for balancing
    private static float defaultHealth = 10f;
    private static int defaultSpeed = 5;
    private static int defaultHunger = 10; //seconds before dying?
    private static int defaultDamage = 2;

    Caveman(){
        setStats();

        x = 0;
        y = 0;
    }

    Caveman(int spawnX, int spawnY) {
            setStats();
            x = spawnX;
            y = spawnY;
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
        g2.setColor(Color.BLACK);
 
        // Head
        g2.drawOval(x, y - 110, 30, 30);
 
        // Body
        g2.drawLine(x + 15, y - 80, x + 15, y - 20);
 
        // Arms
        g2.drawLine(x + 15, y - 65, x - 10, y - 40);
        g2.drawLine(x + 15, y - 65, x + 40, y - 40);
 
        // Legs
        g2.drawLine(x + 15, y - 20, x - 5, y + 20);
        g2.drawLine(x + 15, y - 20, x + 35, y + 20);
    }

}
