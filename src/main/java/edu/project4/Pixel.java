package edu.project4;

public class Pixel {

    private Colour rgb;
    private int countHit;

    public Pixel() {
        countHit = 0;
        rgb = new Colour(0, 0, 0);
    }

    public Pixel(int countHit, Colour rgb) {
        this.countHit = countHit;
        this.rgb = rgb;
    }

    public void incrementCountHit() {
        countHit++;
    }

    public Colour getColor() {
        return rgb;
    }

    public void setColor(Colour rgb) {
         this.rgb = rgb;
    }

    public int getCountHit() {
        return countHit;
    }

}

