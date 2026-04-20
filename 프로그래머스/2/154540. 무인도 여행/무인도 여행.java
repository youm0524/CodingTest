import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        
        List<Integer> list = new ArrayList<>();
        boolean[][] visited = new boolean[n][m];
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                if (!visited[i][j] && maps[i].charAt(j) != 'X') {
                    
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    
                    int sum = maps[i].charAt(j) - '0';
                    
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int x = cur[0];
                        int y = cur[1];
                        
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            
                            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                                if (!visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                                    visited[nx][ny] = true;
                                    queue.add(new int[]{nx, ny});
                                    sum += maps[nx].charAt(ny) - '0';
                                }
                            }
                        }
                    }
                    
                    list.add(sum);
                }
            }
        }
        
        if (list.isEmpty()) return new int[]{-1};
        
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}