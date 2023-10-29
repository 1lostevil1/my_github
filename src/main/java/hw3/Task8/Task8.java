package hw3.Task8;

import java.util.List;

public class Task8 {
    private Task8() {
    }

    public static void main(String[] args) {
        BackwardIterator<Integer> it = new BackwardIterator<>(List.of(1, 2, 3));

        while (it.hasNext()) {

            System.out.println(it.next());
        }

    }
}
