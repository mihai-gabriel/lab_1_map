package model;

public class Addition extends ComplexExpression {
    public Addition(Operation operation, Complex[] args) {
        super(operation, args);
    }

    @Override
    protected Complex executeOneOperation(Complex nr1, Complex nr2) {
        return new Complex(nr1).add(nr2);
    }
}
