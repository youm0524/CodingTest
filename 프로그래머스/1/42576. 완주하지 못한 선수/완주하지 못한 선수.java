import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> parti = new HashMap<>();
        Map<String, Integer> comple = new HashMap<>();
        
        for(String s : participant){
            parti.put(s, parti.getOrDefault(s,0)+1);
        }
        
        for(int i = 0; i<completion.length; i++){
            if(parti.containsKey(completion[i])){
                int n= parti.get(completion[i]);
                parti.put(completion[i],n-1);
            }
        }
        
        List<String> keySet = new ArrayList<>(parti.keySet());
        for(String key : keySet){
            if(parti.get(key)!=0){
                System.out.println(key);
                answer=key;
            }
        }
        return answer; 
    }
}