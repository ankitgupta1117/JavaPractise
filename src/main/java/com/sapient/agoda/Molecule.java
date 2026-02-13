package com.sapient.agoda;

import java.util.Stack;

public class Molecule {

    public static int calculate(String formula){
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<formula.length(); i++){
            if(formula.charAt(i) == 'C'){
                stack.push(12);
            }else if(formula.charAt(i) == 'H'){
                stack.push(1);
            } else if (formula.charAt(i) == '(') {
                stack.push(-1);
            } else if (Character.isDigit(formula.charAt(i))) {
                int digit = formula.charAt(i) - '0';
                stack.push(stack.pop()*digit);
            } else if(formula.charAt(i) == ')'){
                int sum =0;
                while(stack.peek() != -1){
                    sum = sum + stack.pop();
                }
                stack.pop();
                stack.push(sum);
            }
        }

        int total = 0;
        while(!stack.isEmpty()){
            total = total + stack.pop();
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(calculate("CH4"));
        System.out.println(calculate("(CH4)2"));
        System.out.println(calculate("((CH4)2)"));
        System.out.println(calculate("(C(CH4)2)3"));
    }

}
