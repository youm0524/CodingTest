import java.util.*;
class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int[] route : routes){
            int m = route.length;
            //로봇마다 시간을 초기화
            int cnt = 0;
            int startX = points[route[0]-1][0];
            int startY = points[route[0]-1][1];
            
            // 최초 출발점은 한 번만 기록
            String key = startX + "," + startY + "," + cnt;
            map.put(key, map.getOrDefault(key, 0) + 1);
            
            for(int i = 0; i<m-1; i++){
                startX = points[route[i]-1][0];
                startY = points[route[i]-1][1];
                int finX = points[route[i+1]-1][0];
                int finY = points[route[i+1]-1][1];
                
                while(startX!=finX || startY!=finY){
                    if(Integer.compare(startX, finX)>0){
                        startX--;
                    }else if(Integer.compare(startX,finX)<0){
                        startX++;
                    }else if(Integer.compare(startY, finY)>0){
                        startY--;
                    }else if(Integer.compare(startY, finY)<0){
                        startY++;
                    }
                    cnt++;
                    key = startX + ","+startY+","+cnt;
                    map.put(key,map.getOrDefault(key,0)+1);
                }
                
            }
        }
        //for(String key : map.keySet())System.out.println(key);
        for(int value : map.values())if(value>=2)answer++;
        return answer;
    }
}