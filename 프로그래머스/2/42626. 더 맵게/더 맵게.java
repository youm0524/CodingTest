import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int sco:scoville){
            pq.add(sco);
        }
        while(true){
            if(pq.peek()>=K)break;
            if(pq.size()==2){
               int a = pq.poll();
                int b = pq.poll();
                if(a + b*2 <K){
                    answer = -1;
                    break;
                }else if(a<K){
                    answer++;
                    break;
                }
            }
            
            int n = pq.poll() + pq.poll() *2;
            pq.add(n);
            answer++;
        }
        return answer;
    }
}