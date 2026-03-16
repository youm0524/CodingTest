import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        
        List<String> li = new ArrayList<>();
        HashMap<String, String> info = new HashMap<>();
        int idx = 0;
        for(String s : record){
            String[] input = s.split(" ");
            if(input[0].equals("Enter") || input[0].equals("Change")){
                info.put(input[1],input[2]);
            }
        }
        for(String s : record){
            String[] input = s.split(" ");
            if(input[0].equals("Enter")){
                String name = info.get(input[1]);
                li.add(name+"님이 들어왔습니다.");
            }
            else if(input[0].equals("Leave")){
                String name = info.get(input[1]);
                li.add(name+"님이 나갔습니다.");
            }
        }
        String[] answer = li.toArray(new String[0]);
        return answer;
    }
}