package TriangleAreaCalculator.Triangle;

import TriangleAreaCalculator.CalculationAreaResult;
import TriangleAreaCalculator.Figure;

public class BaseTriangle implements Figure {
    final protected int a;
    final protected int b;
    final protected int c;

    public BaseTriangle(int a, int b, int c) {
        if(isCorrect(a, b, c)) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        else throw new IllegalArgumentException("Not correct side values");
    }

    public BaseTriangle(int[] nums){
        this(nums.length==3? nums[0] : -1, nums.length==3? nums[1] : -1, nums.length==3? nums[2] : -1);
    }

    private boolean isCorrect(int a, int b, int c) {
        boolean isPositive = a>0 && b>0 && c>0;
        boolean isTriangle = a+b>c && a+c>b && b+c>a;

        return isPositive && isTriangle;
    }

    public CalculationAreaResult getArea(){
        double halfPerimeter = (a+b+c)/2.0;
        double result = Math.sqrt(halfPerimeter * (halfPerimeter-a) *
                                        (halfPerimeter-b) *
                                        (halfPerimeter-c));

        return new CalculationAreaResult(this, result);
    }
}
