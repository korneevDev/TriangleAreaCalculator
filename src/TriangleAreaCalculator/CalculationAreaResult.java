package TriangleAreaCalculator;

public class CalculationAreaResult {
    private Figure calculatorType;
    final private double result;

    public CalculationAreaResult(Figure calculatorType, double result){
        this(result);
        this.calculatorType = calculatorType;
    }

    public CalculationAreaResult(double result){
        this.result = result;
    }

    public double getResult(){
        return result;
    }

    @Override
    public String toString(){
        return "Recognized " + calculatorType.getClass().getSimpleName() +
                " with area " + result;
    }
}
