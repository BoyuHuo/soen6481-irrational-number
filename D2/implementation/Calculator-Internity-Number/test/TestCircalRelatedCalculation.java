import domain.Calculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestCircalRelatedCalculation {
    Calculator calculator;
    @Before
    public void setUp(){
        calculator = new Calculator();
    }

    @Test
    public void testAreaCircle(){
        calculator.setFirstNumber(5);
        calculator.setOperator('a');
        calculator.calculate();
        assertEquals(78.539815,calculator.getResult());
    }
    @Test
    public void testCircumferenceCircle(){
        calculator.setFirstNumber(5);
        calculator.setOperator('s');
        calculator.calculate();
        assertEquals(31.415926,calculator.getResult());
    }

    @After
    public void tearDown(){
        calculator.clear();
    }
}
