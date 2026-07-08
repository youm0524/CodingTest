package 정올;

import java.io.*;
import java.util.*;

public class j2613 {
    static boolean[][] visited;
    static int[][] map;
    static int N;
    static int M;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int cost = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //1인 좌표


        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(map[i][j]==1){
                    queue.add(new int[]{i,j});
                }
            }
        }
        bfs(queue);

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }

                answer = Math.max(answer, map[i][j]);
            }
        }

        System.out.println(answer - 1);
    }
    public static void bfs(Queue<int[]> queue){
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                //System.out.println(nx+" "+ny);
                if(isRange(nx,ny)){
                    //System.out.println("!!");
                    if(map[nx][ny]==0 && !visited[nx][ny]){
                        map[nx][ny] = map[x][y]+1;
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx,ny});
                        //System.out.println("!!");
                    }
                }
            }
        }

        //return cost+1;
    }
    public static boolean isRange(int nx, int ny){
        if(nx>=0 && nx<N && ny>=0 && ny<M)return true;
        else return false;
    }
}