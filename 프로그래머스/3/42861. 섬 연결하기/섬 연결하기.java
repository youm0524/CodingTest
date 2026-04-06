import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, (a,b)-> a[2]-b[2]);
        int[] parent = new int[n+1];
        for(int i = 0; i<n; i++){
            parent[i] = i;
        }
        int cnt = 0;
        for(int[] cost : costs){
            int a = cost[0];
            int b = cost[1];
            int c = cost[2];
            
            int pa = find(parent, a);
            int pb = find(parent, b);

            if (pa != pb) {
                parent[pb] = pa;
                answer+=c;
            }
            
        }
        return answer;
    }
    public int find(int[] parent, int x) {
        if(parent[x] == x)return x;
        else return find(parent,parent[x]);
    }
}