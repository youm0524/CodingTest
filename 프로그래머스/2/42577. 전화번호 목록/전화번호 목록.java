import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> maps = new HashMap<>();
        for(String s: phone_book){
            maps.put(s,maps.getOrDefault(0,1));
        }
        for(String s: phone_book){
            for(int i = 0; i<s.length();i++){
                String ss = s.substring(0,i);
                if(maps.containsKey(ss))return false;
            }
        }
        boolean answer = true;
        return answer;
    }
}