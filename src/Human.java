public class Human extends Animal implements AnimalBehaviours{
    // stats can change later for balancing
    private static float defaultHealth = 10f;
    private static float defaultSpeed = 5f;
    private static int defaultHunger = 10; //seconds before dying?
    private static int defaultDamage = 2;

    Human(){
        setStats();

        posX = 0f;
        posY = 0f;
    }

    Human(float x, float y) {
            setStats();
            posX = x;
            posY = y;
        }
    
        
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
