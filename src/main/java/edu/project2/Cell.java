package edu.project2;

public class Cell {
    public final int x, y;
    public boolean isWall, isVisited, isWay, isStartOrFinish;

    Cell(int x, int y, boolean isWall, boolean isVisited, boolean isWay, boolean isStartOrFinish) {
        this.x = x;
        this.y = y;
        this.isWall = isWall;
        this.isVisited = isVisited;
        this.isWay = isWay;
        this.isStartOrFinish = isStartOrFinish;
    }
}
