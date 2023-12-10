package edu.project2;

public class Cell {
    public final int x;
    public final int y;
    public boolean isWall;
    public boolean isVisited;
    public boolean  isWay;
    public boolean isStartOrFinish;

    Cell(int x, int y, boolean isWall, boolean isVisited, boolean isWay, boolean isStartOrFinish) {
        this.x = x;
        this.y = y;
        this.isWall = isWall;
        this.isVisited = isVisited;
        this.isWay = isWay;
        this.isStartOrFinish = isStartOrFinish;
    }
}
