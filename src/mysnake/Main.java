package mysnake;

import mysnake.snake.Snake;
import mysnake.rules.Direction;
import mysnake.rules.GameRule;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    private int points = 0;

    public static void main(String[] args) {
	launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(Board.WIDTH, Board.HEIGHT);
        Pane pane = new Pane();
        pane.getChildren().add(canvas);
        Scene scene = new Scene(pane, Color.BLACK);
        Snake snake = new Snake();
        Apple apple = new Apple();
        GameRule gameRule = new GameRule();

        for(int i = 0; i < snake.getJoints().size(); i++){
            pane.getChildren().add(snake.getJoints().get(i).getJointShape());
        }

        pane.getChildren().add(apple.getApple());

        scene.setOnKeyPressed(event -> {
            System.out.println(event.getCode());
            if (event.getCode() == KeyCode.UP && snake.getCurrentDirection() != Direction.DOWN) {
                snake.setCurrentDirection(Direction.UP);
            } else if (event.getCode() == KeyCode.RIGHT && snake.getCurrentDirection() != Direction.LEFT) {
                snake.setCurrentDirection(Direction.RIGHT);
            } else if (event.getCode() == KeyCode.DOWN && snake.getCurrentDirection() != Direction.UP) {
                snake.setCurrentDirection(Direction.DOWN);
            } else if (event.getCode() == KeyCode.LEFT && snake.getCurrentDirection() != Direction.RIGHT) {
                snake.setCurrentDirection(Direction.LEFT);
            }
        });

        new AnimationTimer() {
            long before = 0;

            @Override
            public void handle(long now) {
                if (now - before < 100000000) {
                    return;
                }

                snake.move();

                if(gameRule.collisionWithApple(snake, apple)){
                    snake.grow();
                    apple.drawAppleLocation();
                    snake.move();
                    points++;
                    primaryStage.setTitle("SnakeGame (Points: " + points + ")");

                    int tailIndex = snake.getJoints().size() - 1;
                    pane.getChildren().add(snake.getJoints().get(tailIndex).getJointShape());
                }

                if(gameRule.collisionWithWall(snake)) {
                    stop();
                }

                if(gameRule.collisionWithTail(snake)){
                    stop();
                }

                this.before = now;
            }
        }.start();

        primaryStage.setScene(scene);
        primaryStage.setTitle("SnakeGame (Points: 0)");
        primaryStage.show();
    }

}
