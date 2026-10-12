import java.util.*;
class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = Integer.MAX_VALUE;
        int[][] dp = new int[info.length+1][m+1];
        for(int i = 0; i<=info.length; i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        
        dp[0][0] = 0;
        for(int cnt = 0; cnt<info.length; cnt++){
            int a = info[cnt][0];
            int b = info[cnt][1];
            for(int cm = 0; cm<m; cm++){
                if(dp[cnt][cm]==Integer.MAX_VALUE)continue;
                //a넣는 경우
                if(dp[cnt][cm]+a<n){
                    dp[cnt+1][cm] = Math.min(dp[cnt+1][cm],dp[cnt][cm]+a);
                }
                if(cm+b<m){
                    dp[cnt+1][cm+b] = Math.min(dp[cnt+1][cm+b], dp[cnt][cm]);
                }
            }
            
        }
        for(int cm = 0; cm < m; cm++){
            answer = Math.min(answer, dp[info.length][cm]);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
}