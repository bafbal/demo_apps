package minesweeper;

public class Main {

    public static void main(String[] args) {

        Game game = new Game(9, 9, 9);
//        game.showAll();
        game.printBoard();
        while (!game.gameOver && !game.win) {
            game.getUserInput();
            game.implementUserInput();
            game.printBoard();
            game.detectGameOver();
            game.detectWin();
        }
    }
}
