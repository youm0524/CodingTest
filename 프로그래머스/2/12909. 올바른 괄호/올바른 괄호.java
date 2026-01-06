import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        char[] ss = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i  = 0; i<s.length(); i++){
            if(ss[i] == '(')
                stack.push(ss[i]);
            else
                if(!stack.isEmpty())
                    stack.pop();
                else{
                    answer = false;
                    break;
                }
            
        }
        
        if(!stack.isEmpty()) answer = false;

        return answer;
    }
}