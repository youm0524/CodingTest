import java.util.*;
class Solution {
    private static boolean visited[];
    private static int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        int cnt = 0;
        visited = new boolean[words.length];
        dfs(begin, target, words, cnt);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    public void dfs(String begin, String target, String[] words,int cnt){
        if(begin.equals(target)){
            answer = Math.min(cnt, answer);
        }
        
        for(int i = 0; i<words.length; i++){
            int k = 0;
            for(int j = 0; j<begin.length(); j++){
                if(begin.charAt(j)==words[i].charAt(j))k++;
            }
            if(k==begin.length()-1 && !visited[i]){
                visited[i] = true;
                dfs(words[i], target, words,cnt+1);
                visited[i] = false;
            }
        }
    }
}