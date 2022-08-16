package JUnit5;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;

@Test
    public void CalculatorNotNullTest(){
    assertNull(calculator);
}
}