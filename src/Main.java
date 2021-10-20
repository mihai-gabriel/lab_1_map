import model.ComplexExpression;
import exceptions.CustomException;
import service.ExpressionParser;

public class Main {
    public static void main(String[] args) {
        try {
            ExpressionParser ep = new ExpressionParser();
            ComplexExpression exp = ep.parseExp(args);

            System.out.println("Result: " + exp.execute());
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }
}
