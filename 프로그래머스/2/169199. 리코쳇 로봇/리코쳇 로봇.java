import java.util.*;

class Solution {
    public int[] dx = {1, 0, -1, 0};
    public int[] dy = {0, -1, 0, 1};

    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();

        char[][] map = new char[n][m];
        int s_x = 0, s_y = 0;

        // 맵 초기화 + 시작점 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = board[i].charAt(j);
                if (map[i][j] == 'R') {
                    s_x = i;
                    s_y = j;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        queue.add(new int[]{s_x, s_y, 0});
        visited[s_x][s_y] = true;

        // BFS 시작
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];

            // 목표 도착
            if (map[x][y] == 'G') {
                return cnt;
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x;
                int ny = y;

                // 한 방향으로 끝까지 이동
                while (true) {
                    int tx = nx + dx[i];
                    int ty = ny + dy[i];

                    // 범위 밖이거나 장애물이면 멈춤
                    if (tx < 0 || tx >= n || ty < 0 || ty >= m || map[tx][ty] == 'D') {
                        break;
                    }

                    nx = tx;
                    ny = ty;
                }

                // 방문 안 했으면 큐에 추가
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, cnt + 1});
                }
            }
        }

        // 목표 도달 못하면
        return -1;
    }
}