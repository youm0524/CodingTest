import java.util.*;
class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        int n = 1;
        int answer= 0;
        while(n<=order.length){
            if(n==order[idx]){
                answer++;
                idx++;
                n++;
            }else{
                stack.push(n);
                n++;
            }
            
            while(!stack.isEmpty() && idx<order.length && stack.peek()==order[idx]){
                stack.pop();
                answer++;
                idx++;
            }
            
        }
        return answer;
    }
}