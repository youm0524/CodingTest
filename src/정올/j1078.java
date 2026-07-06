import java.io.*;
import java.util.*;

public class j1078 {
    static int N, M;
    static int cost;
    static int[][] map;
    static int[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로

        map = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
                visited[i][j] = map[i][j];
            }
        }

        st = new StringTokenizer(br.readLine());

        int col = Integer.parseInt(st.nextToken()) - 1;
        int row = Integer.parseInt(st.nextToken()) - 1;

        bfs(row, col);

        int cnt = countRemain();

        System.out.println(cost);
        System.out.println(cnt);
    }

    static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{startX, startY, 3});
        visited[startX][startY] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int x = cur[0];
            int y = cur[1];
            cost = cur[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isInRange(nx, ny) && map[nx][ny] != 0 && visited[nx][ny] != 0) {
                    visited[nx][ny] = 0;
                    queue.add(new int[]{nx, ny, cost + 1});
                }
            }
        }
    }

    static boolean isInRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    static int countRemain() {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 1) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}