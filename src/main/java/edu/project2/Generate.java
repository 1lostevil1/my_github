package edu.project2;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Generate {

    public static class Cell {
        private final int x, y;
        private boolean isWall, isVisited, isWay;

        Cell(int x, int y, boolean isWall, boolean isVisited, boolean isWay) {
            this.x = x;
            this.y = y;
            this.isWall = isWall;
            this.isVisited = isVisited;
            this.isWay = isWay;
        }

    }
public void print(){
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
            if (mazeMatrix[i][j].isWall)  System.out.print("[]") ;
            if (mazeMatrix[i][j].isWay) System.out.print("* ");
                else if (!mazeMatrix[i][j].isWall) System.out.print("  ");
        }
        System.out.println();
    }

}

    private static Cell[][] mazeMatrix;

    private static int SIZE;
    public Stack<Cell> CoordStack;

    public Generate(int size) {
        this.SIZE = size;
        CoordStack = new Stack<Cell>();
        mazeMatrix = new Cell[size][size];
    }

    public static Cell[][] get() {
        return mazeMatrix;
    }

    private class Neighbours {
        private static int size;
        public List<Cell> NeighboursList;

        public Neighbours(Cell c) {
            this.NeighboursList = new ArrayList<Cell>();
            this.NeighboursList = getNeighbours(c);

        }

        public void notIgnoreWallBetween(Cell val) {
            Cell currentCell = val;
            for(int i =0; i<NeighboursList.size();i++) {
                currentCell = NeighboursList.get(i);
                int xDiff = val.x - currentCell.x;
                int yDiff = val.y - currentCell.y;
                int addX, addY;

                addX = (xDiff != 0) ? (xDiff / Math.abs(xDiff)) : 0;
                addY = (yDiff != 0) ? (yDiff / Math.abs(yDiff)) : 0;

                if (mazeMatrix[val.x + addX][val.y + addY].isWall) NeighboursList.remove(i);
            }
            size = NeighboursList.size();
        }

        public List<Cell> getNeighbours(Cell c) {
            int x = c.x;
            int y = c.y;
            Cell up = (y<SIZE-2 ? mazeMatrix[x][y + 2]: mazeMatrix[x][y]);
            Cell dw = (y>1?  mazeMatrix[x][y - 2] :mazeMatrix[x][y]) ;
            Cell rt = (x<SIZE-2 ? mazeMatrix[x+2][y]: mazeMatrix[x][y]);
            Cell lt = (x>1?  mazeMatrix[x-2][y] :mazeMatrix[x][y]) ;
            Cell[] neighboursArray = {dw, rt, up, lt};
            List<Cell> neighboursList = new ArrayList<>();

            for (int i = 0; i < 4; i++) {
                if (neighboursArray[i]!= mazeMatrix[x][y] && neighboursArray[i].x > 0 && neighboursArray[i].x < SIZE && neighboursArray[i].y > 0 &&
                    neighboursArray[i].y < SIZE) { //если не выходит за границы лабиринта
                    if (!neighboursArray[i].isWall && !neighboursArray[i].isVisited) { //и не посещена\является стеной
                        neighboursList.add(neighboursArray[i]);
                    }
                }
            }
            size = neighboursList.size();
            return neighboursList;

        }
    }


    public void maze() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if ((j % 2 != 0 && i % 2 != 0) &&
                    (i < SIZE - 1 && j < SIZE - 1)) {
                    mazeMatrix[i][j] = new Cell(i, j, false, false,false);
                } else {
                    mazeMatrix[i][j] = new Cell(i, j, true, false,false);
                }
            }
        }
    }

    public void removeWall(Cell first, Cell second) {
        int xDiff = second.x - first.x;
        int yDiff = second.y - first.y;
        int addX, addY;

        addX = (xDiff != 0) ? (xDiff / Math.abs(xDiff)) : 0;
        addY = (yDiff != 0) ? (yDiff / Math.abs(yDiff)) : 0;

        mazeMatrix[first.x + addX][first.y + addY].isWall = false;
        mazeMatrix[first.x + addX][first.y + addY].isVisited = true;
    }



    public int unvisitedCount() {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (!mazeMatrix[i][j].isVisited  && !mazeMatrix[i][j].isWall)
                    count++;
            }
        }
        return count;
    }

    public void makeUnvisited(){
        for(int i =0; i< SIZE;i++){
            for(int j = 0; j< SIZE; j++){
                if(mazeMatrix[i][j].isVisited) mazeMatrix[i][j].isVisited=false;
            }
        }
    }

    public void wayFound(Cell start, Cell finish){
        mazeMatrix[start.x][start.y].isVisited = true;
        mazeMatrix[start.x][start.y].isWay = true;
        CoordStack.clear();
        CoordStack.push(start);
        Cell currentCell = start;
        Cell neighbourCell;
        while(currentCell.x != finish.x || currentCell.y != finish.y){
            Neighbours Neighbours = new Neighbours(currentCell);
            Neighbours.notIgnoreWallBetween(currentCell);
            if (Neighbours.size != 0) {
                Random random = new Random();
                int randNum = random.nextInt(0, Neighbours.size );
                neighbourCell = Neighbours.NeighboursList.get(randNum);
                CoordStack.push(currentCell);
                currentCell = neighbourCell;
                mazeMatrix[ currentCell.x][ currentCell.y].isVisited = true;
                mazeMatrix[ currentCell.x][ currentCell.y].isWay = true;
            } else if (CoordStack.size() > 0) {
                mazeMatrix[CoordStack.peek().x][CoordStack.peek().y].isWay = false;
                CoordStack.pop();
                currentCell =  mazeMatrix[CoordStack.peek().x][CoordStack.peek().y];
            }

        }
    }

    public void GEN3000() {
        mazeMatrix[1][1].isVisited = true;
        Cell startCell = mazeMatrix[1][1];
        Cell currentCell = startCell;
        Cell neighbourCell;
        do {
            Neighbours Neighbours = new Neighbours(currentCell);
            if (Neighbours.size != 0) {  //если у клетки есть непосещенные соседи
                Random random = new Random();
                int randNum = random.nextInt(0, Neighbours.size );
                neighbourCell = Neighbours.NeighboursList.get(randNum); //выбираем случайного соседа
                CoordStack.push(currentCell); //заносим текущую точку в стек
                removeWall(currentCell, neighbourCell); //убираем стену между текущей и сосендней точками
                currentCell = neighbourCell; //делаем соседнюю точку текущей и отмечаем ее посещенной
                mazeMatrix[ currentCell.x][ currentCell.y].isVisited = true;
            } else if (CoordStack.size() > 0) {
                                    //если нет соседей, возвращаемся на предыдущую точку
                CoordStack.pop();
                currentCell =  mazeMatrix[CoordStack.peek().x][CoordStack.peek().y];
            }

        } while ( unvisitedCount() > 0);
    }
}
