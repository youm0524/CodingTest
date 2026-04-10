import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 1;
        int n = maps.length;
        int m = maps[0].length;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        queue.add(new int[]{0,0});
        visited[0][0] = true;
        int[][] dist = new int[n][m];
        dist[0][0] = 1;
        while(!queue.isEmpty()){
            int[] route = queue.poll();
            int a = route[0];
            int b = route[1];
            //System.out.println("x:"+a+"y"+b);
            if(a == n-1 && b == m-1){
                return dist[a][b];
            }
            for(int i = 0; i<4; i++){
                int nx = a+dx[i];
                int ny = b+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && maps[nx][ny]==1
                  && !visited[nx][ny]){
                    dist[nx][ny] = dist[a][b]+1;
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx,ny});
                }
            }
        }
        return -1;
    }
}