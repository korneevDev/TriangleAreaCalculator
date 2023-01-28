package TriangleAreaCalculatorTest;

import TriangleAreaCalculator.CalculationAreaResult;
import TriangleAreaCalculator.Triangle.BaseTriangle;
import TriangleAreaCalculator.Triangle.EquilateralTriangle;
import TriangleAreaCalculator.Triangle.IsoscelesTriangle;
import TriangleAreaCalculator.Triangle.RightTriangle;
import TriangleAreaCalculator.TriangleCalculatorChain;
import TriangleAreaCalculator.TriangleCalculatorImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TriangleCalculatorTest {
    private static TriangleCalculatorChain calculatorChain;
    @BeforeAll
    public static void before(){
        calculatorChain = new TriangleCalculatorChain(
                new TriangleCalculatorImpl ((a) -> (a[0] == a[1] && a[1] == a[2]),
                        EquilateralTriangle::new),
                new TriangleCalculatorChain(
                        new TriangleCalculatorImpl(
                                (a) -> (a[0]==a[1] && a[0]!=a[2] || a[0]==a[2] && a[0]!=a[1] || a[1]==a[2] && a[1]!=a[0]),
                                IsoscelesTriangle::new),
                        new TriangleCalculatorChain(
                                new TriangleCalculatorImpl(
                                        (a)-> (a[0]*a[0] == a[1]*a[1]+a[2]*a[2] ||
                                                a[1]*a[1] == a[0]*a[0]+a[2]*a[2] ||
                                                a[2]*a[2] == a[0]*a[0]+a[1]*a[1]),
                                        RightTriangle::new
                                ),
                                new TriangleCalculatorImpl(BaseTriangle::new))
                ));
    }

    @Test
    public void test_base_triangle(){
        CalculationAreaResult expected = new CalculationAreaResult(
                new BaseTriangle(4, 5, 6), 9.921567416492215);
        CalculationAreaResult actual = calculatorChain.calculateArea(4, 5, 6);

        Assertions.assertEquals(expected.getResult(), actual.getResult(), 0.001);
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void test_equilateral_triangle(){
        CalculationAreaResult expected = new CalculationAreaResult(
                new EquilateralTriangle(5, 5, 5), 10.825317547305483);
        CalculationAreaResult actual = calculatorChain.calculateArea(5, 5, 5);

        Assertions.assertEquals(expected.getResult(), actual.getResult(), 0.001);
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void test_isosceles_triangle(){
        CalculationAreaResult expected = new CalculationAreaResult(new IsoscelesTriangle(5, 5, 8), 12.0);
        CalculationAreaResult actual = calculatorChain.calculateArea(5, 5, 8);

        Assertions.assertEquals(expected.getResult(), actual.getResult(), 0.001);
        Assertions.assertEquals(expected.toString(), actual.toString());

        actual = calculatorChain.calculateArea(5, 8, 5);

        Assertions.assertEquals(expected.getResult(), actual.getResult(), 0.001);
        Assertions.assertEquals(expected.toString(), actual.toString());

        actual = calculatorChain.calculateArea(8, 5, 5);

        Assertions.assertEquals(expected.getResult(), actual.getResult(), 0.001);
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void test_right_triangle(){
        CalculationAreaResult expected = new CalculationAreaResult(new RightTriangle(3, 4, 5), 6.0);
        CalculationAreaResult actual = calculatorChain.calculateArea(3, 4, 5);

        Assertions.assertEquals(expected.getResult(), actual.getResult(), 0.001);
        Assertions.assertEquals(expected.toString(), actual.toString());

        actual = calculatorChain.calculateArea(4, 3, 5);

        Assertions.assertEquals(expected.getResult(), actual.getResult(), 0.001);
        Assertions.assertEquals(expected.toString(), actual.toString());

        actual = calculatorChain.calculateArea(5, 3, 4);

        Assertions.assertEquals(expected.getResult(), actual.getResult(), 0.001);
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void test_wrong_sides_values(){
        try {
            calculatorChain.calculateArea (3, 5, 9);
        }
        catch (IllegalArgumentException e) {
            assert "Not correct side values".equals(e.getMessage());
        }
    }
}
