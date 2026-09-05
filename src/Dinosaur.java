public class Dinosaur extends Animal implements AnimalBehaviours {

    //Dinosaur stats can change later for balancing
    private static float defaultHealth = 10f;
    private static float defaultSpeed = 5f;
    private static int defaultHunger = 10; //seconds before dying?
    private static int defaultDamage = 2;


        Dinosaur () {
            setStats();
            posX = 0;
            posY = 0;

        }

        //constructor for reproduced dinosaurs, pass the position of the parent (or next to them)
        Dinosaur(float x, float y) {
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
