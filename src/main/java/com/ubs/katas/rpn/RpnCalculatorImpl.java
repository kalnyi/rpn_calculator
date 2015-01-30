package com.ubs.katas.rpn;

import com.ubs.katas.rpn.operation.Divide;
import com.ubs.katas.rpn.operation.Multiply;
import com.ubs.katas.rpn.operation.Substract;
import com.ubs.katas.rpn.operation.Sum;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author Alex Kalnij
 * @date Jan 30, 2015
 */
public class RpnCalculatorImpl implements RpnCalculator {

    Map<String, Operation> operationsMap = new HashMap<String, Operation>();
    
    public RpnCalculatorImpl() {
        operationsMap.put("+", new Sum());
        operationsMap.put("-", new Substract());
        operationsMap.put("*", new Multiply());
        operationsMap.put("/", new Divide());
    }

    public Double calculate(String expression) {
        Stack<Double> stack = new Stack<Double>();
        for (String token : expression.split("\\s")) {
            Double tokenNum = parseTokenNumber(token);
            if (tokenNum != null) {
                stack.push(Double.parseDouble(token + ""));
            } else {
                Operation operation = operationsMap.get(token);
                Double second = stack.pop();
                Double first = stack.pop();
                stack.push(operation.calculate(first, second));
            }
        }
        return stack.pop();
    }

    private Double parseTokenNumber(String token) {
        Double tokenNum = null;
        try {
            tokenNum = Double.parseDouble(token);
        } catch (NumberFormatException e) {
            //NOP
        }
        return tokenNum;
    }
}
