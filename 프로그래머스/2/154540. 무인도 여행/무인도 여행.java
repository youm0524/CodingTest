import java.util.*;
class Solution {
    public int[] solution(String[] maps) {
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int n = maps.length;
        int m = maps[0].length();
        int x = 0;
        int y = 0;
        Character[][] map = new Character[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                map[i][j] = maps[i].charAt(j);
            }
        }
        boolean[][] visited = new boolean[n][m];
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i <n; i++){
            for(int j = 0; j<m; j++){
                if(map[i][j]!='X' && !visited[i][j]){
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;
                    int sum = map[i][j] - '0';
                    while(!queue.isEmpty()){
                        int[] li = queue.poll();
                        int xx = li[0];
                        int yy = li[1];
                        for(int k = 0; k<4; k++){
                            int nx = xx +dx[k];
                            int ny = yy +dy[k];
                            if(nx>=0 && nx<n && ny>=0 && ny<m &&
                               !visited[nx][ny] && map[nx][ny]!='X'){
                                visited[nx][ny] = true;
                                sum+= map[nx][ny] - '0';
                                queue.add(new int[]{nx,ny});
                            }
                        }
                    }
                    list.add(sum);
                } 
            }
        }
        int[] answer = new int[list.size()];
        Collections.sort(list);
        if(list.isEmpty()) return new int[]{-1};
        
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }  
        return answer;
    }
}