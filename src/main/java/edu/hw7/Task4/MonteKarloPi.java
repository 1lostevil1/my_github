package edu.hw7.Task4;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;

public class MonteKarloPi {

    private  final static int RADIUS = 4;
    private  static long MAX_COUNT;

    public MonteKarloPi(long count){
        MAX_COUNT = count;
    }

    public double PiCalculate(){

        double circleCount = 0;
        for(long i = 0; i< MAX_COUNT; i++){
           point point = new point(new Random().nextFloat(-RADIUS,RADIUS),new Random().nextFloat(-RADIUS,RADIUS));
            if (point.x()*point.x() + point.y()*point.y()<= RADIUS*RADIUS) circleCount++;
        }
        return 4 * (circleCount / MAX_COUNT);
    }

    public static void main(String[] args) {
       long before = System.nanoTime ();
        MonteKarloPi a = new MonteKarloPi(10000000);
        System.out.println(a.PiCalculate());
        long after = System.nanoTime ();
        System.out.print(after - before);

    }
}
