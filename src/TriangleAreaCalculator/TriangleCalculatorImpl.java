package TriangleAreaCalculator;

public class TriangleCalculatorImpl implements TriangleCalculator{
    final private TypedTriangleCalculatorSetter setter;
    private TypedTriangleCalculatorChecker checker;

    public TriangleCalculatorImpl(TypedTriangleCalculatorSetter setter) {
        this.setter = setter;
    }

    public TriangleCalculatorImpl(TypedTriangleCalculatorChecker checker, TypedTriangleCalculatorSetter setter) {
        this(setter);
        this.checker = checker;
    }

    @Override
    public CalculationAreaResult calculateArea(int... numbers) {
        CalculationAreaResult result;

        if(checker == null || checker.checkType(numbers))
            result = setter.getConcreteTriangle(numbers).getArea();
        else
           result = new CalculationAreaResult(0);

        return result;
    }
}
