import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> kind = new HashSet<>();
        for(String gem : gems){
            kind.add(gem);
        }
        int l = 0;
        int r = 0;
        Map<String, Integer> map = new HashMap<>();
        int minL = Integer.MAX_VALUE;
        while(true){
            if(map.size()==kind.size()){
                if(r-l<minL){
                    minL = r-l;
                    answer[0] = l+1;
                    answer[1] = r;
                }
                String s = gems[l];
                map.put(s, map.getOrDefault(s,0)-1);
                if(map.get(s)==0){
                    map.remove(s);
                }
                l++;
            }
            else{
                if(r>=gems.length)break;
                String ss = gems[r];
                map.put(ss,map.getOrDefault(ss,0)+1);
                r++;
            }
        }
        return answer;
    }
}