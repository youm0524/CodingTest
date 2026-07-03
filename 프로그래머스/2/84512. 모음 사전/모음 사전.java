class Solution {
    static int count = 0;
    static int answer;
    static String[] words = new String[]{"A","E","I","O","U"};
    public int solution(String word) {
        answer = 0;
        dfs("",word);
        return answer;
    }
    public void dfs(String cur, String word){
        if(cur.length()>0){
            count++;
            if(cur.equals(word)){
                answer = count;
                return;
            }
        }
        if(cur.length()==5)return;
        for(int i = 0; i<words.length; i++){
            dfs(cur + words[i],word);
        }
        
    }
}