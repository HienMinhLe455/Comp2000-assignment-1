package Entities;

import java.util.ArrayList;

public class Caveman extends Animal {
    String name;
    ArrayList<Item> inventory = new ArrayList<>();

    public Caveman(int health, float reproductionCooldown, int damage, int hunger, String gender, String name, ArrayList<Item> inventory) {
        super(health, reproductionCooldown, damage, hunger, gender);
        this.name = name;
        this.inventory = ArrayList<>();
        }

}
