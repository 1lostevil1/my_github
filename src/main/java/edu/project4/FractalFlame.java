package edu.project4;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

public class FractalFlame {

    private static final int HEIGHT = 1080;
    private static final int WIDTH = 1920;
    private final double minX = -1.777;
    private final double maxX = 1.777;
    private final double minY = -1.;
    private final double maxY = 1.;
    private final int samples;
    private final int CountOfThreads;
    private final int samplesPerThread;
    private final int iterationsPerSample;
    private final int someSkippedIterations = -20;
    private final ExecutorService executorService;
    private final ReentrantLock lock = new ReentrantLock();
    private final boolean symmetry;
    private final boolean gammaCorrection;
    private final Pixel[][] image;

    public FractalFlame(int samples, int iterationsPerSample, int CountOfThreads, boolean symmetry, boolean gammaCorrection){

        image = new Pixel[WIDTH][HEIGHT];
        for(int i =0; i< WIDTH; i++){
            for (int j = 0; j< HEIGHT; j++){
                image[i][j] = new Pixel();
            }
        }
        this.samples = samples;
        this.iterationsPerSample = iterationsPerSample;
        this.CountOfThreads = CountOfThreads;
        this.samplesPerThread = samples/CountOfThreads;
        this.executorService = Executors.newFixedThreadPool(CountOfThreads);
        this.symmetry = symmetry;
        this.gammaCorrection = gammaCorrection;
    }

    public Pixel[][] getImage(){
        return image;
    }

    public void render(){
        var tasks = Stream.generate(() -> CompletableFuture.runAsync(
            this::renderPerThread,
            executorService
        )).limit(CountOfThreads).toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(tasks).join();
    }

    private void renderPerThread(){
        for(int i =0; i< samplesPerThread; i++) {
            double newX = ThreadLocalRandom.current().nextDouble(minX, maxX);
            double newY = ThreadLocalRandom.current().nextDouble(minY, maxY);
            for (int j = someSkippedIterations; j < iterationsPerSample; j++) {
                Function function = Functions.getFunction();
                Point point = transform(newX, newY, function);
                newX = point.x();
                newY = point.y();
                if(j>=0 && isPointInRange(point)){
                    point = findLocation(point);
                    if (isPointInDisplay(point)) {
                        try {
                            lock.lock();
                           int x = (int) point.x();
                            int y= (int) point.y();
                            image[x][ y].incrementCountHit();
                            image[x][y].setColor(new Colour(
                                (image[x][y].getColor().getRed()+function.rgb().getRed())/2,
                                (image[x][y].getColor().getGreen()+function.rgb().getGreen())/2,
                                (image[x][y].getColor().getBlue()+function.rgb().getBlue())/2
                            ));
                        }
                        finally {
                                    lock.unlock();
                        }
                    }

                }
            }
        }
    }

    private Point transform(double x, double y, Function function){
        //Афинное преобразование
        double newX = 0;
        double newY = 0;
        double finalX = function.coefficients().a() * x + function.coefficients().b() * y
            + function.coefficients().c();
        double finalY = function.coefficients().d() * x + function.coefficients().e() * y
            + function.coefficients().f();

        //Нелинейное преобразование
        List<Fractal> fractals = function.Fractals();
        Point point = new Point(finalX, finalY);
        for(Fractal fractal : fractals ) {
                point = fractal.apply(function.coefficients(), point);
        }
        return point;
    }

    private boolean isPointInRange(Point point) {
        return minX <= point.x() && point.x() <= maxX
            && minY <= point.y() && point.y() <= maxY;
    }

    private Point findLocation(Point point) {
        return new Point(
            (point.x() -minX) / (maxX - minX) * WIDTH,
            (point.y() - minY) / (maxY - minY) * HEIGHT
        );
    }

    private boolean isPointInDisplay(Point point) {
        return 0 <= point.x() && point.x() <= WIDTH
            && 0 <= point.y() && point.y() <= HEIGHT;
    }

}
