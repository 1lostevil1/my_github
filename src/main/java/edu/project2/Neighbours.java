package edu.project2;

import java.util.ArrayList;
import java.util.List;

public class Neighbours {
    public static int size;
    public static List<Cell> neighboursList;

    public Neighbours(Cell c) {
        this.neighboursList = new ArrayList<>();
        this.neighboursList = getNeighbours(c);

    }

    public static void notIgnoreWallBetween(Cell val) {
        Cell currentCell;
        int i = 0;
        while (i < neighboursList.size()) {
            currentCell = neighboursList.get(i);
            int xDiff = currentCell.x - val.x;
            int yDiff = currentCell.y - val.y;
            int addX;
            int addY;

            addX = (xDiff != 0) ? (xDiff / Math.abs(xDiff)) : 0;
            addY = (yDiff != 0) ? (yDiff / Math.abs(yDiff)) : 0;

            if (Generate.mazeMatrix[val.x + addX][val.y + addY].isWall) {
                neighboursList.remove(i);
                i--;
            }
            i++;
        }
        size = neighboursList.size();
    }

    public List<Cell> getNeighbours(Cell c) {
        final int THREE = 3;
        final int TWO = 2;
        final int FOUR = 4;
        int x = c.x;
        int y = c.y;
        Cell up = (x >= THREE ? Generate.mazeMatrix[x - TWO][y] : Generate.mazeMatrix[x][y]);
        Cell rt = (y < Generate.size - THREE ? Generate.mazeMatrix[x][y + TWO] : Generate.mazeMatrix[x][y]);
        Cell dw = (x < Generate.size - THREE ? Generate.mazeMatrix[x + TWO][y] : Generate.mazeMatrix[x][y]);
        Cell lt = (y >= THREE ? Generate.mazeMatrix[x][y - TWO] : Generate.mazeMatrix[x][y]);
        Cell[] neighboursArray = {dw, rt, up, lt};
        List<Cell> tmpneighboursList = new ArrayList<>();

        for (int i = 0; i < FOUR; i++) {
            if (neighboursArray[i] != Generate.mazeMatrix[x][y]
                && neighboursArray[i].x > 0
                && neighboursArray[i].x < Generate.size
                && neighboursArray[i].y > 0
                && neighboursArray[i].y < Generate.size) { //если не выходит за границы лабиринта
                if (!neighboursArray[i].isWall
                    && !neighboursArray[i].isVisited) { //и не посещена\является стеной
                    tmpneighboursList.add(neighboursArray[i]);
                }
            }
        }
        size = tmpneighboursList.size();
        return tmpneighboursList;

    }
}
