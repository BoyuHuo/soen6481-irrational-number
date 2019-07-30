import java.util.Scanner;

public class MessageCenter {

    public String msg;
    public String formula = "";
    private Calculator calculator;
    private static MessageCenter instance;
    private Scanner cin = new Scanner(System.in);

    private MessageCenter() {
    }

    //Singleton
    public static MessageCenter getInstance() {
        if (instance == null) {
            instance = new MessageCenter();
        }
        return instance;
    }


    public void initScreen() {

        instance.msg = "---MainScreen------------------------------------------------------\n" +
                "Welcome, Please choose a function:\n" +
                "   => 1. General Calculation\n" +
                "   => 2. Calculate the area of a circle\n" +
                "   => 3. Calculate the circumference of a circle\n" +
                "   => 4. Modify the precise degree of PI \n" +
                "   => 0: Exist";
        System.out.println(instance.msg);
        String instruction = getInstractionFromConsule();
        switch (instruction) {
            case "1":
                General(0);
                break;
            case "2":
                areaOfCircle();
                break;
            case "3":
                circumferenceOfArea();
                break;
            case "4":

                break;
            case "0":
                System.out.println("Bye! :)");
                System.exit(0);
                break;
            default:
                System.out.println("Unknown behavior! ");
                initScreen();
                break;
        }
    }


    public void General(int flag) {  // Flag: 0: get value   Flag: 1 : get operator  Flag 2 : get result
        switch (flag) {
            case 0:
                instance.msg = "---GeneralCalculation--------------------------------------------\n" +
                        "=> Digital Number range: (4.9E-324(MIN_DOUBLE_VALUE),1.79E308(MAX_DOUBLE_VALUE)) \n" +
                        "=> To use PI input: p  \n" +
                        "=> To clear this calculation input: c \n" +
                        "Your Currently Calculation: " + instance.formula + "\n" +
                        "Please input a number:";
                System.out.println(instance.msg);
                String instruction = getInstractionFromConsule();
                switch (instruction) {
                    case "p":
                        double pi = PI.getValue();
                        if (calculator.isFirst) {
                            calculator.setFirstNumber(pi);
                            calculator.isFirst = false;
                        } else {
                            calculator.setSecondNumber(pi);
                            calculator.isSecond = true;
                            calculator.calculate();

                        }
                        break;
                    case "c":
                        break;
                    default:
                        try {
                            double number = Double.parseDouble(instruction);
                            if (calculator.isFirst) {
                                calculator.setFirstNumber(number);
                                calculator.isFirst = false;
                            } else {
                                calculator.setSecondNumber(number);
                                calculator.isSecond = true;
                                calculator.calculate();

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Wrong number!");
                            General(flag);
                        }
                        break;
                }
                General(1);
                break;
            case 1:
                instance.msg = "=> Operators: + - * / = \n" +
                        "=> the operator = will get the result and end this calculation;  \n" +
                        "Your Currently Calculation: " + instance.formula + "\n" +
                        "Please input a operator:";
                System.out.println(instance.msg);
                String operator = getInstractionFromConsule();

                switch (operator) {
                    case "+":
                        calculator.setOperator('+');
                        break;
                    case "-":
                        calculator.setOperator('-');
                        break;
                    case "*":
                        calculator.setOperator('*');
                        break;
                    case "/":
                        calculator.setOperator('/');
                        break;
                    case "=":
                        General(2);
                        return;
                    default:
                        System.out.println("Unknown operator!");
                        General(flag);
                        break;
                }
                General(0);
                break;

        }
    }

    public void fetchResult() {
        instance.msg = "=> To save this result input: s\n" +
                "=> To start over input: c \n" +
                "\n" +
                "Last state: " + instance.formula + "\n" +
                "Result: " + calculator.getResult();
        System.out.println(instance.msg);
        String finalInstruction = getInstractionFromConsule();
        switch (finalInstruction) {
            case "s":
                break;
            case "c":
                calculator.clear();
                break;
            default:
                System.out.println("Unknown option!");
                General(0);
                break;
        }
    }

    public void areaOfCircle() {
        instance.msg = "---TheAreaOfCircle--------------------------------------------\n" +
                "=> Formula: PI * R * R \n" +
                "Please input R:";
        System.out.println(instance.msg);
        String instruction = getInstractionFromConsule();
        try {
            calculator.setFirstNumber(Double.parseDouble(instruction));
            calculator.setOperator('a');
            calculator.calculate();
            fetchResult();
        } catch (Exception e) {
            System.out.println("Wrong numbers!");
            areaOfCircle();
        }
    }

    public void circumferenceOfArea() {
        instance.msg = "---The Circumference Of Circle--------------------------------------------\n" +
                "=> Formula: PI * R * 2 \n" +
                "Please input R:";
        System.out.println(instance.msg);
        String instruction = getInstractionFromConsule();
        try {
            calculator.setFirstNumber(Double.parseDouble(instruction));
            calculator.setOperator('c');
            calculator.calculate();
            fetchResult();
        } catch (Exception e) {
            System.out.println("Wrong numbers!");
            areaOfCircle();
        }
    }

    public String getInstractionFromConsule() {
        String result = cin.nextLine();
        return result;
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }
}
