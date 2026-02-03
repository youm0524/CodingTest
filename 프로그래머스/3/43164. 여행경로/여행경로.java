import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        List<String> path = new LinkedList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(String[] ss : tickets){
            map.putIfAbsent(ss[0],new PriorityQueue<>());
            map.get(ss[0]).add(ss[1]);
        }
        
        dfs("ICN", map, path);
        answer = path.toArray(new String[0]);
        return answer;
    }
    public void dfs(String from, Map<String, PriorityQueue<String>> map, List<String> path){
        while(map.containsKey(from) && !map.get(from).isEmpty()){
            dfs(map.get(from).poll(), map, path);
        }
        path.add(0,from);
    }
}