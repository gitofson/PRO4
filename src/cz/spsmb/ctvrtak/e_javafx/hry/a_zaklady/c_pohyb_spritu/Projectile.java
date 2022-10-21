package cz.spsmb.ctvrtak.e_javafx.hry.a_zaklady.c_pohyb_spritu;
import javafx.scene.image.Image;

public class Projectile {
    private int x, y;
    private int dx, dy;
    private int width, height;
    private Image image;

    public Projectile(int x, int y, int dx, int dy) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.image = new Image("missile.png");
        this.width = (int) image.getWidth();
        this.height = (int) image.getHeight();
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Image getImage() {
        return image;
    }
}



