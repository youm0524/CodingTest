import java.util.*;
class Solution {
    Map<String, Integer> map = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        List<String> result = new ArrayList<>();
        for(int i = 0; i<course.length; i++){
            map.clear();
            for(int j = 0; j<orders.length; j++){
                StringBuilder sb = new StringBuilder();
                char[] charArr = orders[j].toCharArray(); 
                Arrays.sort(charArr);
                String ss = new String(charArr);
                com(0,course[i],0,ss, sb);
            }
            int max = 0;
            String input = "";
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                max = Math.max(max,entry.getValue());
            }
            if(max>=2){
                for(Map.Entry<String, Integer> entry : map.entrySet()){
                    if(entry.getValue()==max){
                        result.add(entry.getKey());
                    }
                }
            }
            
        }
        Collections.sort(result);
        for(String s : result){
            System.out.println(s);
        }
        answer = result.toArray(new String[0]);
        return answer;
    }
    public void com(int start, int n, int cnt,String order, StringBuilder sb){
        if(cnt==n){
            String s = sb.toString();
            map.put(s, map.getOrDefault(s,0) +1);
            return;
        }
        for(int i = start; i<order.length(); i++){
            sb.append(order.charAt(i));
            com(i+1, n, cnt+1, order, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}