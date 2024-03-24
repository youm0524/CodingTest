package 프로그래머스.level0;

public class 세수의합 {
    class Solution {
        public int[] solution(int num, int total) {
            int[] answer = new int[num];
            for(int st = -1000; st < 1000; st++){
                int start = 0;
                for(int i = 0; i < num; i++){
                    start += st + i;
                }
                if(start == total){
                    for(int i = 0; i <num ; i++){
                        answer[i] = st + i;
                    }
                }
            }
            return answer;
        }
    }
}
