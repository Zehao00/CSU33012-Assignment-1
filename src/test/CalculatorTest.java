import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calc = new Calculator();

    @org.junit.jupiter.api.Test
    void testAddition() {
        int add = Calculator.addition(3, 5);
        assertEquals(8, add);
    }

    @org.junit.jupiter.api.Test
    void testSubtraction() {
        int sub = Calculator.subtraction(4, 7);
        assertEquals(-3, sub);
    }

    @org.junit.jupiter.api.Test
    void testMultiplication() {
        int mul = Calculator.multiplication(5, 10);
        assertEquals(50, mul);
    }

    @org.junit.jupiter.api.Test
    void testCalculator(){
        assertEquals("2", calc.Calculator("1+1"));
        assertEquals("16", calc.Calculator("2*8"));
        assertEquals("-11", calc.Calculator("3-2*7"));
    }
}
