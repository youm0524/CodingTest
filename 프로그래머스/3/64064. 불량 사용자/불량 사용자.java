import java.util.*;

class Solution {
    List<List<Integer>> list = new ArrayList<>();   // 🔥 map → list
    Set<Set<Integer>> result = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        find(user_id, banned_id);
        dfs(0, new boolean[user_id.length], banned_id);
        return result.size();
    }
    
    public void find(String[] user_id, String[] banned_id){
        for(String ban : banned_id){
            List<Integer> temp = new ArrayList<>();   // 🔥 각 banned마다 리스트
            
            for(int i = 0; i < user_id.length; i++){
                String user = user_id[i];
                
                if(user.length() != ban.length()) continue;
                
                boolean valid = true;
                
                for(int j = 0; j < ban.length(); j++){
                    if(ban.charAt(j) != '*' && ban.charAt(j) != user.charAt(j)){
                        valid = false;
                        break;
                    }
                }
                
                if(valid){
                    temp.add(i);   // 🔥 index 저장
                }
            }
            
            list.add(temp);   // 🔥 핵심
        }
    }
    
    public void dfs(int depth, boolean[] visited, String[] banned_id){
        if(depth == banned_id.length){
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < visited.length; i++){
                if(visited[i]) set.add(i);
            }
            result.add(set);
            return;
        }
        
        for(int idx : list.get(depth)){   // 🔥 map → list
            if(!visited[idx]){
                visited[idx] = true;
                dfs(depth + 1, visited, banned_id);
                visited[idx] = false;
            }
        }
    }
}