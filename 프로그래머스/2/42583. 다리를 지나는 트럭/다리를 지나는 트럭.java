import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int index = 0;
        int sum = 0;
        Queue<Integer> queue = new LinkedList<>();
        //0으로 다리 길이 만큼 치움
        for(int i = 0; i<bridge_length; i++){queue.add(0);}
        while(index<truck_weights.length){
            answer ++;
            int left = queue.poll();
            sum-=left;
            
            if((sum+truck_weights[index])<=weight){
                queue.add(truck_weights[index]);
                
                sum+=truck_weights[index];
                index++;
            }else{
                queue.add(0);
            }
        }
        answer+=bridge_length;
        return answer;
    }
}