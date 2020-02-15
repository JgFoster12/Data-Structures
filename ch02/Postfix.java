package ch02;

import java.util.Stack;

public class Postfix {
    private Stack<Integer> postfixStack = new Stack();
    private String expression;

    public Postfix(String expression) {
        this.expression = expression;
    }

    public Stack<Integer> getPostfixStack() {
        return postfixStack;
    }

    public void setPostfixStack(Stack<Integer> postfixStack) {
        this.postfixStack = postfixStack;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public int postFixOperations(String expression){
        int result = 0;


        for(int i = 0; i < expression.length(); i++){
            char c = expression.charAt(i);


            if(Character.isDigit(c)){
                postfixStack.push(c - '0');
            }
            else if(!Character.isWhitespace(c) && !postfixStack.isEmpty()){
                int value1 = postfixStack.pop();
                int value2 = postfixStack.pop();

                switch (c){
                    case '+':{
                        postfixStack.push(value2 + value1);
                        break;
                    }
                    case '*':{
                        postfixStack.push(value2 * value1);
                        break;
                    }
                    case '-':{
                        postfixStack.push(value2 - value1);
                        break;
                    }
                    case '/': {
                        postfixStack.push(value2 / value1);
                        break;
                    }
                }
            }


        }
        return postfixStack.pop();
    }
}
