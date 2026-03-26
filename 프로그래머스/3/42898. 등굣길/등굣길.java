class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int mod = 1000000007;
        boolean[][] puddle = new boolean[n+1][m+1];
        for(int i = 0; i<puddles.length; i++){
            int a = puddles[i][0];
            int b = puddles[i][1];
            puddle[b][a] = true;
        }
        
        int[][] dp = new int[n+1][m+1];
        dp[1][1] = 1;
        // for(int i = 1; i<=n; i++){
        //     dp[i][1] = 1;
        // }
        // for(int i = 1;i<=m; i++){
        //     dp[1][i] =1; 
        // }
        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<m+1; j++){
                if(i == 1 && j == 1) continue;
                if(!puddle[i][j]){
                    //System.out.println(dp[i-1][j]);
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1])% mod;
                    //System.out.println("i,j"+dp[i][j]);
                }
            }
        }
        //System.out.println();
        return dp[n][m];
    }
}