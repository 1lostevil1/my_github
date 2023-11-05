package edu.project2;

import java.util.ArrayList;
import java.util.List;

public class Neighbours {
    public static int size;
    public List<Cell> NeighboursList;

    public Neighbours(Cell c) {
        this.NeighboursList = new ArrayList<>();
        this.NeighboursList = getNeighbours(c);

    }

    public void notIgnoreWallBetween(Cell val) {
        Cell currentCell;
        for (int i = 0; i < NeighboursList.size(); i++) {
            currentCell = NeighboursList.get(i);
            int xDiff = currentCell.x - val.x;
            int yDiff = currentCell.y - val.y;
            int addX, addY;

            addX = (xDiff != 0) ? (xDiff / Math.abs(xDiff)) : 0;
            addY = (yDiff != 0) ? (yDiff / Math.abs(yDiff)) : 0;

            if (Generate.mazeMatrix[val.x + addX][val.y + addY].isWall) {
                NeighboursList.remove(i);
                i--;
            }
        }
        size = NeighboursList.size();
    }

    public List<Cell> getNeighbours(Cell c) {
        int x = c.x;
        int y = c.y;
        Cell up = (x >= 3 ? Generate.mazeMatrix[x - 2][y] : Generate.mazeMatrix[x][y]);
        Cell rt = (y < Generate.SIZE - 3 ? Generate.mazeMatrix[x][y + 2] : Generate.mazeMatrix[x][y]);
        Cell dw = (x < Generate.SIZE - 3 ? Generate.mazeMatrix[x + 2][y] : Generate.mazeMatrix[x][y]);
        Cell lt = (y >= 3 ? Generate.mazeMatrix[x][y - 2] : Generate.mazeMatrix[x][y]);
        Cell[] neighboursArray = {dw, rt, up, lt};
        List<Cell> neighboursList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            if (neighboursArray[i] != Generate.mazeMatrix[x][y] && neighboursArray[i].x > 0 &&
                neighboursArray[i].x < Generate.SIZE && neighboursArray[i].y > 0 &&
                neighboursArray[i].y < Generate.SIZE) { //если не выходит за границы лабиринта
                if (!neighboursArray[i].isWall && !neighboursArray[i].isVisited) { //и не посещена\является стеной
                    neighboursList.add(neighboursArray[i]);
                }
            }
        }
        size = neighboursList.size();
        return neighboursList;

    }
}
