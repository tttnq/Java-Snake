package com.company;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Apple {
    private int x, y;
    private Random rand;
    private Rectangle apple;

    public Apple() {
        this.rand = new Random();
        this.apple = new Rectangle(10,10,Color.RED);
        drawAppleLocation();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void drawAppleLocation(){
        this.x = this.rand.nextInt(Board.WIDTH);
        this.y = this.rand.nextInt(Board.HEIGHT);
        this.apple.setTranslateX(x);
        this.apple.setTranslateY(y);
    }

    public Rectangle getApple(){
        return this.apple;
    }
}
