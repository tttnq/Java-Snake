package com.company;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<Joint> joints;
    private int initialX, initialY;
    private final int  INITIAL_LENGTH = 5;
    private Direction direction;

    public Snake() {
        this.joints = new ArrayList<>();
        this.initialX = Board.WIDTH / 2;
        this.initialY = Board.HEIGHT / 2;
        this.direction = Direction.RIGHT;
        initSnake();
    }

    public void initSnake(){
        this.joints.add(new Joint(initialX, initialY));
        this.joints.get(0).getJointShape().setTranslateX(initialX);
        this.joints.get(0).getJointShape().setTranslateY(initialY);
        for(int i = 0; i < INITIAL_LENGTH; i++)
            grow();
    }

    public void grow(){
        int tailX = this.joints.get(this.joints.size() - 1).getX();
        int tailY = this.joints.get(this.joints.size() - 1).getY();
        this.joints.add(new Joint(tailX, tailY));
    }

    public void move() {
        Joint snakeHead = this.joints.get(0);
        int posX = this.joints.get(0).getX();
        int posY = this.joints.get(0).getY();
        switch (this.direction) {
            case UP:
                posY -= 10;
                snakeHead.setY(posY);
                break;
            case RIGHT:
                posX += 10;
                snakeHead.setX(posX);
                break;
            case DOWN:
                posY += 10;
                snakeHead.setY(posY);
                break;
            case LEFT:
                posX -= 10;
                snakeHead.setX(posX);
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
