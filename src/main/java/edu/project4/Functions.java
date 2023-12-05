package edu.project4;


import edu.project4.SomePatterns.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Functions {

    private  Functions(){}


    private static List<Function> FunctionList = List.of(
        new Function(Coefficients.getCoefficients(), new Colour(),
            List.of( new SPIRAL(), new HYPERBOLIC())),
        new Function(Coefficients.getCoefficients(), new Colour(),
            List.of(new HEART(), new DIAMOND(), new TANGENT())),
        new Function(Coefficients.getCoefficients(), new Colour(),
            List.of(new HYPERBOLIC(), new DISC(), new FISHEYE())),
        new Function(Coefficients.getCoefficients(), new Colour(),
            List.of(new HEART(), new DISC()))

    );

    public static Function getFunction(){
        return FunctionList.get(ThreadLocalRandom.current().nextInt(FunctionList.size()));
    }
}
