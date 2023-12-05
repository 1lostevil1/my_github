package edu.project4;

public class Init {

    @SuppressWarnings({"UncommentedMain", "MagicNumber"})
    public static void main(String[] args) {

        FractalFlame flame = new FractalFlame(10000, 2500, 20, true, 1.5);
        flame.render();
        flame.gammaCorrection();
        Drawer drawerFlame = new Drawer(1920, 1080);
        drawerFlame.drawFlame(flame.getImage());
        drawerFlame.saveToFile();
    }
}
