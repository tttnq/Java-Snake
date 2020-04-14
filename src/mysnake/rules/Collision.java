
package mysnake.rules;

import mysnake.Apple;
import mysnake.snake.Snake;


public interface Collision {
    public boolean collisionWithWall(Snake snake);
    
    public boolean collisionWithTail(Snake snake);
    
    public boolean collisionWithApple(Snake snake, Apple apple);
}
