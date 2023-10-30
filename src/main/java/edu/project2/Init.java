package edu.project2;

import java.util.ArrayList;

public class Init {

    public static void main(String[] args) {
        int size = 11;
        Generate a = new Generate(size);
        a.GEN3000();
        a.makeUnvisited();
        Generate.Neighbours b = new Generate.Neighbours(new  Generate.Cell(1,7,false,true,false));
        a.print();
    }
}
