import java.awt.*;


public class Dinosaur extends Animal implements AnimalBehaviours {

    //Dinosaur stats can change later for balancing
    private static float defaultHealth = 10f;
    private static int defaultSpeed = 5;
    private static int defaultHunger = 10; //seconds before dying?
    private static int defaultDamage = 2;


        Dinosaur () {
            setStats();
            x = 0;
            y = 0;

        }

        //constructor for reproduced dinosaurs, pass the position of the parent (or next to them)
        Dinosaur(int spawnX, int spawnY) {
            setStats();
            x = spawnX;
            y = spawnY;
        }

    @Override
    public void setStats(){
        this.health = defaultHealth;
        this.dx = defaultSpeed;
        this.dy = defaultSpeed;
        this.hunger = defaultHunger;
        this.damage = defaultDamage;
    }

    @Override
    public void createNest(){

    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(new Color(60, 150, 60));
 
        // Body (oval)
        g2.fillOval(x, y - 40, 100, 60);
 
        // Tail (triangle-ish using polygon)
        int[] tailX = {x, x - 40, x};
        int[] tailY = {y - 30, y - 10, y};
        g2.fillPolygon(tailX, tailY, 3);
 
        // Neck + head
        g2.fillOval(x + 80, y - 80, 30, 50);   // neck
        g2.fillOval(x + 95, y - 100, 35, 30);  // head
 
        // Legs
        g2.fillRect(x + 15, y + 10, 12, 30);
        g2.fillRect(x + 65, y + 10, 12, 30);
 
        // Spikes on back
        g2.setColor(new Color(30, 100, 30));
        for (int i = 0; i < 4; i++) {
            int sx = x + 20 + i * 18;
            int[] spikeX = {sx, sx + 8, sx + 16};
            int[] spikeY = {y - 40, y - 55, y - 40};
            g2.fillPolygon(spikeX, spikeY, 3);
        }
 
        // Eye
        g2.setColor(Color.BLACK);
        g2.fillOval(x + 112, y - 95, 4, 4);

    }
}
