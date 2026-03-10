import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        s = s.substring(2,s.length()-2);
        String[] str = s.split("\\},\\{");
        int[] answer = new int[str.length];
        int idx = 0;
        Arrays.sort(str, (a,b)->a.length()-b.length());
        Set<Integer> set = new HashSet<>();
        for(String ss : str){
            for(String num : ss.split(",")){
                int n = Integer.parseInt(num);
                if(!set.contains(n)){
                    set.add(n);
                    answer[idx] = n;
                    idx++;
                }
            }
        }
        return answer;
    }
}