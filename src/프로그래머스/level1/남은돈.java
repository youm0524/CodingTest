package 프로그래머스.level1;

public class 남은돈 {
    class Solution {
        public long solution(int price, int money, int count) {
            long answer = -1;
            long total = 0;
            for(int i = 1;i<=count;i++){
                total += price * i;
            }
            answer = money-total;
            if(answer<0) return Math.abs(answer);
            else return 0;

        }
    }
}
