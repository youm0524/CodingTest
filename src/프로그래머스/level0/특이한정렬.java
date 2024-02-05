package 프로그래머스.level0;
import java.util.Arrays;
public class 특이한정렬 {


    class Solution {
        public int[] solution(int[] numlist, int n) {
            int[] answer = new int[numlist.length];
            Arrays.sort(numlist);
            int min = Integer.MAX_VALUE;
            int idx = -1;
            int val = -1;
            int tmp = 0;

            for (int i = numlist.length - 1; i >= 0;  i--) {
                for(int j = numlist.length - 1; j >= 0; j--) {
                    if (min > Math.abs(numlist[j] - n)) {
                        min = Math.abs(numlist[j] - n);
                        idx = j;
                        val = numlist[j];
                    }
                }
                min = Integer.MAX_VALUE;
                numlist[idx] = val + 100000;
                answer[tmp] = val;
                tmp++;
            }

            return answer;
        }
    }
}
