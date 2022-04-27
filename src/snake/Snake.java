package snake;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Snake implements Drawable {

    private List<Section> sections;
    private Color bodyColor;
    private Color skinColor;
    private int[] direction;
    private boolean eating;

    public Snake(Color bodyColor, Color skinColor, int[] headPosition, int[] direction) {
        sections = new ArrayList<>();
        this.bodyColor = bodyColor;
        this.skinColor = skinColor;
        this.direction = direction;
        addHead(headPosition);
        for (int i = 1; i < 6; i++) {
            addSection(new int[]{headPosition[0] - i * direction[0], headPosition[1] - i * direction[1]});
        }
    }

    public void addSection(int[] coordinate) {
        sections.add(new Section(bodyColor, skinColor, coordinate));
    }

    public void addHead(int[] coordinate) {
        sections.add(new Head(bodyColor, skinColor, coordinate));
    }

    public void move(Graphics graphics) {
        if (eating) {
            moveWhenEating(graphics);
            eating = false;
        } else {
            moveWhenNotEating(graphics);
        }
    }

    public void moveWhenEating(Graphics graphics) {
        sections.add(1, new Section(bodyColor, skinColor, sections.get(0).getCoordinate()));
        sections.get(0).setCoordinate(new int[]{sections.get(1).getCoordinate()[0] + direction[0], sections.get(1).getCoordinate()[1] + direction[1]});
    }


    public void moveWhenNotEating(Graphics graphics) {
        sections.get(sections.size() - 1).paintItBlack(graphics);
        for (int i = 0; i < sections.size() - 1; i++) {
            sections.get(sections.size() - 1 - i).setCoordinate(sections.get(sections.size() - 2 - i).getCoordinate());
        }
        sections.get(0).setCoordinate(new int[]{sections.get(1).getCoordinate()[0] + direction[0], sections.get(1).getCoordinate()[1] + direction[1]});
    }

    public boolean isDead(){
        if (sections.get(0).getCoordinate()[0] == GUI.width / gridSize || sections.get(0).getCoordinate()[0] < 0 || sections.get(0).getCoordinate()[1] == GUI.height / gridSize-1 || sections.get(0).getCoordinate()[1] < 0) {
            return true;
        }
        for (int i = 1; i < sections.size(); i++) {
            if (Arrays.equals(sections.get(0).getCoordinate(),sections.get(i).getCoordinate())) {
                return true;
            }
        }
        return false;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setDirection(int x, int y) {
        direction[0] = x;
        direction[1] = y;
    }

    public int[] getDirection() {
        return direction;
    }

    @Override
    public void draw(Graphics graphics) {
        for (Section section : sections) {
            section.draw(graphics);
        }
    }

    @Override
    public void paintItBlack(Graphics graphics) {
        for (Section section : sections) {
            section.paintItBlack(graphics);
        }
    }

    public boolean isEating() {
        return eating;
    }

    public void setEating(boolean eating) {
        this.eating = eating;
    }
}
