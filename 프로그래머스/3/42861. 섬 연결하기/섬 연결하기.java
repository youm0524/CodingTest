import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        //크루스칼
        Arrays.sort(costs,(a,b)->a[2]-b[2]);
        int[] parent = new int[n];
        
        for(int i=0; i<n; i++){
            parent[i] = i;
        }        
        for(int[] cost : costs){
            int a = cost[0];
            int b = cost[1];
            int c = cost[2];
            if(find(parent, a)!=find(parent, b)){
                union(parent, a,b);
                answer+=c;
            }
        }
        
        return answer;
    }
    public int find(int[] parent, int a){
        if(parent[a]==a)return a;
        else return find(parent, parent[a]);
    }
    
    public void union(int[] parent, int a, int b){
        int pa = find(parent, a);
        int pb = find(parent, b);
        parent[pb] = pa;
    }
}