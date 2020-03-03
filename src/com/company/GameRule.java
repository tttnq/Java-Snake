package com.company;

import javafx.scene.shape.Shape;

public class GameRule {

    public GameRule() {

    }

    public boolean collisionWithWall(Snake snake) {
        int snakeHeadPosX = snake.getJoints().get(0).getX();
        int snakeHeadPosY = snake.getJoints().get(0).getY();

        if(snakeHeadPosX < 10 || snakeHeadPosX >= Board.WIDTH){
            return true;
        } else if (snakeHeadPosY < 10 || snakeHeadPosY >= Board.HEIGHT){
            return true;
        } else {
            return false;
        }
    }

    public boolean eatApple(Snake snake, Apple apple){
        Joint snakeHead = snake.getJoints().get(0);
        Shape collisionArea = Shape.intersect(snakeHead.getJointShape(), apple.getApple());
        return collisionArea.getBoundsInLocal().getWidth() != -1;
    }

    public boolean collisionWithTail(Snake snake){
        for(int i = snake.getJoints().size() -1; i > 1; i--){
            if(snake.getJoints().get(0).getX() == snake.getJoints().get(i).getX()
                    && snake.getJoints().get(0).getY() == snake.getJoints().get(i).getY()){
                return true;
            }
        }

        return false;
    }

}
