package edu.project2;

import java.util.ArrayList;

public class Init {

    public static void main(String[] args) {
        int size = 31;
        Generate a = new Generate(size);
        a.GEN3000();
        a.makeUnvisited();
        Generate.Cell start = new Generate.Cell(1,1,false,true,true);
        Generate.Cell finish = new Generate.Cell(7,7,false,false,false);
        a.wayFound(start,finish);
        a.print();
    }
}
