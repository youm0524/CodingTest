package 정올;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class j1695 {
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int cnt;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(map[i][j]==1 && !visited[i][j]){
                    int c = dfs(i,j);
                    list.add(c);
                }
            }
        }
        System.out.println(list.size());
        for(int i = 0; i<list.size(); i++){
            System.out.println(list.get(i));
        }



    }
    static int dfs(int x, int y) {
        visited[x][y] = true;

        // 현재 집 한 채
        int count = 1;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }

            if (map[nx][ny] == 1 && !visited[nx][ny]) {
                count += dfs(nx, ny);
            }
        }

        return count;
    }
}