package 정올;
import java.io.*;
import java.util.*;

public class j1840 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 여기부터 풀이 작성

        int count = 0;
        int prev = 0;
        while(true){

            int tmp = count(map);
            if(tmp==0)break;
            prev = tmp;
            bfs(0,0);
//            for(int i = 0; i<n; i++){
//                for(int j =0; j<m; j++){
//                    System.out.print(map[i][j]);
//                }
//                System.out.println("");
//            }
            for(int i = 0; i<n; i++){
                for(int j = 0; j<m; j++){
                    if(map[i][j]==2){
                        map[i][j]=0;
                    }
                }
            }

            //System.out.println(tmp);
            count++;


        }
        System.out.println(count);
        System.out.println(prev);
    }
    public static void bfs(int i, int j){
        int n = map.length;
        int m = map[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        boolean[][] visited = new boolean[n][m];
        visited[i][j] = true;
        while(!queue.isEmpty()){
            int[]  tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            for(int k = 0; k<4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(isRange(nx,ny,n,m)){
                    if(map[nx][ny]==0 && !visited[nx][ny]){
                        queue.add(new int[]{nx,ny});
                        visited[nx][ny] = true;
                    }
                    else if(map[nx][ny]==1)map[nx][ny]=2;
                }
            }
        }



    }
    public static boolean isRange(int nx, int ny,int n, int m){
        if(nx>=0 && nx<n && ny>=0 && ny<m)return true;
        return false;
    }
    public static int count(int[][] map){
        int cnt = 0;
        int n = map.length;
        int m = map[0].length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(map[i][j]==1)cnt++;
            }
        }
        return cnt;
    }
}