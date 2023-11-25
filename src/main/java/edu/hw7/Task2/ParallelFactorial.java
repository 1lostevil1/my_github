package edu.hw7.Task2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelFactorial {

    public int value;

    public ParallelFactorial(int value) {
        this.value = value;
    }

    private boolean isSimpleValue(Integer value) {
        for (int i = 2; i <= value / 2; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int Factorize(int value) {
        int result = value;
        if (value == 3) {
            value = 3;
        }
        int power = 0;
        while (result <= this.value) {
            power += this.value / result;
            result *= value;
        }
        return (int) Math.pow(value, power);
    }

    public int factorial() {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= value; i++) {
            list.add(i);
        }
        int result = 1;
        list = list.parallelStream()
            .filter(elem -> isSimpleValue(elem))
            .map(val -> Factorize(val))
            .collect(Collectors.toList());
        Iterator<Integer> Iterator = list.iterator();
        while (Iterator.hasNext()) {
            result *= Iterator.next();
        }
        return result;
    }

    public static void main(String[] args) {

        ParallelFactorial a = new ParallelFactorial(11);
        System.out.print(a.factorial());
    }
}
