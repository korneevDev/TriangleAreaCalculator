package TriangleAreaCalculator;

public class TriangleCalculatorChain implements TriangleCalculator{
    final private TriangleCalculator current;
    final private TriangleCalculator next;

    public TriangleCalculatorChain(TriangleCalculator current, TriangleCalculator next) {
        this.current = current;
        this.next = next;
    }

    @Override
    public CalculationAreaResult calculateArea(int... numbers) {
        CalculationAreaResult result = current.calculateArea(numbers);

        if(result.getResult() == 0){
            result = next.calculateArea(numbers);
        }

        return result;
    }
}
