package minesweeper;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private Square[][] squares;
    private String[] userInput;
    private int rows;
    private int columns;
    private int totalMines;
    boolean gameOver;
    boolean win;

    public Game(int rows, int columns, int numberOfMines) {
        squares = new Square[rows][columns];
        this.rows = rows;
        this.columns = columns;
        this.totalMines = numberOfMines;
        userInput = new String[3];
        init();
    }

    public void showAll() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                squares[i][j].showNumber();
            }
        }
    }

    private void init() {
        createEmptySquares();
        layMines();
        setNeighbours();
        setNumbersOfSquares();
        printBoard();
    }

    public void detectGameOver() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (squares[i][j].getRepresentation().equals("X")) {
                    gameOver = true;
                    System.out.println("Game over");
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (squares[i][j].getStatus().equals("hide")) {
                    return;
                }
            }
        }
        gameOver = true;
        System.out.println("Game over");
    }

    public void implementUserInput() {
        if (userInput[2].equals("s")) {
            squares[Integer.parseInt(userInput[0])-1][Integer.parseInt(userInput[1])-1].showSquare();
        }else if (userInput[2].equals("f")) {
            squares[Integer.parseInt(userInput[0])-1][Integer.parseInt(userInput[1])-1].flagSquare();
        }
    }

    public void getUserInput() {
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter row: ");
        userInput[0] = scanner.next();
        System.out.print("Enter column: ");
        userInput[1] = scanner.next();
        System.out.print("Show field (\"s\") or flag (\"f\")? ");
        userInput[2] = scanner.next();
    }

    public void printBoard() {
        System.out.println();
        System.out.print("  ");
        for (int i = 0; i < columns; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print((i+1) + " ");
            for (int j = 0; j < columns; j++) {
                System.out.print(squares[i][j].getRepresentation() + " ");
            }
            System.out.println();
        }
    }

    public void detectWin(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!(squares[i][j].isUnderMined()) && !(squares[i][j].getStatus().equals("show"))) {
                    win = false;
                    return;
                }
            }
        }
        win = true;
        System.out.println("you win");
    }

    private void setNumbersOfSquares() {
        int neighbourMines;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                neighbourMines = 0;
                for (Square square : squares[i][j].getNeighbourhoodNumberPOV()) {
                    if (square.isUnderMined()) {
                        neighbourMines++;
                    }
                }
                squares[i][j].setNumber(neighbourMines);
            }
        }
    }

    private void setNeighbours() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int k = 0; k < rows; k++) {
                    for (int l = 0; l < columns; l++) {
                        if (i != k || j != l) {
                            if (Math.abs(i - k) < 2 && Math.abs(l - j) < 2) {
                                squares[i][j].addNeighbourhoodNumberPOV(squares[k][l]);
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int k = 0; k < rows; k++) {
                    for (int l = 0; l < columns; l++) {
                        if (i != k ^ j != l) {
                            if (Math.abs(i - k) < 2 && Math.abs(l - j) < 2) {
                                squares[i][j].addNeighbourhoodZerosPOV(squares[k][l]);
                            }
                        }
                    }
                }
            }
        }
    }

    private void createEmptySquares() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                squares[i][j] = new Square(i, j);
            }
        }
    }

    private void layMines() {
        Random random = new Random();
        int laidMines = 0;
        int row;
        int column;
        while (laidMines<totalMines) {
            row = random.nextInt(rows);
            column = random.nextInt(columns);
            if (!squares[row][column].isUnderMined()) {
                squares[row][column].setUnderMined(true);
                laidMines++;
            }
        }
    }



}
