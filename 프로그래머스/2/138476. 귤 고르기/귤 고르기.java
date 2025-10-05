import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int sum = 0;
        HashMap<Integer,Integer> maps = new HashMap<>();
        for(int num : tangerine){
            maps.put(num, maps.getOrDefault(num,0)+1);
        }
        
        List<Integer> keySet = new ArrayList<>(maps.keySet());
        keySet.sort((o1, o2) -> maps.get(o2).compareTo(maps.get(o1)));
        //for(int i : keySet)System.out.println(maps.get(i));
        for(int i : keySet){
            int a = maps.get(i);
            System.out.println(a);
            if(k>sum){
                answer++;
                sum+=a;
            }else break;
            
        }
        return answer;
    }
}