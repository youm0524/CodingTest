import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i:works){
            pq.add(i);
        }

        while(n!=0){
            //int len = works.length-1;
            //Arrays.sort(works);
            int num = pq.poll();
            //System.out.println("num:"+num);
            if(num==0)break;
            pq.add(num-1);
            n--;
        }
        while(!pq.isEmpty()){
            int num = pq.poll();
            answer+=num*num;
        }
        
        return answer;
    }
}