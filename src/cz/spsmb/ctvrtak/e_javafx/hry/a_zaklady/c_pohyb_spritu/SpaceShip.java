package cz.spsmb.ctvrtak.e_javafx.hry.a_zaklady.c_pohyb_spritu;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;

import static javafx.scene.input.KeyEvent.KEY_PRESSED;

public class SpaceShip {
    private int dx;
    private int dy;
    private int x = 40;
    private int y = 60;
    private double w;
    private double h;
    private Image image;
    private ArrayList<Projectile> projectiles;
    private ArrayList<Enemy> enemies;
    private KeyCode lastPressed;

    public SpaceShip() {
        loadImage();
        enemies = new ArrayList<>();
        projectiles = new ArrayList<>();
    }

    private void loadImage() {

        //ImageIcon ii = new ImageIcon("src/resources/craft.png");
        image = new Image("craft.png");

        w = image.getWidth();
        h = image.getHeight();
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

    public Image getImage() {
        return image;
    }

    public void keyPressed(KeyEvent e) {
        KeyCode key = e.getCode();
        if(key == KeyCode.SPACE){
            int velocityX = 0;
            int velocityY = 0;
            if(lastPressed == KeyCode.LEFT) {
                velocityX = -1;
            }
            if(lastPressed == KeyCode.RIGHT) {
                velocityX = 1;
            }
            if(lastPressed == KeyCode.UP) {
                velocityY = -1;
            }
            if(lastPressed == KeyCode.DOWN) {
                velocityY = 1;
            }

            projectiles.add(new Projectile(x, y, velocityX, velocityY));
        }

        if (key == KeyCode.LEFT) {
            dx = -1;
            lastPressed = key;
        }

        if (key == KeyCode.RIGHT) {
            dx = 1;
            lastPressed = key;
        }

        if (key == KeyCode.UP) {
            dy = -1;
            lastPressed = key;
        }

        if (key == KeyCode.DOWN) {
            dy = 1;
            lastPressed = key;
        }

        if(key == KeyCode.ESCAPE){
            System.exit(0);
        }

        if(key == KeyCode.ENTER){
            enemies.add(new Enemy((int)(Math.random() * 300), (int)(Math.random() * 300)));
        }
    }

    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }

    public void setProjectiles(ArrayList<Projectile> projectiles) {
        this.projectiles = projectiles;
    }

    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }

    public void keyReleased(KeyEvent e) {
        KeyCode key = e.getCode();

        if (key == KeyCode.LEFT) {
            dx = 0;
        }

        if (key == KeyCode.RIGHT) {
            dx = 0;
        }

        if (key == KeyCode.UP) {
            dy = 0;
        }

        if (key == KeyCode.DOWN) {
            dy = 0;
        }
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public KeyCode getLastPressed() {
        return lastPressed;
    }
}
