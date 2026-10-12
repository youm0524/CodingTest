import java.util.*;
class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        Map<String,Integer> map = new HashMap<>();
        for(int[] route : routes){
            
            int x = points[route[0]-1][0];
            int y = points[route[0]-1][1];
             
            int t = 0;
            String key = x+","+y+","+t;
            map.put(key, map.getOrDefault(key,0)+1);
            
            for(int r = 1; r<route.length; r++){
                int finX = points[route[r]-1][0];
                int finY = points[route[r]-1][1];
                
                while(x!=finX || y!=finY){
                    if(x!=finX){
                        x+=Integer.compare(finX,x);
                    }else{
                        y+=Integer.compare(finY,y);
                    }
                    t++;
                    key = x+","+y+","+t;
                    map.put(key, map.getOrDefault(key,0)+1);
                }
                
            }
            
        }
        for(int value : map.values()){
            if(value>=2)answer++;
        }
        return answer;
    }
}