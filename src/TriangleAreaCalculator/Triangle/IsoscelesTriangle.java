package TriangleAreaCalculator.Triangle;


import TriangleAreaCalculator.CalculationAreaResult;

public class IsoscelesTriangle extends BaseTriangle {
    public IsoscelesTriangle(int a, int b, int c) {
        super(getCorrectSides(a, b, c));
    }

    public IsoscelesTriangle(int[] sides) {
        this(sides[0], sides[1], sides[2]);
    }

    private static int[] getCorrectSides(int a, int b, int c){
        int[] sides = new int[3];
        if(a == b)
            setSides(sides, a, b, c);
        else if(b == c)
            setSides(sides, b, c, a);
        else if(a == c)
            setSides(sides, a, c, b);
        else
            throw new IllegalArgumentException("Not sides of isosceles triangle");

        return sides;
    }

    private static void setSides(int[] sides, int a, int b, int c){
        sides[0] = a;
        sides[1] = b;
        sides[2] = c;
    }

    @Override
    public CalculationAreaResult getArea() {
        return new CalculationAreaResult(this, 0.5 * getHeight() * c);
    }

    private double getHeight(){
        return Math.sqrt(a*a - Math.pow(c/2.0, 2));
    }
}
