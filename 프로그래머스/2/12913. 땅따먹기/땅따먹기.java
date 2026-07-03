class Solution {
    int solution(int[][] land) {
        int answer = 0;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        int[][] dp = new int[land.length][4];
        for(int i= 0; i<land.length; i++){
            for(int j = 0;j<4; j++){
                dp[i][j] = land[i][j];
            }
        }
        
        for(int i = 1; i<land.length; i++){
            int a = Math.max(Math.max(dp[i-1][1],dp[i-1][2]),dp[i-1][3]);
            
            dp[i][0] += a;
            //System.out.println("dp[i][0]"+dp[i][0]+"a"+a);
            dp[i][1] += Math.max(Math.max(dp[i-1][0],dp[i-1][2]),dp[i-1][3]);
            dp[i][2] += Math.max(Math.max(dp[i-1][1],dp[i-1][0]),dp[i-1][3]);
            dp[i][3] += Math.max(Math.max(dp[i-1][1],dp[i-1][2]),dp[i-1][0]);
        }
    
        for(int i = 0; i<4; i++){
            //ystem.out.println(dp[land.length-1][i]);
            answer = Math.max(dp[land.length-1][i],answer);
        }
        

        return answer;
    }
}