package memento;

import domain.Calculator;

public interface PreviousCalculation {
    double getFirstNumber();
    double getSecondNumber();
    char getOperator();
    double getResult();
    Calculator getEntireState();
    boolean getIsFirst();
    boolean getIsSecond();
    void setState(Calculator state);
    boolean isEmpty();
}
