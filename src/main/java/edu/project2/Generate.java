package edu.project2;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Generate {

    public class Cell {
        private int x, y;
        private boolean isWall, isVisited;

        Cell(int x, int y, boolean isWall, boolean isVisited) {
            this.x = x;
            this.y = y;
            this.isWall = isWall;
            this.isVisited = isVisited;
        }

        public boolean isWall() {
            return isWall;
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

    public void add(Cell value) {
        CoordStack.add(value);
    }

    public void maze() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if ((j % 2 != 0 && i % 2 != 0) &&
                    (i < SIZE - 1 && j < SIZE - 1)) {
                    mazeMatrix[i][j] = new Cell(i, j, false, false);
                } else {
                    mazeMatrix[i][j] = new Cell(i, j, true, false);
                }
            }
        }
    }

    public void removeWall(Cell first, Cell second) {
        int xDiff = second.x - first.y;
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
                if (mazeMatrix[i][j].isVisited == false && !mazeMatrix[i][j].isWall)
                    count++;
            }
        }
        return count;
    }

    public ArrayList<Cell> unvisitedList() {
        ArrayList<Cell> list = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (mazeMatrix[i][j].isVisited == false && !mazeMatrix[i][j].isWall)
                    list.add(mazeMatrix[i][j]);
            }
        }
        return list;
    }
    public void GEN3000() {
        mazeMatrix[0][0].isVisited = true;
        Cell startCell = mazeMatrix[0][0];
        Cell currentCell = startCell;
        Cell neighbourCell = new Cell(0,0,false,false);
        ArrayList<Cell> UnvisitedList = new ArrayList<>();
        do {
            Neighbours Neighbours = new Neighbours(currentCell);
            if (Neighbours.size != 0) {  //если у клетки есть непосещенные соседи
                Random random = new Random();
                int randNum = random.nextInt(0, Neighbours.size );
                neighbourCell = Neighbours.NeighboursList.get(randNum); //выбираем случайного соседа
                CoordStack.push(currentCell); //заносим текущую точку в стек
                removeWall(currentCell, neighbourCell); //убираем стену между текущей и сосендней точками
                currentCell = neighbourCell; //делаем соседнюю точку текущей и отмечаем ее посещенной
                mazeMatrix[CoordStack.peek().x][CoordStack.peek().y].isVisited = true;
            } else if (CoordStack.size() > 0) { //если нет соседей, возвращаемся на предыдущую точку
                CoordStack.pop();
            } else {    //если нет соседей и точек в стеке, но не все точки посещены, выбираем случайную из непосещенных
                mazeMatrix[currentCell.x][currentCell.y].isVisited = true;
                Random random = new Random();
                 UnvisitedList = unvisitedList();
                int randNum = random.nextInt(UnvisitedList.size());
                currentCell = UnvisitedList.get(randNum);
            }

        } while ( unvisitedCount() > 0);
    }
}
