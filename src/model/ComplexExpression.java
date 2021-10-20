package model;

import java.util.Arrays;

public abstract class ComplexExpression {
    private final Operation op;
    private final Complex[] args;

    public ComplexExpression(Operation operation, Complex[] numbers) {
        this.op = operation;
        this.args = new Complex[numbers.length];
        System.arraycopy(numbers, 0, this.args, 0, numbers.length);
    }

    public Complex execute() {
        Complex result = args[0];

        for (int i = 1; i < args.length; i++)
            result = this.executeOneOperation(result, args[i]);

        return result;
    }

    @Override
    public String toString() {
        return "ComplexExpression{" +
                "op=" + op +
                ", args=" + Arrays.toString(args) +
                '}';
    }

    protected abstract Complex executeOneOperation(Complex nr1, Complex nr2);
}
