import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        //시간을 다 분으로 바꿔주기
        for(String[] plan : plans){
            String[] time = plan[1].split(":");
            String hour = time[0];
            String min = time[1];
            int sum = Integer.valueOf(hour)*60 + Integer.valueOf(min);
            String sums = String.valueOf(sum);
            plan[1] = sums;
        }
        
        //시간 기준 오름차순
        Arrays.sort(plans,(a,b)->{
            return Integer.valueOf(a[1])-Integer.valueOf(b[1]);
        });
        
        // for(String[] plan : plans){
        //     System.out.println(plan[1]);
        // }
        Queue<String[]> planQueue = new LinkedList<>();
        Stack<String[]> remainStack = new Stack<>();
        List<String> answers = new ArrayList<>();
        for(String[] plan : plans){
            planQueue.add(plan);
        }

        
        while(!planQueue.isEmpty()){
            String[] cur = planQueue.poll();
            int start = Integer.parseInt(cur[1]);
            int play = Integer.parseInt(cur[2]);
            // 마지막 과제
            if (planQueue.isEmpty()) {
                answers.add(cur[0]);

                while (!remainStack.isEmpty()) {
                    answers.add(remainStack.pop()[0]);
                }

                break;
            }

            if(!planQueue.isEmpty()){
                int nextStart = Integer.parseInt(planQueue.peek()[1]);
                int available = nextStart - start;
                if(available<play){
                    remainStack.push(new String[]{cur[0],
                    String.valueOf(play-available)});
                
                }else {
                    answers.add(cur[0]);

                    int freeTime = available - play;

                    while (freeTime > 0 && !remainStack.isEmpty()) {
                        String[] remain = remainStack.pop();

                        String name = remain[0];
                        int remainTime = Integer.parseInt(remain[1]);

                        if (remainTime <= freeTime) {
                            // 멈춰둔 과제를 끝낼 수 있음
                            freeTime -= remainTime;
                            answers.add(name);
                        } else {
                            // 다 못 끝냄
                            remainTime -= freeTime;
                            freeTime = 0;

                            remainStack.push(new String[]{
                                name,
                                String.valueOf(remainTime)
                            });
                        }
                    }
                }
            }
        }
        // while(!remainQueue.isEmpty()){
        //     String[] tmp = remainQueue.poll();
        //     System.out.printf("tmp[0] %s tmp[1] %s tmp[2] %s%n",
        // tmp[0], tmp[1], tmp[2]);
        // }
        String[] answer = {};
        return answers.toArray(new String[0]);
    }
}