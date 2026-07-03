import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,0});
        boolean[] visited = new boolean[y+1];
        visited[x] = true;
        
        while(!queue.isEmpty()){
            int[] a = queue.poll();
            int ne = a[0];
            int depth = a[1];
            if(ne==y){
                return depth;
            }
            int[] next = {ne+n,ne*2,ne*3};
            for(int ny : next){
                if(ny<=y && !visited[ny]){
                    visited[ny] = true;
                    queue.add(new int[]{ny, depth+1});
                }
            }
            
        }
        return -1;
    }
}