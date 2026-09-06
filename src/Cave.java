import java.awt.*;

public class Cave extends Zone {

    int length = 150;
    int width = 150;

    Cave(int spawnX, int spawnY) {
        x = spawnX;
        y = spawnY;
    }

    @Override
    public void draw(Graphics2D drawing) {
        drawing.setColor(new Color(100, 100, 100));

        drawing.fillRect(x, y, length, width);
    }

    public boolean contains(int checkX, int checkY) {


                if(checkX >= x && checkX <= x + length && checkY >= y && checkY <= y + width) {
                    return true;
                } else {
                    return false;
                }
    }

}
