package service;

import model.*;

public class ExpressionFactory {
    private static ExpressionFactory instance = null;

    private ExpressionFactory() {}

    public static ExpressionFactory getInstance() {
        if (instance == null) {
            instance = new ExpressionFactory();
        }

        return instance;
    }

    public ComplexExpression createExpression(Operation operation, Complex[] args) {
        ComplexExpression exp;

        switch (operation) {
            case ADDITION -> exp = new Addition(operation, args);
            case SUBTRACTION -> exp = new Subtraction(operation, args);
            case MULTIPLICATION -> exp = new Multiplication(operation, args);
            default -> exp = new Division(operation, args);
        }

        return exp;
    }

}
