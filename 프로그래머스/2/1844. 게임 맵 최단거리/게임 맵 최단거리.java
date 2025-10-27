import java.util.*;
class Solution {
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {1,-1,0,0};
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        boolean visited[][] = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            int cnt = tmp[2];
            
            if(x==n-1 && y ==m-1)return cnt;
            
            //이동하기
            for(int i = 0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx<n && nx>=0 && ny<m && ny>=0 && maps[nx][ny] ==1
                  && !visited[nx][ny]) {
                    visited[nx][ny] = true;

                    queue.add(new int[]{nx,ny,cnt+1});
                }
            }
        }
        return -1;
    }
} 