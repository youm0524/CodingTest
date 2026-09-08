import java.util.*;
class Solution {
    static int dunLen;
    static int max;
    static int K;
    static int[][] dungeon;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        K = k;
        dungeon = dungeons;
        dunLen = dungeons.length;
        visited = new boolean[dunLen];
        max = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        dfs(list);
        //System.out.println(max);
        return max;
    }
    public void dfs(List<Integer> list){
        if(list.size()==dunLen){
            max = Math.max(max,check(dungeon, list));
            //System.out.println(max);
            return;
        }
        for(int i = 0; i<dunLen; i++){
            if(visited[i])continue;
            list.add(i);
            visited[i]=true;
            dfs(list);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
    public int check(int[][] dungeons, List<Integer> list){
        int remain = K;
        int cnt = 0;
        
        for(int i : list){
            if(remain>= dungeons[i][0]){
                remain-=dungeons[i][1];
                cnt++;
                //System.out.println(cnt);
            }else{
                return cnt;
            }
        }
        //System.out.println(cnt);
        return cnt;
    }
}