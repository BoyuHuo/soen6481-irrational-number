package memento;

import domain.Calculator;

public class PreviousCalculationImp implements PreviousCalculation {
    private Calculator state;


    @Override
    public double getFirstNumber() {
        return state.getFirstNumber();
    }

    @Override
    public double getSecondNumber() {
        return state.getSecondNumber();
    }
    @Override
    public char getOperator(){
        return state.getOperator();
    }
    @Override
    public double getResult(){
        return state.getResult();
    }
    @Override
    public boolean getIsFirst(){
        return state.isFirst;
    }
    @Override
    public boolean getIsSecond(){
        return state.isSecond;
    }
    @Override
    public Calculator getEntireState(){
        return state;
    }
    public void setState(Calculator state){
        this.state = state;
    }
    public boolean isEmpty(){
        return state==null;
    }
}
