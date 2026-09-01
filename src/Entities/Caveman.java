package Entities;

public class Caveman extends Animal{
    String name;
    ArrayList<item> inventory;

    public Caveman(int health, float reproductionCooldown, int damage, int hunger, String gender, String name, ArrayList<item> inventory) {
        super(health, reproductionCooldown, damage, hunger, gender);
        this.name = name;
        this.inventory = inventory;
    }
}
