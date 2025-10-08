import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        //,로 종류를 나누기
        for(String[] cloth : clothes){
            String wear = cloth[0];
            String type = cloth[1];
            map.put(type,0);
        }
        
        for(String[] cloth : clothes){
            String wear = cloth[0];
            String type = cloth[1];
            map.put(type, map.getOrDefault(type,0)+1);
        }
        Set<String> keySet = map.keySet();
        ArrayList<Integer> list = new ArrayList<>();
        for(String s : keySet){
            int count = map.get(s);
            list.add(count);
        }
        
        //System.out.println(list.size());
        for(int i : list){
            answer *= (i+1);
        }
        
        
        return answer-1;
    }
}