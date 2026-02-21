import java.util.*;
class Solution {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1});
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int a = tmp[0];
            int b = tmp[1];
            int c = tmp[2];
            if(a==n -1 && b ==m-1) return c;
            for(int i = 0; i<4; i++){
                int nx = a+dx[i];
                int ny = b+dy[i];
                if(nx<=n-1 && ny <=m-1 && nx>=0 && ny>=0 && !visited[nx][ny] 
                  && maps[nx][ny] == 1){
                    queue.add(new int[]{nx,ny,c+1});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return answer;
    }
}