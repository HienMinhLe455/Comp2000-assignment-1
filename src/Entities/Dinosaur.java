package Entities;

public class Dinosaur extends Animal {
    String species;


    public Dinosaur(int health,float reproductionCooldown,int damage,int hunger,String gender, String species) {
        super(health, reproductionCooldown, damage, hunger, gender);
        this.species = species;
    }


    
}
