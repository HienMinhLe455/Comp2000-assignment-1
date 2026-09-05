import java.awt.*;

abstract class Animal { //parent class for all animals
    float health;
    float reproductionCooldown;
    int damage;
    int hunger;
    float speed;
    int direction = Math.clamp(0, -1, 1);
    int x; //current x position
    int y; //current y positino
    int dx; // direction or speed for x
    int dy; // direction or speed for y


    public void takeDamage(float damage) {
        health -= damage;
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
        
    }

    void draw(Graphics2D g2) {
        System.out.println("this is the abstract class method, downcast and use the subclasses methods");
    }
}