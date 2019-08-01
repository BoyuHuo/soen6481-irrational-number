import domain.Calculator;
import domain.MessageCenter;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        MessageCenter.getInstance().setCalculator(calculator);
        calculator.start();
    }
}
