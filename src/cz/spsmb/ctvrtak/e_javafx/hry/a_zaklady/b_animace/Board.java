package cz.spsmb.ctvrtak.e_javafx.hry.a_zaklady.b_animace;


import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;


public class Board extends javafx.animation.AnimationTimer {

    private final int B_WIDTH = 350;
    private final int B_HEIGHT = 350;
    private final int INITIAL_X = 40;
    private final int INITIAL_Y = 40;
    private final int DELAY = 25;

    private Image star;
    // private Timer timer;
    private int x, y;
    private int x_velocity, y_velocity;
    private Canvas canvas;

    public Board() {
        this.canvas = new Canvas(B_WIDTH,B_HEIGHT);
        // Canvas je transparentní. Tj. pokud chceme pozadí nějaké barvy, vykreslíme obdelník
        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0, canvas.getWidth(), canvas.getHeight());
        initBoard();
        this.start();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    @Override
    public void handle(long l) {
        x += x_velocity;
        y += y_velocity;

        if (y > B_HEIGHT) {
            y_velocity = -y_velocity;
        }

        if(x > B_WIDTH) {
            x_velocity = -x_velocity;
        }

        if (y < 0) {
            y_velocity = -y_velocity;
        }

        if (x < 0) {
            x_velocity = -x_velocity;
        }
        this.drawStar();
    }

    private void loadImage() {

        //ImageIcon ii = new ImageIcon("star.png");
        star = new Image("star.png");
    }

    private void initBoard() {
        //setBackground(Color.BLACK);
        //setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImage();
        x = INITIAL_X;
        y = INITIAL_Y;

        setRandomVelocity();
    }

    private void setRandomVelocity(){
        if(x_velocity < 0){
            x_velocity = (int) (Math.random() * 10);
        } else {
            x_velocity = (int) (Math.random() * 10) * -1;
        }

        if(y_velocity < 0){
            y_velocity = (int) (Math.random() * 10);
        } else {
            y_velocity = (int) (Math.random() * 10) * -1;
        }
    }
    private void drawStar() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0, canvas.getWidth(), canvas.getHeight());

        gc.drawImage(star, x, y);
        gc.setLineWidth(2);
        gc.setStroke(Color.BLACK);
        gc.strokeText("Text", 10, 10);
        gc.strokeText("Text2", 100, 10, 40);
    }
}