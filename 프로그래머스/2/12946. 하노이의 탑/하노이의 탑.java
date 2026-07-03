import java.util.*;
class Solution {
    List<int[]> list = new ArrayList<>();
    public int[][] solution(int n) {
        move(n, 1,3,2);
        int[][] answer = new int[list.size()][2];
        
        for(int i = 0; i<list.size(); i++){
            int[] li = list.get(i);
            answer[i][0] = li[0];
            answer[i][1] = li[1];
        }
        return answer;
    }
    public void move(int n, int from, int to, int via){
        if(n==1){
            list.add(new int[]{from,to});
            return;
        }
        move(n-1, from, via, to);
        list.add(new int[]{from,to});
        move(n-1, via, to, from);
    }
}