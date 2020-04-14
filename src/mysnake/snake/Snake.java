package mysnake.snake;

import mysnake.rules.Direction;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;
import mysnake.Board;

public class Snake {
    private List<Joint> joints;
    private int initialX, initialY;
    private final int  INITIAL_LENGTH = 5;
    private Direction direction;
    private final Joint GHOST_PART;
    
    public Snake() {
        this.joints = new ArrayList<>();
        this.initialX = Board.WIDTH / 2;
        this.initialY = Board.HEIGHT / 2;
        this.direction = Direction.RIGHT;
        this.GHOST_PART = new Joint(initialX, initialY, Color.WHITE);
        initSnake();
    }

    public void initSnake(){
        this.joints.add(GHOST_PART);
        this.joints.add(new Head(initialX, initialY));  
        
        for(int i = 0; i < INITIAL_LENGTH; i++){
            grow();         
        }                
    }

    public void grow(){
        int tailX = this.joints.get(this.joints.size() - 1).getX();
        int tailY = this.joints.get(this.joints.size() - 1).getY();
        this.joints.add(new Joint(tailX, tailY, Color.GREEN));
    }

    public void move() {
        Joint snakeHead = this.joints.get(0);
        int headPosX = snakeHead.getX();
        int headPosY = snakeHead.getY();
        switch (this.direction) {
            case UP:
                headPosY -= 10;
                snakeHead.setY(headPosY);
                break;
            case RIGHT:
                headPosX += 10;
                snakeHead.setX(headPosX);
                break;
            case DOWN:
                headPosY += 10;
                snakeHead.setY(headPosY);
                break;
            case LEFT:
                headPosX -= 10;
                snakeHead.setX(headPosX);
                break;
            default:
                break;
        }       
                
        for (int i = this.joints.size()-1; i > 0; i--) {
            this.joints.get(i).setX(joints.get(i-1).getX());
            this.joints.get(i).setY(joints.get(i-1).getY());
        }
        
        for (int i = 0; i < this.joints.size(); i++) {
            this.joints.get(i).getJointShape().setTranslateX(this.joints.get(i).getX());
            this.joints.get(i).getJointShape().setTranslateY(this.joints.get(i).getY());
        }
    }

    public List<Joint> getJoints(){
        return this.joints;
    }

    public Direction getCurrentDirection(){
        return this.direction;
    }

    public void setCurrentDirection(Direction dir){
        this.direction = dir;
    }

}
