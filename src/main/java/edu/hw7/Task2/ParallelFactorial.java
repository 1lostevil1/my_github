package edu.hw7.Task2;

import java.math.BigInteger;
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



    public BigInteger factorial() {

        if(value<=1) return new BigInteger("1");
        List<BigInteger> list = new ArrayList<>();
        for (int i = 2; i <= value; i++) {
            list.add(new BigInteger(String.valueOf(i)));
        }
        return list.parallelStream().reduce(new BigInteger("1"), BigInteger::multiply);
    }

    public static void main(String[] args) {

        ParallelFactorial a = new ParallelFactorial(11);
        System.out.print(a.factorial());
    }
}
