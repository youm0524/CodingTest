import java.io.*;
import java.util.*;

public class j1457 {

    static int M, N, K;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 세로
        N = Integer.parseInt(st.nextToken()); // 가로
        K = Integer.parseInt(st.nextToken()); // 직사각형 개수

        // map[x][y] 기준
        map = new int[N][M];
        visited = new boolean[N][M];

        // 직사각형 영역을 1로 표시
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    map[x][y] = 1;
                }
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (map[x][y] == 0 && !visited[x][y]) {
                    int area = dfs(x, y);
                    list.add(area);
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());

        for (int area : list) {
            System.out.print(area + " ");
        }
    }

    static int dfs(int x, int y) {
        visited[x][y] = true;

        int count = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위를 벗어나면 넘어감
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }

            // 직사각형,방문한 곳이면 넘어감
            if (map[nx][ny] == 1 || visited[nx][ny]) {
                continue;
            }

            count += dfs(nx, ny);
        }

        return count;
    }
}