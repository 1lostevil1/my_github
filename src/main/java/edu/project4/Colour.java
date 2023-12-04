package edu.project4;

import java.util.concurrent.ThreadLocalRandom;

public class Colour {

    private int Red;
    private int Green;
    private int Blue;

    public  Colour() {
        Red = ThreadLocalRandom.current().nextInt(256);
        Green = ThreadLocalRandom.current().nextInt(256);
        Blue = ThreadLocalRandom.current().nextInt(256);
    }

    public  Colour(int Red, int Green, int Blue) {
       this.Red = Red;
       this.Green = Green;
       this.Blue = Blue;
    }

    public int getRed(){
        return Red;
    }
    public int getGreen(){
        return Green;
    }
    public int getBlue(){
        return Blue;
    }

    public int getRGB() {
        return (Red << 16 | Green << 8 | Blue);
    }

    public void setRed(int Red){
        this.Red = Red;
    }
    public void setGreen(int Green){
        this.Green = Green;
    }
    public void setBlue(int Blue){
        this.Blue = Blue;
    }
}
