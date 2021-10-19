package model;

public class Subtraction extends ComplexExpression {
    public Subtraction(Operation operation, Complex[] args) {
        super(operation, args);
    }

    @Override
    protected Complex executeOneOperation(Complex nr1, Complex nr2) {
        return new Complex(nr1).subtract(nr2);
    }
}
