import java.util.*;
class Solution {
    public int solution(int[][] info, int n, int m) {

        int[][] dp = new int[info.length+1][m];
        for(int i = 0; i<=info.length; i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for(int i = 0; i<info.length; i++){
            int cn = info[i][0];
            int cm = info[i][1];
            for(int b = 0; b<m; b++){
                if (dp[i][b] == Integer.MAX_VALUE) continue;

                //A가 훔칠 경우
                if(dp[i][b]+cn<n){
                    dp[i+1][b] = Math.min(dp[i+1][b],dp[i][b]+cn);
                }
                //B가 훔칠 경후
                if(cm + b <m){
                    dp[i+1][cm+b] = Math.min(dp[i+1][cm+b],dp[i][b]);
                }
            }
            
            
        }
        int answer = Integer.MAX_VALUE;

        for (int b = 0; b < m; b++) {
            answer = Math.min(answer, dp[info.length][b]);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}