package memento;

import domain.Calculator;

public class PreviousCalculationImp implements PreviousCalculation {
    private double firstNumber = 0;
    private double secondNumber = 0;
    private double result = 0;
    private char operator = '@';

    public boolean isFirst = true;
    public boolean isSecond = false;

    private boolean isEmpty = true;


    @Override
    public double getFirstNumber() {
        return firstNumber;
    }

    @Override
    public double getSecondNumber() {

        return secondNumber;
    }

    @Override
    public char getOperator() {
        return operator;
    }

    @Override
    public double getResult() {
        return result;
    }

    @Override
    public boolean getIsFirst() {
        return isFirst;
    }

    @Override
    public boolean getIsSecond() {
        return isSecond;
    }

    public void setState(Calculator state) {

        this.firstNumber = state.getFirstNumber();
        this.secondNumber =  state.getSecondNumber();
        this.result = state.getResult();
        this.operator = state.getOperator();
        this.isSecond = state.isSecond;
        this.isFirst = state.isFirst;
        isEmpty = false;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }
}
