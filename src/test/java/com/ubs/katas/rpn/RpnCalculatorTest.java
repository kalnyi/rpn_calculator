
package com.ubs.katas.rpn;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;


/**
 *
 * @author alex
 */
public class RpnCalculatorTest {

    RpnCalculator calculator = new RpnCalculatorImpl();
    
    @Test
    public void calculatorSums() {
        assertThat(calculator.calculate("2 4 +")).isEqualTo(Double.valueOf("6"));
    }
    
    @Test
    public void calculatorSubstracts() {
        assertThat(calculator.calculate("2 4 -")).isEqualTo(Double.valueOf("-2"));
    }
    
    @Test
    public void calculatorMultiplies() {
        assertThat(calculator.calculate("2 4 *")).isEqualTo(Double.valueOf("8"));
    }
    
    @Test
    public void calculatorDivides() {
        assertThat(calculator.calculate("4 2 /")).isEqualTo(Double.valueOf("2"));
    }
    
    @Test
    public void calculatorDoesComplex() {
        assertThat(calculator.calculate("5 3 4 - +")).isEqualTo(Double.valueOf("4"));
    }
    
    
}