public class Animal { //parent class for all animals
    float health;
    float reproductionCooldown;
    int damage;
    int hunger;
    float speed;
    int direction = Math.clamp(0, -1, 1);
    int posX;
    int posY;


    public void takeDamage(float damage) {
        health -= damage;
    }

    public void move(){
        
    }
}