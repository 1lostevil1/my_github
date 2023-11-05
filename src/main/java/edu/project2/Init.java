package edu.project2;

import java.util.Random;

public class Init {
    public static void main(String[] args) {
        int size = 101;
        Generate a = new Generate(size);
        a.GEN3000();
        Random random = new Random();
        int rand1 = random.nextInt(1, size - 2);
        int rand2 = random.nextInt(1, size - 2);
        if (rand1 % 2 == 0) {
            rand1++;
        }
        if (rand2 % 2 == 0) {
            rand2++;
        }
        Cell start = new Cell(rand1, rand1, false, true, true, false);
        Cell finish = new Cell(rand2, rand2, false, false, false, false);
        a.wayFound(start, finish);
        a.print();
    }
}
