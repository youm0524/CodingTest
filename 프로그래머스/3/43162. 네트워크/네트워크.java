class Solution {
    
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        //1번부터 순회하면서 방문할 수 있으면 가기
        visited = new boolean[n];
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                answer++;
                dfs(i, n, computers);
            }
        }
        
        return answer;
    }
    public void dfs(int i, int n, int[][] computers){
        visited[i] = true;
        for(int j = 0; j<n; j++){
            if(!visited[j] && computers[i][j]==1){
                System.out.println("i"+i+" j"+j);
                dfs(j,n,computers);
            }
        }
    }
}