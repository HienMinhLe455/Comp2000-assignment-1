import java.awt.*;

public class Volcano extends Zone {

    // set the x value for where i want the zone to begin
    int r;

    Volcano(int spawnX, int spawnY, int radius) {
        x = spawnX;
        y = spawnY;
        r = radius;
    }

    @Override
    public void draw(Graphics2D drawing) {
        drawing.setColor(new Color(90, 70, 60));
        int[] volcX = {x,x-r,x+r};
        int[] volcY = { y - r, y + r, y + r };
        drawing.fillPolygon(volcX, volcY, 3);

    }

}
