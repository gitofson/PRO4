package cz.spsmb.ctvrtak.e_javafx.hry.a_zaklady.c_pohyb_spritu;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;


public class Board extends AnimationTimer {
    private SpaceShip spaceShip;
    private Canvas canvas;
    //private final int DELAY = 10;

    public Board() {
        this.canvas = new Canvas(300,300);
        initBoard();
    }

    private void initBoard() {

        canvas.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                spaceShip.keyPressed(keyEvent);
            }
        });
        canvas.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                spaceShip.keyReleased(keyEvent);
            }
        });
        //addKeyListener(new TAdapter());
        //setBackground(Color.black);
        //setFocusable(true);

        spaceShip = new SpaceShip();

        //timer = new Timer(DELAY, this);
        this.start();
    }

    public Canvas getCanvas() {
        return canvas;
    }
    @Override
    public void handle(long l) {
        step();
    }

    private void step() {
        spaceShip.move();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(javafx.scene.paint.Color.BLACK);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());

        for (Projectile p : spaceShip.getProjectiles()) {
            if(p.getX() > canvas.getWidth() || p.getX() < 0 || p.getY() > canvas.getHeight() || p.getY() < 0) {
                spaceShip.getProjectiles().remove(p);
                continue;
            }
            for (Enemy e : spaceShip.getEnemies()) {
                if (p.getX() + p.getHeight() >= e.getX() - e.getWidth() && p.getX() - p.getHeight() <= e.getX() + e.getWidth() && p.getY() + p.getWidth() >= e.getY() - e.getHeight() && p.getY() - p.getWidth() <= e.getY() + e.getHeight()) {
                    gc.drawImage(e.getExplosion(), e.getX(), e.getY());
                    spaceShip.getEnemies().remove(e);
                    spaceShip.getProjectiles().remove(p);
                }
            }
            p.move();
            gc.drawImage(p.getImage(), p.getX(), p.getY());
        }

        for(Enemy e : spaceShip.getEnemies()) {
            gc.drawImage(e.getImage(), e.getX(), e.getY());
        }


        gc.drawImage(spaceShip.getImage(), spaceShip.getX(), spaceShip.getY());
    }

/*
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            spaceShip.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            spaceShip.keyPressed(e);
        }
    }*/
}
