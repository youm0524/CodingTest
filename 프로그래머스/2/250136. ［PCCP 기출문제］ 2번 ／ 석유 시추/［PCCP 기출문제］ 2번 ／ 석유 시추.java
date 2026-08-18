import java.util.*;
class Solution {
    static int[][] map;
    static int n;
    static int m;
    static int num;
    static int cnt;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    public int solution(int[][] land) {
        int answer = 0;
        num = 1;
        n = land.length;
        m = land[0].length;
        map = new int[n][m];
        visited = new boolean[n][m];
        List<Integer> size = new ArrayList<>();
        size.add(0);
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(land[i][j]==1 && !visited[i][j]){
                    //cnt = 0;
                    
                    size.add(bfs(i,j,num,land));
                    num++;
                }
            }
        }
        // for(int i = 0; i<n; i++){
        //     for(int j = 0; j<m; j++){
        //         System.out.print(map[i][j]);
        //     }
        //     System.out.println("");
        // }
        for(int i = 0 ;i<m; i++){
            Set<Integer> set = new HashSet<>();
            for(int j = 0; j<n; j++){
                if(land[j][i] == 1){
                    set.add(map[j][i]);
                }
            }
            int sum = 0;

            for (int id : set) {
                sum += size.get(id);
            }

            answer = Math.max(answer, sum);
        }
        return answer;
    }
    public int bfs(int sx, int sy, int num, int[][] land) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        map[sx][sy] = num;

        int cnt = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];

            cnt++;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny] && land[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        map[nx][ny] = num;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return cnt;
    }
}