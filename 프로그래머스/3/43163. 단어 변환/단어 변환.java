class Solution {
    static int answer =50;
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        int count = 0;
        dfs(begin, target, words,visited,count);
        if(answer == 50)return 0;
        return answer;
    }
    public void dfs(String begin, String target, String[] words, boolean[] visited, int count){
        if(begin.equals(target)){
            if(count<answer)answer = count;
        }
        for(int i = 0; i<words.length; i++){
            int diff = 0;
            for(int j = 0; j<words[i].length(); j++){
                if(words[i].charAt(j)!=begin.charAt(j)){
                    diff++;
                    if(diff>2) break;
                }
            }
            if(!visited[i] && diff==1){
                visited[i] = true;
                dfs(words[i], target,words,visited,count+1);
                System.out.println(answer);
                visited[i] = false;
            }
        }
        
    }
}