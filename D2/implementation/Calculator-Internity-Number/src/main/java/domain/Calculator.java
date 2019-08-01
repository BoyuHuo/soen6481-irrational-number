package domain;

import memento.PreviousCalculation;

public class Calculator {
    private double firstNumber = 0;
    private double secondNumber = 0;
    private double result = 0;
    private char operator='@';

    public boolean isFirst = true;
    public boolean isSecond = false;


    public void start() {
        MessageCenter.getInstance().initScreen();
    }
    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
        MessageCenter.getInstance().formula = firstNumber+"";
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void clear() {
        firstNumber = 0;
        secondNumber = 0;
        result = 0;
        isFirst = true;
        isSecond = false;
        MessageCenter.getInstance().formula = "";
    }
    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
        MessageCenter.getInstance().formula=firstNumber+" "+operator;
    }

    public void calculate() {
        switch (operator) {
            case '+':
                result = Operations.add(firstNumber, secondNumber);
                break;
            case '-':
                result = Operations.subtract(firstNumber, secondNumber);
                break;
            case '*':
                result = Operations.multiple(firstNumber, secondNumber);
                break;
            case '/':
                result = Operations.division(firstNumber, secondNumber);
                break;
            case 'a':
                result = Operations.calCircleArea(firstNumber);
                break;
            case 's':
                result = Operations.calCircumference(firstNumber);
                break;
        }
        firstNumber = result;
        isSecond = false;
        operator='@';
        MessageCenter.getInstance().formula=firstNumber+"";
    }

    public void restorePreviousCalculation(PreviousCalculation memento) {

        this.firstNumber = ((PreviousCalculation)memento).getFirstNumber();
        this.secondNumber = ((PreviousCalculation)memento).getSecondNumber();
        this.operator = memento.getOperator();
        this.result = memento.getResult();
        this.isFirst = memento.getIsFirst();
        this.isSecond = memento.getIsSecond();

    }
    public void usePreviousResult(PreviousCalculation memento){
        if(isFirst){
            firstNumber = memento.getResult();
        }else if(isSecond = false){
            secondNumber = memento.getResult();
            isSecond = true;
        }
    }

    public void backupState(PreviousCalculation memonto){
        memonto.setState(this);
    }



}
