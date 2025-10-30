import java.util.*;
class Solution {
    static String[] dic = {"A","E","I","O","U"};
    static List<String> list = new ArrayList<>();
    public int solution(String word) {
        int answer = 0;
        int len = 0;
        dfs("",0);
        for(int i = 0; i<list.size(); i++){
            if(list.get(i).equals(word)){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    public void dfs(String s,int len){
        list.add(s);
        if(len == dic.length)return;
        for(int i = 0; i<dic.length;i++){
            dfs(s+dic[i],len+1);
        }
    }
}