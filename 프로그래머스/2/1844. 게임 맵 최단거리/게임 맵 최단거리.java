import java.util.*;
class Solution {
    private final static int[] dx = {0,0,-1,1};
    private final static int[] dy = {1,-1,0,0};
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        //시작 점 넣기
        queue.add(new int[]{0,0,1});
        //시작 점 방문 표시하기
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            //값 꺼내기
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            int cnt = temp[2];
            
            if(x==n-1 && y == m-1)return cnt;
            
            //이동하기
            for(int i = 0; i<4; i++){
                //좌표 변경
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx>=0 && ny>= 0 && nx<n && ny<m && 
                   maps[nx][ny]==1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, cnt+1});
                }
            }
        }
    
        return -1;
    }
}