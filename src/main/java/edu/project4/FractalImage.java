package edu.project4;

public class FractalImage {
    private final static int HEIGHT = 1080;
    private final static int WIDTH = 1920;
    private Pixel[][] image;

    public FractalImage(){

        image = new Pixel[WIDTH][HEIGHT];
        for(int i = 0;i<HEIGHT;i++){
            for(int j = 0;j<WIDTH;j++){
                image[i][j] = new Pixel(i,j, new Colour(0,0,0), 0);
            }
        }
    }

    public void render(){
    }
}
