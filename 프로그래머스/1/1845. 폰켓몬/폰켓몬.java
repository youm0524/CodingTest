import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int sum = 0;
        int N = nums.length/2;
        HashMap<Integer, Integer> maps = new HashMap<>();
        for(int i : nums){
            maps.put(i, maps.getOrDefault(i,0)+1);
            
        }
        
        if(maps.size()>=N) answer = N;
        else answer = maps.size();
        
        
        return answer;
    }
}