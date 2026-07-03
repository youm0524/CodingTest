import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int start = 0; start<s.length(); start++){
            Stack<Character> stack = new Stack<>();
            boolean valid = true;
            for(int i = 0; i<s.length(); i++){
                int idx = (start+i)%s.length();
                if(s.charAt(idx)=='(' || s.charAt(idx)=='[' || s.charAt(idx)=='{'){
                    stack.push(s.charAt(idx));
                }
                else{
                    if(stack.isEmpty()){
                        valid = false;
                        break;
                    }
                    char open = stack.pop();
                    char close = s.charAt(idx);
                    if (open == '(' && close != ')') {
                        valid = false;
                        break;
                    }
                    if (open == '{' && close != '}') {
                        valid = false;
                        break;
                    }
                    if (open == '[' && close != ']') {
                        valid = false;
                        break;
                    }
                }
            }
            if(valid && stack.isEmpty())answer++;
            
        }
        return answer;
    }
}