package edu.project2;

public class Init {

    public static void main(String[] args) {
        int size = 11;
        Generate a = new Generate(size);
        a.maze();
        a.GEN3000();
        a.makeUnvisited();
        Generate.Cell start = new Generate.Cell(1, 1, false, true, true);
        Generate.Cell finish = new Generate.Cell(5, 3, false, false, false);
        a.print();
    }
}
