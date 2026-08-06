import java.util.*;
class Solution {
    static char[][] map;
    static int n;
    static int m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        n = storage.length;
        m = storage[0].length();
        // 바깥 공간까지 포함하기 위해 테두리 추가
        map = new char[n + 2][m + 2];

        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(map[i], '.');
        }
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                map[i+1][j+1] = storage[i].charAt(j);
            }
        }
        
        for (String request : requests) {
            char target = request.charAt(0);
            if (request.length() == 2) {
                crane(target);
            } else {
                forklift(target);
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] != '.') {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    public void crane(char target) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == target) {
                    map[i][j] = '.';
                }
            }
        }
    }
    public void forklift(char target){
        boolean[][] visited = new boolean[n + 2][m + 2];
        boolean[][] remove = new boolean[n + 2][m + 2];

        dfs(0, 0, target, visited, remove);

        // 탐색이 끝난 뒤 한꺼번에 제거
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (remove[i][j]) {
                    map[i][j] = '.';
                }
            }
        }
    }
    
    public void dfs(int x, int y, char target, boolean[][] visited, boolean[][] removed){
        visited[x][y] = true;
        for(int i = 0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && ny>=0 &&nx<n+2 && ny<m+2){
                if(!visited[nx][ny] && map[nx][ny]=='.'){
                    dfs(nx,ny,target,visited,removed);
                }
                // 목표 컨테이너면 제거 대상으로만 표시
                else if (map[nx][ny] == target) {
                    removed[nx][ny] = true;
                }
            }
        }
    }
}