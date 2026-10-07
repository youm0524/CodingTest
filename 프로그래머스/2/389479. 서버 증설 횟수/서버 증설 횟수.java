import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        //queue.add(0);
        for(int player : players){
            if(queue.size()==k){
                queue.poll();
            }
            //사용자 확인
            int server = player/m;
            int calc = cal(queue);
            int add = 0;
            if(cal(queue)<server){
                add = server-calc;
                answer+=server-calc;   
            }
            
            queue.add(add);
            //System.out.println(answer);
        }
        return answer;
    }
    
    public int cal(Queue<Integer> queue){
        int sum = 0;
        for(int num : queue){
            sum+=num;
        }
        //System.out.println(sum);
        return sum;
    }
}