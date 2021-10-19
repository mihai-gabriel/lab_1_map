package model;

public class Division extends ComplexExpression {
    public Division(Operation operation, Complex[] args) {
        super(operation, args);
    }

    @Override
    protected Complex executeOneOperation(Complex nr1, Complex nr2) {
        return new Complex(nr1).divide(nr2);
    }
}
