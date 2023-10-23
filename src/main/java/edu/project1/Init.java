package edu.project1;

@SuppressWarnings("uncommentedmain")
public class Init {
    private Init() {
    }

    private static final RandomWordSelector WORDSELECTOR = new RandomWordSelector();

    public static void main(String[] args) {
        GameLogic initialization = new GameLogic();
        initialization.start(WORDSELECTOR.getRandomWord());
    }
}
