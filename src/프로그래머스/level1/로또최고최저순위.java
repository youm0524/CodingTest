package 프로그래머스.level1;

public class 로또최고최저순위 {
    class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int max = 0; int count = 0;
            int[] answer = new int[2];

            for(int i : lottos){
                for(int j : win_nums){
                    if(i == j) count++;
                }
                if(i == 0){
                    max++;
                }
            }
            if(count+max == 6) answer[0] = 1;
            else if(count+max == 5) answer[0] = 2;
            else if(count+max == 4) answer[0] = 3;
            else if(count+max == 3) answer[0] = 4;
            else if(count+max == 2) answer[0] = 5;
            else answer[0] = 6;

            if(count == 6) answer[1] = 1;
            else if(count == 5) answer[1] = 2;
            else if(count == 4) answer[1] = 3;
            else if(count == 3) answer[1] = 4;
            else if(count == 2) answer[1] = 5;
            else answer[1] = 6;

            return answer;
        }
    }
}
