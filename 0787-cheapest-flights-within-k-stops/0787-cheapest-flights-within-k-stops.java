import java.util.*;
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] flight: flights){
            graph.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }
        //비용 기준 우선순위 큐를 선언
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);

        int[] visited = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);

        pq.offer(new int[]{src,0,0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];
            int stop = cur[2];

            if(node == dst) return cost;
            if(stop>k)continue;
            if(visited[node]<=stop)continue;
            visited[node] = stop;
            for(int[] next : graph.get(node)){
                pq.add(new int[]{
                    next[0],
                    next[1] + cost,
                    stop+1
                });
            }
        }
        return -1;
    }
}