package edu.project2;

public class Init {


    public static void main(String[] args) {
        int size = 5;
        Generate a = new Generate(size);
        a.maze();
        a.GEN3000();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
               if (a.get()[i][j].isWall())  System.out.print("[]") ;
                else System.out.print("  ");
            }
            System.out.println();
        }

    }
}
