import java.util.*;
class Solution {
    static int[] queen;
    static int n;
    static int answer;
    static boolean[] visited;
    public int solution(int n) {
        this.n = n;
        answer = 0;
        visited = new boolean[n];
        queen = new int[n];
        dfs(0);
        return answer;
    }
    public void dfs(int row){
        if(row == n){
            answer++;
            return;
        }
        
        for(int col = 0; col<n; col++){
            if(visited[col]) continue;
            
            boolean possible = true;
    
            for(int i = 0; i<row; i++){
                if(Math.abs(row-i) == Math.abs(col-queen[i])){
                    possible = false;
                    break;
                }
            }
            if(!possible) continue;
            queen[row] = col;
            visited[col] = true;
            dfs(row + 1);
            visited[col] = false;
            
        }
    }
}