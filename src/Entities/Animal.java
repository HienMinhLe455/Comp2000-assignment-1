package Entities;
//import java.util.ArrayList;

public class Animal { // parent class for all animals
    int health;
    float reproductionCooldown;
    int damage;
    int hunger;
    String gender;
    
    public Animal(int health, float reproductionCooldown, int damage, int hunger, String gender) {
        this.health = health;
        this.reproductionCooldown = reproductionCooldown;
        this.damage = damage;
        this.hunger = hunger;
        this.gender = gender;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setReproductionCooldown (float reproductionCooldown) {
        this.reproductionCooldown = reproductionCooldown;
    }

    public void setDamage (int damage) {
        this.damage = damage;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    //
    
}