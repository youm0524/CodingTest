import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i<players.length; i++){
           while(!queue.isEmpty() && queue.peek() <= i)queue.poll();
            int need = players[i]/m;
            if(queue.size()<need){
                int add = need - queue.size();
                for(int j = 0;j<add; j++){
                    queue.add(i+k);
                    answer++;
                }
                
            }
        }
        return answer;
    }
}