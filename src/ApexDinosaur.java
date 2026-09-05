import java.awt.*;

public class ApexDinosaur extends Dinosaur {
    private static float defaultHealth = 20f;
    private static float defaultSpeed = 5f;
    private static int defaultHunger = 10; //seconds before dying?
    private static int defaultDamage = 5;


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
        g2.setColor(new Color(150, 50, 60));
 
        // Body (oval)
        g2.fillOval(posX, posY - 40, 100, 60);
 
        // Tail (triangle-ish using polygon)
        int[] tailX = {posX, posX - 40, posX};
        int[] tailY = {posY - 30, posY - 10, posY};
        g2.fillPolygon(tailX, tailY, 3);
 
        // Neck + head
        g2.fillOval(posX + 80, posY - 80, 30, 50);   // neck
        g2.fillOval(posX + 95, posY - 100, 35, 30);  // head
 
        // Legs
        g2.fillRect(posX + 15, posY + 10, 12, 30);
        g2.fillRect(posX + 65, posY + 10, 12, 30);
 
        // Spikes on back
        g2.setColor(new Color(30, 100, 30));
        for (int i = 0; i < 4; i++) {
            int sx = posX + 20 + i * 18;
            int[] spikeX = {sx, sx + 8, sx + 16};
            int[] spikeY = {posY - 40, posY - 55, posY - 40};
            g2.fillPolygon(spikeX, spikeY, 3);
        }
 
        // Eye
        g2.setColor(Color.BLACK);
        g2.fillOval(posX + 112, posY - 95, 4, 4);
    }    
    
}
