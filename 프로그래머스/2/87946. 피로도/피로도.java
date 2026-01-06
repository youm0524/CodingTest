class Solution {
    static boolean visited[];
    static int cnt;
    static int answer= 0;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        int cnt = 0;
        
        dfs(k, dungeons, cnt);
        return answer;
    }
    public void dfs(int k, int[][] dungeons, int cnt){
        answer = Math.max(answer, cnt);
        for(int i = 0; i<dungeons.length;i++){
            if(k>=dungeons[i][0] && !visited[i]){
                visited[i] = true;
                int tmp = k-dungeons[i][1];
                //System.out.println(cnt);
                dfs(tmp, dungeons, cnt+1);
                visited[i] = false;
            }
        }
        return;
    }
}