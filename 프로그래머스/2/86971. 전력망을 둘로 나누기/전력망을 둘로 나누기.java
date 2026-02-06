import java.util.*;
class Solution {
    static List<Integer>[] graph;
    static int answer;
    public int solution(int n, int[][] wires) {
        answer = Integer.MAX_VALUE;
        graph = new ArrayList[n+1];
        for(int i = 1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] wire : wires){
            int a = wire[0];
            int b = wire[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        for(int i = 0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            boolean[] visited = new boolean[n+1];
            
            graph[a].remove(Integer.valueOf(b));
            graph[b].remove(Integer.valueOf(a));
            
            int cnt = dfs(1, visited);
            
            
            int diff = Math.abs(cnt - (n - cnt));
            answer = Math.min(answer, diff);
            graph[a].add(b);
            graph[b].add(a);
        }
        
        return answer;
    }
    public int dfs(int node, boolean[] visited){
        visited[node] = true;
        int cnt = 1;
        for(int i : graph[node]){
            if(!visited[i]){
                cnt+=dfs(i, visited);
            }
        }
        return cnt;
    }
}