import java.util.*;
class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    int answer = 0;
    public int solution(int n, int[][] edge) {
        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] node: edge){
            int w = node[0];
            int v = node[1];
            graph.get(w).add(v);
            graph.get(v).add(w);
        }
        
        boolean[] visited = new boolean[n+1];
        bfs(graph, visited);
        return answer;
    }
    public void bfs(List<List<Integer>> graph, boolean[] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1,0}); //초기 1 , depth 0
        visited[1] = true;
        int maxDepth = 0;
        while(!queue.isEmpty()){
            int[] num = queue.poll();
            int v = num[0];
            int dep = num[1];
            if(dep==maxDepth)answer++;
            else if(dep>maxDepth){
                maxDepth = dep;
                answer= 1;
            }
            for(int i = 0; i<graph.get(v).size(); i++){
                int w = graph.get(v).get(i);
                if(!visited[w]){
                    queue.add(new int[]{w,dep+1});
                    visited[w] = true;
                }
            }
        }
    }
}