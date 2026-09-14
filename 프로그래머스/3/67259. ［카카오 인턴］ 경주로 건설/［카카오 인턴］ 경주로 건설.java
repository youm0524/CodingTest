import java.util.*;
class Solution {
    static int n;
    static int[][] board;
    public int solution(int[][] board) {
        this.board = board;
        n = board.length;
        int[][][] dist = new int[n][n][4];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        queue.add(new int[]{0,0,-1,0});
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            int dir = tmp[2];
            int cost = tmp[3];
            
            //System.out.println(cost);
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                int newCost = 0;
                //초기거나 방향 같을 때
                if(dir == -1 || dir == i){
                    newCost = cost + 100;
                }//방향 다를때
                else{
                    newCost = cost + 600;
                }
                if(isRange(nx,ny)){
                    if(newCost < dist[nx][ny][i]){
                        dist[nx][ny][i] = newCost;
                        queue.add(new int[]{nx, ny, i, newCost});
                    }
                }
            }
        }
        int answer = Integer.MAX_VALUE;

        for(int i = 0; i < 4; i++){
            answer = Math.min(answer, dist[n-1][n-1][i]);
        }
        return answer;
    }
    public boolean isRange(int nx, int ny){
        if(nx>=0 && nx<n && ny>=0 && ny<n){
            if(board[nx][ny]!=1)return true;
        }
        return false;
    }
}