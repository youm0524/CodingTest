import java.util.*;
class Solution {
    public String solution(String p) {
        String answer = "";
        if(check(p))return p;
        else {
           return make(p); 
        }
        
    }
    public boolean check(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                stack.push('(');
            }
            else{
                if(stack.isEmpty())return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    
    public String[] divide(String s){
        int a = 0;
        int b = 0;
        String u = "";
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)=='(')a++;
            else b++;
            u += String.valueOf(s.charAt(i));
            if(a==b){
                break;
            }
        }
        String v = s.substring(a+b);
        String[] result = new String[2];
        result[0] = u;
        result[1] = v;
        return result;
    }
    public String make(String s){
        if(s.equals(""))return "";
        String[] result = divide(s);
        String u = result[0];
        String v = result[1];
        if(check(u)){
            return u + make(v);
        }
        else {
            String temp = "(" + make(v) + ")";
        
            // u의 첫 번째와 마지막 문자 제거
            u = u.substring(1, u.length()-1);

            // 괄호 뒤집기
            String flipped = "";
            for(int i = 0; i < u.length(); i++){
                if(u.charAt(i) == '(') flipped += ")";
                else flipped += "(";
            }
            return temp + flipped;
        }
    }
}