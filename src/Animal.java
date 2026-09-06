import java.awt.*;

abstract class Animal { //parent class for all animals
    float health;
    float reproductionCooldown;
    int damage;
    int hunger;
    int maxHunger = 600;
    int foodValue = 150;
    boolean isHungry = false;
    int starvationTimer = 600; 
    int defaultStarvationTime = 600;

    float speed;
    int direction = Math.clamp(0, -1, 1);
    int x; //current x position
    int y; //current y positino
    int dx; // direction or speed for x
    int dy; // direction or speed for y

    int width = 40;
    int height = 40;


    public void takeDamage(float damage) {
        health -= damage;
    }

    public boolean isDead(){
        if (health <= 0 || starvationTimer <= 0) { // if hungry too long => die
            return true;
        } else {
            return false;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public double getDistanceTo(Animal other) {
        int deltaX = this.x - other.x;
        int deltaY = this.y - other.y;
        return Math.sqrt((deltaX * deltaX) + (deltaY * deltaY));
    }

    public void update(int screenWidth, int screenHeight) {
        x += dx;
        y += dy;

        if(x <= 0 || x >= screenWidth) {
            dx = -dy;
        }
        if(y <= 0 || y >= screenHeight) {
            dy = -dy;
        }

        // Hunger and dead logic
        if (hunger > 0) {
            hunger = hunger - 1; // count down hunger 
        } else {
            isHungry = true;
        }

        // if animal hungry, start starvation time
        if (isHungry == true) {
            starvationTimer = starvationTimer - 1;
        }
        
    }

    void draw(Graphics2D g2) {
        System.out.println("this is the abstract class method, downcast and use the subclasses methods");
    }
}