import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> maps = new HashMap<>();
        for(int i = 0; i<clothes.length; i++){
            String name = clothes[i][0];
            String type = clothes[i][1];
            //종류마다 몇개의 의상이 있는지 넣어주기
            maps.put(type, maps.getOrDefault(type,0)+1);
        }
        List<String> keySet = new ArrayList<>(maps.keySet());
        //각 종류마다의 조합을 계산해주기
        for(String s:keySet){
            answer*=(maps.get(s)+1);
        }
        return answer-1;
    }
}