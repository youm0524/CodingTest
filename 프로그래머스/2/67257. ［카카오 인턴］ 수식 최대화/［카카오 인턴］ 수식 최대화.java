import java.util.*;
class Solution {
    public long solution(String expression) {
        long answer = 0;
        char[][] priorities = {
            {'+', '-', '*'},
            {'+', '*', '-'},
            {'-', '+', '*'},
            {'-', '*', '+'},
            {'*', '+', '-'},
            {'*', '-', '+'}
        };
        for (char[] priority : priorities) {
            answer = Math.max(answer, Math.abs(calculate(expression, priority)));
        }
        
        return answer;
        
    }
    public long calculate(String expression, char[] priorities){
        Stack<Long> nums = new Stack<>();
        Stack<Character> op = new Stack<>();
        StringBuilder number = new StringBuilder();
        for(int i = 0; i<expression.length(); i++){
            char c = expression.charAt(i);
            if(Character.isDigit(c)){
                number.append(c);
            }else{
                nums.push(Long.parseLong(number.toString()));
                number.setLength(0);
                while(!op.isEmpty() && getPriority(op.peek(), priorities) >=
                     getPriority(c, priorities)){
                     calc(nums, op);
                }
                op.push(c);
            }
            
        }
        nums.push(Long.parseLong(number.toString()));
        while (!op.isEmpty()) {
            calc(nums, op);
        }
        return nums.pop();
    }
    public int getPriority(char op, char[] priority) {
        for (int i = 0; i < priority.length; i++) {
            if (priority[i] == op) {
                return 3 - i;
            }
        }
        return 0;
    }
    public void calc(Stack<Long> nums, Stack<Character> ops) {
        long b = nums.pop();
        long a = nums.pop();
        char op = ops.pop();

        long result = 0;

        if (op == '+') result = a + b;
        else if (op == '-') result = a - b;
        else if (op == '*') result = a * b;

        nums.push(result);
    }
}