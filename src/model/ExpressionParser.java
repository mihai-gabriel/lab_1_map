package model;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionParser {

    public ComplexExpression parseExp(String[] args) throws CustomException {
        if (expressionValid(args)) {
            String operator = args[1];
            Operation operation = switch (operator) {
                case "+" -> Operation.ADDITION;
                case "-" -> Operation.SUBTRACTION;
                case "*" -> Operation.MULTIPLICATION;
                default -> Operation.DIVISION;
            };

            Complex[] complexNumbers = buildArgs(args);
            ExpressionFactory expFactory = ExpressionFactory.getInstance();

            return expFactory.createExpression(operation, complexNumbers);
        } else {
            throw new CustomException("Args not valid");
        }
    }

    private Complex[] buildArgs(String[] args) {
        Complex[] result = new Complex[args.length / 2 + 1];
        int counter = 0;

        Pattern pattern1 = Pattern.compile("^(-?[0-9]+(\\.[0-9]+)?)(([+-]([0-9]+(\\.[0-9]+)?)?)(\\*)?i)$"); // both re and im
        Pattern pattern2 = Pattern.compile("(([+-])?[0-9]+(\\.[0-9]+)?)?(\\*)?i$"); // only im (2+i), not covering only i
        Pattern pattern3 = Pattern.compile("(-?[0-9]+(\\.[0-9]+)?)"); // only re


        for (int i = 0; i < args.length; i += 2) {
            double re = 0, im = 0;

            Matcher matcher1 = pattern1.matcher(args[i]);
            Matcher matcher2 = pattern2.matcher(args[i]);
            Matcher matcher3 = pattern3.matcher(args[i]);

            if (matcher1.find()) {
                re = Double.parseDouble(matcher1.group(1));
                im = ((matcher1.group(3).length() == 2) ? 1 : Double.parseDouble(matcher1.group(4)));
            } else if (matcher2.find()) {
                re = 0;
                im = Double.parseDouble(matcher2.group(1));
            } else if (matcher3.find()) {
                re = Double.parseDouble(matcher3.group(1));
                im = 0;
            }

            result[counter++] = new Complex(re, im);
        }

        return result;
    }

    private boolean expressionValid(String[] args) {
        if (args.length % 2 == 0)
            return false;

        if (args.length == 1)
            return complexNrValid(args[0]);

        String operator = args[1];

        if (!List.of("+", "*", "-", "/").contains(operator))
            return false;

        for (int i = 0; i < args.length; i++) {
            if (i % 2 == 0) {
                if (!complexNrValid(args[i])) {
                    return false;
                }
            } else {
                if (!args[i].equals(operator)) {
                    return false;
                }
            }

        }

        return true;
    }

    private boolean complexNrValid(String complexNr) {
        // match: signed digits[.digits] +/- digits[.digits]*i
        return complexNr.matches("^(-?[0-9]+)?(\\.[0-9]+)?([+-])?(([0-9]+(\\.[0-9]+)?\\*)?i)?$");
    }
}
