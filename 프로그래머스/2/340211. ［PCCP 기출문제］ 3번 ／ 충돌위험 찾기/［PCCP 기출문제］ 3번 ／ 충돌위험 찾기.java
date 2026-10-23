import java.util.*;
class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int[] route : routes){
            int cnt = 0;
            int startX = points[route[0]-1][0];
            int startY = points[route[0]-1][1];
            String key = startX + "," +startY+","+cnt;
            map.put(key, map.getOrDefault(key,0)+1);
            
            for(int r = 1; r<route.length; r++){
                int finX = points[route[r]-1][0];
                int finY = points[route[r]-1][1];
                
                while(startX!=finX || startY != finY){
                    if(startX!=finX){
                        startX+=Integer.compare(finX,startX);
                    }else{
                        startY +=Integer.compare(finY,startY);
                    }
                    cnt++;
                    key = startX +","+ startY +","+cnt;
                    map.put(key,map.getOrDefault(key,0)+1);
                }
            }
        }
        for(int value : map.values())if(value>=2)answer++;
        return answer;
    }
}