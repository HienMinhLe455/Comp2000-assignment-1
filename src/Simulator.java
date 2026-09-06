import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Simulator extends JPanel {
    private List<Animal> animals = new ArrayList<>(); // will contain all the animals in the scene
    private List<Zone> environment = new ArrayList<>(); // contains the environment
    private final Timer timer;

    private int cavemanAlertRadius = 150;

    public Simulator() {
        setBackground(Color.GREEN);

        //add some initial dinosaurs and cavemen
        createDinosaur(200, 200);
        createCaveman(210, 200);
        createCaveman(220, 200);
        createCaveman(500, 500);
        createVolcano(400, 300,150, 40);


        
        timer = new Timer(16, e -> {
            updateSimulation();
            repaint();

        });
        timer.start();
    } // timer is the engine for the simulation, repaint() calls paintComponent below
      // to draw everything.

    private void updateSimulation() {
        int screenWidth = getWidth();
        int screenHeight = getHeight();
        Volcano volcano = (Volcano) environment.get(0);
        
        for (int j = 0; j < environment.size(); j++) { //updates the environment
            environment.get(j).update();
        }

        for(int i = 0; i < animals.size(); i++) {
            if(volcano.contains(animals.get(i).x, animals.get(i).y)){
                animals.get(i).kill();
            }
        }



        for (int i = 0; i < animals.size(); i++) {
            Animal a = animals.get(i);
            a.update(screenWidth, screenHeight); // update animal position

            // if it's a dinosaur => track and follow caveman
            if (a instanceof Dinosaur) {
                ((Dinosaur) a).trackNearestCaveman(animals);
            }
        }

        for (int i = 0; i < animals.size(); i++) {
            for (int j = i + 1; j < animals.size(); j++) {
                Animal a = animals.get(i);
                Animal b = animals.get(j);

                // check if animals collide with each other
                if (a.getBounds().intersects(b.getBounds()) == true) {
                    handleCollision(a, b);
                }
            }
        }

        for (int i = animals.size() - 1; i >= 0; i--) {
            if (animals.get(i).isDead() == true) {
                animals.remove(i); // remove dead animal
            }
        }
    }

    private void handleCollision(Animal a, Animal b) { // check which animal collide with which
        if (a instanceof Dinosaur && b instanceof Caveman) {
            Dinosaur dino = (Dinosaur) a;
            Caveman caveman = (Caveman) b;
            dinoCavemanCombat(dino, caveman);
        } else if (a instanceof Caveman && b instanceof Dinosaur) {
            Caveman caveman = (Caveman) a;
            Dinosaur dino = (Dinosaur) b;
            dinoCavemanCombat(dino, caveman);
        } else if (a instanceof Dinosaur && b instanceof Dinosaur) {
            Dinosaur d1 = (Dinosaur) a;
            Dinosaur d2 = (Dinosaur) b;
            dinoDinoCombat(d1, d2);
        }
    }

    private void dinoCavemanCombat(Dinosaur dino, Caveman caveman) {
        if (dino.isHungry && dino.attackCooldown == 0 && caveman.attackCooldown == 0) {
            List<Caveman> fighters = new ArrayList<>(); // list of cavemen join combat
            fighters.add(caveman); // the attacked cavemen

            caveman.takeDamage(dino.damage); // dinosaur attack first
            dino.attackCooldown = 30; // wait 0.5s
            caveman.attackCooldown = 30;

            if (caveman.isDead() == false) { // if caveman alive => counter attack
                dino.takeDamage(caveman.damage);

                // find cavemen inside AlertRadius to join combat
                for (int i = 0; i < animals.size(); i++) {
                    Animal other = animals.get(i);

                    if (other instanceof Caveman && other != caveman) {
                        Caveman ally = (Caveman) other;
                        double distance = caveman.getDistanceTo(ally);

                        if (distance <= cavemanAlertRadius) {
                            dino.takeDamage(ally.damage);
                            fighters.add(ally);

                            // ally change direction and go to the dinosaur
                            if (ally.x < dino.x) {
                                ally.dx = Math.abs((int) ally.speed);
                            } else {
                                ally.dx = -Math.abs((int) ally.speed);
                            }

                            if (ally.y < dino.y) {
                                ally.dy = Math.abs((int) ally.speed);
                            } else {
                                ally.dy = -Math.abs((int) ally.speed);
                            }
                        }
                    }
                }
            }

            // if cavemen die => dinosaur eat caveman
            if (caveman.isDead() == true) {
                dino.hunger = Math.min(dino.maxHunger, dino.hunger + caveman.foodValue);
                dino.isHungry = false;
                dino.starvationTimer = dino.defaultStarvationTime;
            }

            // if dinosaur die => caveman eat dinosaur
            if (dino.isDead() == true) {
                for (int i = 0; i < fighters.size(); i++) {
                    Caveman fighter = fighters.get(i);

                    // if caveman didn't die => receive dinosaur meat
                    if (fighter.isDead() == false) {
                        fighter.hunger = Math.min(fighter.maxHunger, fighter.hunger + dino.foodValue);
                        fighter.isHungry = false;
                        fighter.starvationTimer = fighter.defaultStarvationTime;
                    }
                }
            }
        }
    }

    private void dinoDinoCombat(Dinosaur d1, Dinosaur d2) {
        // if d1 is hungry and attack first
        if (d1.isHungry == true && d1.attackCooldown == 0 && d2.attackCooldown == 0) {
            d2.takeDamage(d1.damage); // d1 attack first

            d1.attackCooldown = 30;
            d2.attackCooldown = 30;

            if (d2.isDead() == false) {
                d1.takeDamage(d2.damage); // if d2 not dead => counter attack
            }

            // End combat: d2 die => d1 eat
            if (d2.isDead() == true) {
                d1.hunger = Math.min(d1.maxHunger, d1.hunger + d2.foodValue);
                d1.isHungry = false;
                d1.starvationTimer = d1.defaultStarvationTime;
            }
            // d1 die => d2 eat
            else if (d1.isDead() == true) {
                d2.hunger = Math.min(d2.maxHunger, d2.hunger + d1.foodValue);
                d2.isHungry = false;
                d2.starvationTimer = d2.defaultStarvationTime;
            }
        }
        // if d2 is hungry and attack d1
        else if (d2.isHungry == true && d1.attackCooldown == 0 && d2.attackCooldown == 0) {
            d1.takeDamage(d2.damage); // d2 attack first

            d1.attackCooldown = 30;
            d2.attackCooldown = 30;

            if (d1.isDead() == false) { // if d1 not dead => counter attack
                d2.takeDamage(d1.damage);
            }

            // End combat: d1 die => d2 eat
            if (d1.isDead() == true) {
                d2.hunger = Math.min(d2.maxHunger, d2.hunger + d1.foodValue);
                d2.isHungry = false;
                d2.starvationTimer = d2.defaultStarvationTime;
            }
            // d2 die => d1 eat
            else if (d2.isDead() == true) {
                d1.hunger = Math.min(d1.maxHunger, d1.hunger + d2.foodValue);
                d1.isHungry = false;
                d1.starvationTimer = d1.defaultStarvationTime;
            }
        }
    }

    @Override //this sets up the graphics to be able to draw stuff, can draw stuff in other classes with g.rectangle() etc
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (int i = 0; i < animals.size(); i++) {
            animals.get(i).draw(g2);
        }
        // draws all of the dinosaurs and humans into the scene from animals List()

        for (int i = 0; i < environment.size(); i++) { // draws all elements in the environment
            environment.get(i).draw(g2);
        }
    }

    public void createVolcano(int spawnX, int spawnY, int radius, int lavaRad) {
        environment.add(new Volcano(spawnX, spawnY, radius, lavaRad));
    }

    public void createDinosaur(int spawnX, int spawnY) {
        animals.add(new Dinosaur(spawnX, spawnY));
    }

    public void createCaveman(int spawnX, int spawnY) {
        animals.add(new Caveman(spawnX, spawnY));
    }

}
