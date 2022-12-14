package cz.spsmb.ctvrtak.e_javafx.hry.a_zaklady.d_pohyb_spritu_fire;


import javafx.scene.image.Image;

public class Sprite {

    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean visible;
    protected Image image;

    public Sprite(int x, int y) {

        this.x = x;
        this.y = y;
        visible = true;
    }

    protected void loadImage(String imageName) {

        //ImageIcon ii = new ImageIcon(imageName);
        image = new Image(imageName);
    }

    protected void getImageDimensions() {

        width = (int) image.getWidth();
        height = (int) image.getHeight();
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
}
