package com.ubs.katas.rpn.operation;

import com.ubs.katas.rpn.Operation;

/**
 *
 * @author Alex Kalnij
 * @date Jan 30, 2015
 */
public class Multiply implements Operation{

    public Double calculate(Double firstOperator, Double secondOperator) {
        return firstOperator * secondOperator;
    }
    
}
