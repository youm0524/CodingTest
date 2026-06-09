class Solution {
    public int solution(int n, int[] money) {
        int[] dp = new int[n+1];
        int answer = 0;
        dp[0] = 1;
        for(int coin : money){
            for(int mon=coin; mon<=n; mon++){
                dp[mon] += dp[mon-coin];
                //System.out.println(dp[mon]);
            }
        }
        // for(int i = 1; i<=n; i++){
        //     System.out.println(dp[i]);
        // }
        return dp[n];
    }
}