package mysnake.snake;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Joint {
    protected Rectangle joint;
    private int x, y;

    public Joint(int x, int y, Color color) {
        this.joint = new Rectangle(10, 10, color);
        this.x = x;
        this.y = y;
    }

    public Rectangle getJointShape(){
        return this.joint;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
