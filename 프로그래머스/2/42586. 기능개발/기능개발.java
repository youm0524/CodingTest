import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i<progresses.length; i++){
            int rem = (int) Math.ceil((100.0- progresses[i])/speeds[i]);
            System.out.println(rem);
            queue.add(rem);
        }

        while(!queue.isEmpty()){
            int count = 1;
            //맨 앞 꺼내기
            int temp = queue.poll();
            //뒤에꺼랑 비교, 뒤에꺼가 더 크면 냅두고 작으면 같이 꺼내고 ++
            
            
            while (!queue.isEmpty() && temp >= queue.peek()) {
                count++;
                queue.poll();
            }

            result.add(count);
            //answer[index] = count;
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}