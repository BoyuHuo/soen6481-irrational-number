package domain;

import memento.PreviousCalculation;

import java.util.Scanner;

public class MessageCenter {

    public String msg;
    public String formula = "";
    private Calculator calculator;
    private static MessageCenter instance;
    private Scanner cin = new Scanner(System.in);
    private PreviousCalculation memento;

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

        instance.msg = "---Main Screen------------------------------------------------------\n" +
                "Welcome, Please choose a function:\n" +
                "   => 1. General Calculation\n" +
                "   => 2. Calculate the area of a circle\n" +
                "   => 3. Calculate the circumference of a circle\n" +
                "   => 4. Modify the precise degree of PI \n" +
                "   => 0: Exit";
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
                configPI();
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
                instance.msg = "---General Calculation--------------------------------------------\n" +
                        "Tips: \n" +
                        "   =>Number : (4.9E-324(MIN_DOUBLE_VALUE),1.79E308(MAX_DOUBLE_VALUE)) \n" +
                        "   =>input \" p \":To use PI  \n" +
                        "   =>input \" c \" To clear this calculation\n" +
                        "Your Currently Calculation: " + instance.formula + "\n" +
                        "Please input a Number:";
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
                        calculator.clear();
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
                            System.out.println("Wrong number! <Press Enter to Continue>");
                            cin.nextLine();
                            General(flag);
                        }
                        break;
                }
                General(1);
                break;
            case 1:
                instance.msg = "Tips: \n" +
                        "   => Operators: + - * / = \n" +
                        "   => input \" = \" :will get the result and end this calculation;  \n" +
                        "Your Currently Calculation: " + instance.formula + "\n" +
                        "Please input an Operator:";
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
                        fetchResult();
                        return;
                    default:
                        System.out.println("Unknown operator! <Press Enter to Continue>");
                        cin.nextLine();
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
                "=> Last state: " + instance.formula + "\n" +
                "Result: " + calculator.getResult();
        System.out.println(instance.msg);
        String finalInstruction = getInstractionFromConsule();
        switch (finalInstruction) {
            case "s":
                calculator.backupState(memento);
                System.out.println("Save successful! <Press Enter to Continue>");
                cin.nextLine();
                instance.initScreen();
                break;
            case "c":
                calculator.clear();
                instance.initScreen();
                break;
            default:
                System.out.println("Unknown option! <Press Enter to Continue>");
                cin.nextLine();
                fetchResult();
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
            System.out.println("Wrong numbers! <Press Enter to Continue>");
            cin.nextLine();
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
            calculator.setOperator('s');
            calculator.calculate();
            fetchResult();
        } catch (Exception e) {
            System.out.println("Wrong numbers! <Press Enter to Continue>");
            cin.nextLine();
            areaOfCircle();
        }
    }

    public String getInstractionFromConsule() {
        String result = cin.nextLine();
        return result;
    }

    public void configPI() {
        instance.msg = "---Configuration for Precise Degree of PI--------------------------\n" +
                "Current algorithm: Algrithem " + (PI.algrithem ) + " (1:CutCircle  2:InfiniteSeries) \n" +
                "Current precision-degree: " + PI.degree + "\n" +
                "Current PI:" + PI.getValue() + "\n" +
                "=> 1.Change the Algorithm \n" +
                "=> 2.Change the precision-degree \n" +
                "=> 0.Back \n" +
                "Your Choice:";
        System.out.println(instance);
        String instruction = getInstractionFromConsule();
        switch (instruction) {
            case "0":
                calculator.clear();
                break;
            case "1":
                instance.msg = "=> 1. Algorithm 1: CutCircle (Recommend) \n" +
                        "=> 2. Algorithm 2: InfiniteSeries \n" +
                        "=> 0. Back \n" +
                        "Your Choice";
                System.out.println(instance.msg);
                String algorithm = getInstractionFromConsule();
                switch (algorithm){
                    case "0": configPI(); break;
                    case "1": PI.algrithem = 1;
                        System.out.println("Now PI is calculated by algorithm 1 <Press Enter to Continue>");
                        cin.nextLine();
                        configPI();
                        break;
                    case "2": PI.algrithem = 2;
                        System.out.println("Now PI is calculated by algorithm 2 <Press Enter to Continue>");
                        cin.nextLine();
                        configPI();
                    break;
                }
                break;
            case "2":
                instance.msg = "=> 1. High (Slow) \n" +
                        "=> 2. Medium (Recommend) \n" +
                        "=> 3. Low (Fast)\n" +
                        "=> 0. Back\n" +
                        "Your Choice:";
                System.out.println(instance.msg);
                String degree = getInstractionFromConsule();
                switch (degree){
                    case "0": configPI(); break;
                    case "1": PI.setDegree("HIGH");
                        System.out.println("Now PI is calculated in High precision degree <Press Enter to Continue>");
                        cin.nextLine();
                        configPI();
                        break;
                    case "2": PI.setDegree("MEDIUM");
                        System.out.println("Now PI is calculated in Medium precision degree <Press Enter to Continue>");
                        cin.nextLine();
                        configPI();
                        break;
                    case "3": PI.setDegree("LOW");
                        System.out.println("Now PI is calculated in Low precision degree <Press Enter to Continue>");
                        cin.nextLine();
                        configPI();
                }
                break;
            default:
                System.out.println("Wrong option! <Press Enter to Continue>");
                cin.nextLine();
                configPI();

        }


    }


    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

}
