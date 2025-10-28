import java.util.*;
class Solution {
    private static boolean visited[];
    private static ArrayList<String> list;
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        int cnt = 0;
        list = new ArrayList<String>();
        dfs("ICN", "ICN", tickets, cnt);
        String[] answer = {};
        Collections.sort(list);
        answer = list.get(0).split(" ");
        return answer;
    }
    public void dfs(String start, String route, String[][] tickets, int cnt){
        if(cnt == tickets.length){
            list.add(route);
        }
        for(int i = 0; i<tickets.length; i++){
            if(!visited[i] && start.equals(tickets[i][0])){
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, cnt+1);
                visited[i] = false;
            }
        }
        
    }
}