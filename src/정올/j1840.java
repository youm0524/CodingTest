package 정올;
import java.io.*;
import java.util.*;

public class j1840 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] map;
    static int n;
    static int m;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 여기부터 풀이 작성

        int cnt = 0;
        int prev = 0;
        while(true){
            int tmp = count(map);
            if(tmp==0)break;
            prev = tmp;
            visited = new boolean[n][m];
            //(0,0)에서 돌면서 1을 만나면 인접한 애들
            dfs(0,0);

            for(int i = 0; i<n; i++){
                for(int j = 0; j<m; j++){
                    if(map[i][j]==2)map[i][j] = 0;
                }
            }
            cnt++;

        }

        System.out.println(cnt);
        System.out.println(prev);
    }

    public static void dfs(int i, int j){
        visited[i][j] = true;
        for(int k = 0; k<4; k++){
            int nx = i + dx[k];
            int ny = j + dy[k];
            if(isRange(nx,ny)&&!visited[nx][ny]){
                if(map[nx][ny]==0){
                    dfs(nx,ny);
                }else if(map[nx][ny]==1){
                    map[nx][ny] = 2;
                }
            }
        }

    }

    public static boolean isRange(int nx, int ny){
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