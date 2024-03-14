package 프로그래머스.level0;

public class 평행 {
    class Solution {
        public int solution(int[][] dots) {
            int answer = 0;
            if(grad(dots[0],dots[1])==grad(dots[2],dots[3])) return 1;
            else if (grad(dots[0],dots[2])==grad(dots[1],dots[3])) return 1;
            else if (grad(dots[0],dots[3])==grad(dots[1],dots[2])) return 1;

            return answer;
        }
        static  float grad (int[] a, int[] b){
            float denom, mole;
            denom = a[0] - b[0];
            mole = a[1] - b[1];

            return mole/denom;
        }
    }
}
