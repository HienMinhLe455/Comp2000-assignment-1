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
    public void draw(){

    }    
    
}
