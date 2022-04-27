package minesweeper;

import java.util.ArrayList;
import java.util.List;

public class Square {

    private boolean underMined;
    private String status;
    private List<Square> neighbourhoodNumberPOV;
    private List<Square> neighbourhoodZerosPOV;
    private int number;
    private String representation;
    private int row;
    private int column;

    public Square(int row, int column) {
        underMined = false;
        status = "hide";
        representation = "/";
        neighbourhoodNumberPOV = new ArrayList<>();
        neighbourhoodZerosPOV = new ArrayList<>();
        this.row = row;
        this.column = column;
    }

    public void addNeighbourhoodNumberPOV(Square square) {
        neighbourhoodNumberPOV.add(square);
    }

    public void addNeighbourhoodZerosPOV(Square square) {
        neighbourhoodZerosPOV.add(square);
    }

    public void setUnderMined (boolean value) {
        underMined = value;
    }

    public List<Square> getNeighbourhoodNumberPOV() {
        return neighbourhoodNumberPOV;
    }

    public boolean isUnderMined() {
        return underMined;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getRepresentation() {
        return representation;
    }

    public void flagSquare() {
        status = "show";
        representation = "A";
    }

    public void showSquare() {
        status = "show";
        if(!underMined) {
            if (number != 0) {
                representation = Integer.toString(number);
            } else {
                representation = " ";
                for (Square square : neighbourhoodZerosPOV) {
                    if (square.status.equals("hide")) {
                        square.showSquare();
                    }
                }
            }
        } else {
            representation = "X";
        }
    }

    public String getStatus() {
        return status;
    }

    public void showNumber() {
        if (underMined) {
            representation = "X";
        } else {
            representation = Integer.toString(number);
        }
    }
}
