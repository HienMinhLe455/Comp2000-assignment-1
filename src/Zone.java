import java.awt.*;

abstract class Zone {

    int x;
    int y;

    public void draw(Graphics2D drawing) {
        System.out.println("this is the abstract class method, downcast and use the subclasses methods");
    }

    public void update() {
        System.out.println("abstract class method to downcast");
    }

    public abstract boolean contains(int checkX, int checkY); // abstract class to downcast to volcano and safe zone
}
