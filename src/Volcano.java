import java.awt.*;

public class Volcano extends Zone {

    // set the x value for where i want the zone to begin
    int r = 14;
    Volcano(int spawnX, int spawnY, int radius) {
        x = spawnX;
        y = spawnY;
        r = radius;
    }

    @Override
    public void draw(Graphics2D drawing) {
        drawing.setColor(new Color(60, 150, 60));
        int[] RecX = {0,-40,40};
        int[] RecY = {40,-40,40};
        
        drawing.fillPolygon(RecX, RecY, 3);








    }

}
