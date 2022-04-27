package snake;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    private Graphics graphics;
    private List<Snake> snakes;
    private List<Food> foods;
    private boolean initialized;
    private boolean gameOver;

    public Game() {
        snakes = new ArrayList<>();
        foods = new ArrayList<>();
    }

    public void run() {
        if (!initialized) {
            addSnake();
            draw();
            addFood();
            initialized = true;
        } else if (!gameOver) {
            stepForward();
            removeFoodIfNecessary();
            checkSnakeDeath();
            checkIfSnakesBiteEachOther();
            draw();
        } else {
            draw();
        }
    }

    public void checkSnakeDeath() {
        for (Snake snake : snakes) {
            if (snake.isDead()) {
                gameOver = true;
            }
        }
    }

    public void checkIfSnakesBiteEachOther () {
        for (Snake snake1 : snakes) {
            for (Snake snake2 : snakes) {
                for (int i = 1; i < snake2.getSections().size(); i++) {
                    if (Arrays.equals(snake1.getSections().get(0).getCoordinate(),snake2.getSections().get(i).getCoordinate())) {
                        gameOver = true;
                    }
                }
            }
        }
    }

    public void removeFoodIfNecessary() {
        Food foodToRemove = null;
        for (Food food : foods) {
            for (Snake snake : snakes) {
                if (Arrays.equals(food.getCoordinate(), snake.getSections().get(0).getCoordinate())) {
                    foodToRemove = food;
                    snake.setEating(true);
                }
            }
        }
        if (foodToRemove != null) {
            foods.remove(foodToRemove);
            addFood();
        }
    }

    public void draw() {
        for (Snake snake : snakes) {
            snake.draw(graphics);
        }
        for (Food food : foods) {
            food.draw(graphics);
        }
    }

    public void stepForward() {
        for (Snake snake : snakes) {
            snake.move(graphics);
        }
    }

    public void addFood() {
        foods.add(new Food());
    }

    public void addSnake() {
        snakes.add(new Snake(Color.BLUE, Color.WHITE,new int[]{5,5},new int[]{1,0}));
        snakes.add(new Snake(Color.GREEN, Color.YELLOW,new int[]{10,10},new int[]{-1,0}));
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }
}
