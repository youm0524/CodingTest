import java.util.*;
class Solution {
    public ArrayList<Integer>[] graph;
    public int[] min;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        graph = new ArrayList[n+1];
        for(int i = 0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i<roads.length; i++){
            graph[roads[i][0]].add(roads[i][1]);
            graph[roads[i][1]].add(roads[i][0]);
        }
        
        min = new int[n+1];
        Arrays.fill(min,Integer.MAX_VALUE);
        find(destination);
        int[] answer = new int[sources.length];
        for(int i = 0; i < sources.length; i++){
            if(min[sources[i]] == Integer.MAX_VALUE){
                answer[i] = -1; // 도달할 수 없는 경우
            } else {
                answer[i] = min[sources[i]]; // 최단 거리 값 반환
            }
        }
        return answer;
    }
    public void find(int start){
        min[start] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start,0});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i = 0; i<graph[cur[0]].size(); i++){
                int next = graph[cur[0]].get(i);
                //System.out.println("next: "+next+"i:"+i);
                if(min[next]>cur[1]+1){
                    min[next] = cur[1]+1;
                    queue.add(new int[]{next, cur[1]+1});
                }
            }
        }
    }
}