import java.awt.*;

abstract class Zone {



    int x;
    int y;





    public void draw(Graphics2D drawing) {
        System.out.println("this is the abstract class method, downcast and use the subclasses methods");
    }
}
