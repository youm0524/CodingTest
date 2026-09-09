import java.util.*;
class Solution {
    static int[] queen;
    static int n;
    static int answer;
    public int solution(int n) {
        this.n = n;
        answer = 0;
        queen = new int[n];
        dfs(0);
        return answer;
    }
    public void dfs(int row){
        for(int col = 0; col<n; col++){
            boolean possible = true;
            for(int i = 0; i<row; i++){
                if(queen[i] == col){
                    possible = false;
                    break;
                }
                
                if(Math.abs(row-i) == Math.abs(col-queen[i])){
                    possible = false;
                    break;
                }
            }
            if(possible){
                queen[row] = col;
                dfs(row + 1);
            }
            
        }
        if(row == n){
            answer++;
            return;
        }
        
    }
}