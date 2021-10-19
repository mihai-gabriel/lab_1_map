package model;

public class Multiplication extends ComplexExpression {
    public Multiplication(Operation operation, Complex[] args) {
        super(operation, args);
    }

    @Override
    protected Complex executeOneOperation(Complex nr1, Complex nr2) {
        return new Complex(nr1).multiply(nr2);
    }
}
