import java.util.*;
class Solution {
    public int solution(int[][] info, int n, int m) {
        int[] dp = new int[m];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i = 0; i<info.length; i++){
            int[] next = new int[m];
            Arrays.fill(next, Integer.MAX_VALUE);
            for(int b = 0; b<m; b++){
                if(dp[b]==Integer.MAX_VALUE)continue;
                int nextA = dp[b] +info[i][0];
                if(nextA<n){
                    next[b] = Math.min(next[b], nextA);
                }
                // B가 훔치는 경우
                int nextB = b + info[i][1];

                if(nextB < m) {
                    next[nextB] = Math.min(next[nextB], dp[b]);
                }
            }
            dp = next;
        }
        int answer = Integer.MAX_VALUE;

        for(int a : dp) {
            answer = Math.min(answer, a);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}