import java.util.Arrays;

public class ReversePolishCalc {

    private String[] tokens;
    private String[] stack;
    private int top = -1;

    public double calculate(String input) {

        tokens = input.split(",");
        stack = new String[tokens.length];

        for (int i = 0; i < tokens.length; ++i) {
            String token = tokens[i];
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                double firstOp = pop();
                double secondOp = pop();
                if (token.equals("+")) {
                    push(firstOp + secondOp);
                } else if (token.equals("-")) {
                    push(firstOp - secondOp);
                } else if (token.equals("*")) {
                    push(firstOp * secondOp);
                } else if (token.equals("/")) {
                    push(firstOp / secondOp);
                }
            } else {
                push(token);
            }
        }
        return pop();
    }

    private void push(String number) {
        top++;
        stack[top] = number;
    }

    private void push(double d) {
        String pushString = String.valueOf(d);
        push(pushString);
    }

    private double pop() {
        double popString = Double.parseDouble(stack[top]);
        stack[top] = null;
        if (top != 0) {
            top--;
        }
        return popString;
    }
}

