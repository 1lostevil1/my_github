package edu.project4;

import java.util.List;

public record Function(Coefficients coefficients,
                       Colour rgb, Coefficients finalCoef,
                       List<Option> variants) {
}
