package 프로그래머스.level1;
import java.util.Arrays;

public class 예산 {

    class Solution {
        public int solution(int[] d, int budget) {
            Arrays.sort(d);
            int count = 0;
            int sum = 0;
            for(int i : d){
                sum +=i;
                if(sum <= budget){
                    count++;
                }
                else{
                    break;
                }
            }

            return count;
        }
    }
}
