import java.awt.*;

public class Volcano extends Zone {

    // set the x value for where i want the zone to begin
    int r;
    int lavaRadius;
    boolean errupting = true;
    //tick rate for timing on when the volcano errupts

    Volcano(int spawnX, int spawnY, int radius, int lavaRadius) {
        x = spawnX;
        y = spawnY;
        r = radius;
        this.lavaRadius = lavaRadius;

    }


    public void update() {
        if(errupting == true && lavaRadius < 500) {

                lavaRadius += 10;
            }
        }
    


    @Override
    public void draw(Graphics2D drawing) { //draws the shape of the volcano
        drawing.setColor(new Color(90, 70, 60));
        int[] volcX = {x, x - r, x + r};
        int[] volcY = {y - r, y + r, y + r};
        drawing.fillPolygon(volcX, volcY, 3);




        drawing.setColor(new Color(100,10,10));
        int lavaX = x - lavaRadius;
        int lavaY = (y-r) - lavaRadius;;
        drawing.fillOval(lavaX, lavaY, lavaRadius *2, lavaRadius *2);



    }

}
