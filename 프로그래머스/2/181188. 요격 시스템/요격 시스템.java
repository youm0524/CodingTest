import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets, (a,b)->a[1]-b[1]);
        int max = targets[0][1];
        for(int i = 1; i<targets.length; i++){
            if(max<=targets[i][0]){
                max = targets[i][1];
                answer++;
            }
            
        }
        return answer;
    }
}