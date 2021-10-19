import model.ComplexExpression;
import model.CustomException;
import model.ExpressionParser;

public class Main {
    public static void main(String[] args) {
        try {
            ExpressionParser ep = new ExpressionParser();
            ComplexExpression exp = ep.parseExp(args);

            System.out.println("Rezultatul este: " + exp.execute());
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }
}
