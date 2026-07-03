import java.util.*;
class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i<26; i++){
            String s = String.valueOf((char)(i+'A'));
            map.put(s,i+1);
        }
        int idx = 27;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<msg.length(); i++){
            for(int j = i; j<msg.length(); j++){
                String s = msg.substring(i,j+1);
                //System.out.println(s);
                if(!map.containsKey(s)){
                    String ss = msg.substring(i,j+1);
                    //System.out.println(ss);
                    map.put(ss, idx);
                    idx++;
                    int index = map.get(msg.substring(i,j));
                    list.add(index);
                    i = j-1;
                    break;
                }
                if(j == msg.length() - 1){
                    list.add(map.get(s));
                    i = j;
                }
                
            }
        }
        answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}