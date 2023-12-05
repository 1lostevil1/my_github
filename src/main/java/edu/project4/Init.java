package edu.project4;

public class Init {

    @SuppressWarnings({"UncommentedMain", "MagicNumber"})
    public static void main(String[] args) {

        FractalFlame flame = new FractalFlame(10000, 3000, 10, false, false);
        flame.render();
        Drawer drawerFlame = new Drawer(1920, 1080);
        drawerFlame.drawFlame(flame.getImage());
        drawerFlame.saveToFile();
    }
}
