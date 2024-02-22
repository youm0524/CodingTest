package 프로그래머스.level0;

public class 저주의숫자3 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            int tmp = 0;
            for(int i = 1; i<=n ; i++){
                tmp++;
                while(tmp%10==3 || tmp%100/10==3 || tmp%3==0){
                    tmp++;
                }
            }
            return tmp;
        }
    }
}
