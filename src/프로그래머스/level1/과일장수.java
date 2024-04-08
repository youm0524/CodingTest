package 프로그래머스.level1;
import java.util.Arrays;

public class 과일장수 {

    class Solution {
        public int solution(int k, int m, int[] score) {
            int answer = 0;
            Arrays.sort(score);

            for(int i = score.length; i>=m ; i-=m){
                answer += m * score[i-m];
            }
            return answer;
        }
    }
}
