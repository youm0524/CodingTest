import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville){
            pq.add(i);
        }
        //섞지 않아도 되는경우 
        if(pq.peek()>=K){
            return 0;
        }
        int cnt = 0;
        while(!pq.isEmpty()){
            int a = pq.poll();
            if(a>=K){
                return cnt;
            }
            if(pq.size()<1){
                return -1;
            }
            int b = pq.poll();
            int c = a + b*2;
            cnt++;
            pq.add(c);
        }

//         for(int i = 0; i<pq.size(); i++){
//             int n  = pq.poll();
//             System.out.println(n);
//             if(n>=K){
//                 return cnt;
//             }
//             int b = pq.poll();
//             int c = n + b*b;
//             //System.out.println(c);
//             cnt++;
//             //System.out.println(cnt);

//             pq.add(c);
//         }
        
        return -1;
    }
}