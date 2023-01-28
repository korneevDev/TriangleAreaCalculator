package TriangleAreaCalculator.Triangle;

import TriangleAreaCalculator.CalculationAreaResult;

public class EquilateralTriangle extends IsoscelesTriangle {
    public EquilateralTriangle (int a, int b, int c) {
        super (getCorrectSides (a, b, c));
    }

    public EquilateralTriangle (int[] sides) {
        this (sides[0], sides[1], sides[2]);
    }

    private static int[] getCorrectSides (int a, int b, int c) {
        if (a != b || b != c)
            throw new IllegalArgumentException ("Not sides of equilateral triangle");

        return new int[] {a, b, c};
    }

    @Override
    public CalculationAreaResult getArea () {
        return new CalculationAreaResult(this, (a * a * Math.sqrt (3)) / 4);
    }
}
