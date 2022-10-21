package cz.spsmb.ctvrtak.e_javafx.hry.a_zaklady.c_pohyb_spritu;

import javafx.scene.image.Image;

public class Enemy {
    int x, y;
    int dx, dy;
    int width, height;
    Image image;
    Image explosion;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
        this.image = new Image("alien.png");
        this.explosion = new Image("star.png");
        this.width = (int) image.getWidth();
        this.height = (int) image.getHeight();
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

    public Image getExplosion() {
        return explosion;
    }
}
