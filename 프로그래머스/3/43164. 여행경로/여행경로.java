import java.util.*;
class Solution {
    static String[][] tickets;
    static boolean[] visited;
    static String[] answer;
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        Arrays.sort(this.tickets, Comparator.comparing(i -> i[1]));
        visited = new boolean[tickets.length];
        List<String> path = new ArrayList<>();
        path.add("ICN");
        dfs("ICN", 0, path);
        return answer;
    }
    public void dfs(String start, int depth, List<String> path){
        if(answer != null) return;
        if(depth == tickets.length){
            answer = path.toArray(new String[0]);
            return;
        }
        for(int i = 0; i<tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(start)){
                visited[i] = true;
                path.add(tickets[i][1]);
                dfs(tickets[i][1],depth + 1, path);
                path.remove(path.size()-1);
                visited[i] = false;
            }
        }
        
    }
}