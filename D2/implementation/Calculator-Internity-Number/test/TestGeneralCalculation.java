import domain.Calculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.*;

public class TestGeneralCalculation {
    Calculator calculator;
    @Before
    public void setUp(){
        calculator = new Calculator();
    }

    @Test
    public void testAddition(){
        calculator.setFirstNumber(5);
        calculator.setSecondNumber(2.5);
        calculator.setOperator('+');
        calculator.calculate();
        assertEquals(7.5,calculator.getResult());
    }

    @Test
    public void testSubtraction(){
        calculator.setFirstNumber(5);
        calculator.setSecondNumber(2.5);
        calculator.setOperator('-');
        calculator.calculate();
        assertEquals(2.5,calculator.getResult());
    }

    @Test
    public void testMultiplication(){
        calculator.setFirstNumber(5);
        calculator.setSecondNumber(2.5);
        calculator.setOperator('*');
        calculator.calculate();
        assertEquals(12.5,calculator.getResult());
    }

    @Test
    public void testDivision(){
        calculator.setFirstNumber(5);
        calculator.setSecondNumber(2.5);
        calculator.setOperator('/');
        calculator.calculate();
        assertEquals(2.0,calculator.getResult());
    }
    @After
    public void tearDown(){
        calculator.clear();
    }
}
