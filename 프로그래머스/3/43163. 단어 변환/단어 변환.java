class Solution {
    boolean[] visited;
    int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin,target,words,0);
        if(answer == Integer.MAX_VALUE){
            answer = 0;
        }
        //System.out.println(answer);
        return answer;
    }
    public void dfs(String begin, String target, String[] words, int cnt){
        if(begin.equals(target)){
            answer = Math.min(cnt,answer);
        }
        for(int j = 0; j<words.length; j++){
            int count = 0;
            String s = words[j];
            for(int i = 0; i<s.length(); i++){
                if(s.charAt(i)!=begin.charAt(i))count++;
            }
            if(count==1 && !visited[j]){
                visited[j] = true;
                dfs(s,target,words,cnt+1);
                visited[j] = false;
            }
        }
    }
}