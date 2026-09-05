import java.awt.*;


public class Caveman extends Animal implements AnimalBehaviours{
    // stats can change later for balancing
    private static float defaultHealth = 10f;
    private static float defaultSpeed = 5f;
    private static int defaultHunger = 10; //seconds before dying?
    private static int defaultDamage = 2;

    Caveman(){
        setStats();

        posX = 0;
        posY = 0;
    }

    Caveman(int x, int y) {
            setStats();
            posX = x;
            posY = y;
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
        g2.drawOval(posX, posY - 110, 30, 30);
 
        // Body
        g2.drawLine(posX + 15, posY - 80, posX + 15, posY - 20);
 
        // Arms
        g2.drawLine(posX + 15, posY - 65, posX - 10, posY - 40);
        g2.drawLine(posX + 15, posY - 65, posX + 40, posY - 40);
 
        // Legs
        g2.drawLine(posX + 15, posY - 20, posX - 5, posY + 20);
        g2.drawLine(posX + 15, posY - 20, posX + 35, posY + 20);
    }

}
