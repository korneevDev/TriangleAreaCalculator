package TriangleAreaCalculator.Triangle;

import TriangleAreaCalculator.CalculationAreaResult;

import java.util.Arrays;

public class RightTriangle extends BaseTriangle {
    public RightTriangle(int a, int b, int c) {
        super(getCorrectSides(a, b, c));
    }

    public RightTriangle(int[] sides) {
        this(sides[0], sides[1], sides[2]);
    }

    private static int[] getCorrectSides(int a, int b, int c) {
        int[] sides = new int[]{a, b, c};
        Arrays.sort(sides);

        if(!checkCorrect(sides[0], sides[1], sides[2]))
            throw new IllegalArgumentException("Not sides of right triangle");

        return sides;
    }

    private static boolean checkCorrect(int a, int b, int c) {
        return c*c == a*a + b*b;
    }

    @Override
    public CalculationAreaResult getArea() {
        return new CalculationAreaResult(this, 0.5 * a * b);
    }
}
