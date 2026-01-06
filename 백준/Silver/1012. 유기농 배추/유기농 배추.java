import java.util.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스 개수

        for (int t = 0; t < T; t++) {
            int M = sc.nextInt(); // 가로
            int N = sc.nextInt(); // 세로
            int K = sc.nextInt(); // 배추 개수

            int[][] field = new int[N][M];
            boolean[][] visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                field[y][x] = 1;
            }

            Queue<int[]> queue = new LinkedList<>();
            int answer = 0;

            // 모든 칸 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (field[i][j] == 1 && !visited[i][j]) {
                        queue.add(new int[]{i, j});
                        visited[i][j] = true; // 💡 여기서 바로 방문 표시
                        answer++;

                        while (!queue.isEmpty()) {
                            int[] n = queue.poll();
                            int x = n[0];
                            int y = n[1];

                            for (int k = 0; k < 4; k++) {
                                int nx = x + dx[k];
                                int ny = y + dy[k];
                                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                                    if (field[nx][ny] == 1 && !visited[nx][ny]) {
                                        visited[nx][ny] = true;
                                        queue.add(new int[]{nx, ny});
                                    }
                                }
                            }
                        }
                    }
                }
            }

            System.out.println(answer);
        }

        sc.close();
    }
}
