import java.util.*;
class Solution {
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        //알파벳 순서 저장
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        //티켓 저장
        for(String[] ticket : tickets){
            map.putIfAbsent(ticket[0], new PriorityQueue());
            map.get(ticket[0]).add(ticket[1]);
        }
        List<String> path = new ArrayList<>();
        dfs(map, path, "ICN");
        Collections.reverse(path);
        answer = path.toArray(new String[0]);
        
        return answer;
    }
    public void dfs(Map<String, PriorityQueue<String>> map, List<String> path, String start){
        while (map.get(start) != null && !map.get(start).isEmpty()) {
    String next = map.get(start).poll();
    dfs(map, path,next);
}
    path.add(start);
        
    }
        
    
}