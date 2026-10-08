import java.util.*;
class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        //중복 cnt
        Map<String, Integer> map = new HashMap<>();
        
        for(int[] route : routes){
            int time = 0;
            int a = route[0];
            
            
            int x = points[a-1][0];
            int y = points[a-1][1];

            // 시작점 기록
            String startKey = x + "," + y + "," + time;
            map.put(startKey, map.getOrDefault(startKey, 0) + 1);
            for(int r = 0; r<route.length-1; r++){
                int b = route[r+1];
                int finX = points[b - 1][0];
                int finY = points[b - 1][1];
                if(x!=finX){
                    if(x<finX){
                          for(int i = x+1; i<=finX; i++){
                            time++;
                            String key = i + ","+y+","+time;
                            map.put(key, map.getOrDefault(key, 0) + 1);
                        }  
                    }else{
                        for(int i = x-1; i>=finX; i--){
                            time++;
                            String key = i + ","+y+","+time;
                            map.put(key, map.getOrDefault(key, 0) + 1);
                        }
                    }
                }
                if(y!=finY){
                    if(y<finY){
                            for(int i = y+1; i<=finY; i++){
                                time++;
                                String key = finX + ","+i+","+time;
                                map.put(key, map.getOrDefault(key, 0) + 1);
                                                        } 
                    }else{
                        for(int i = y-1; i>=finY; i--){
                            time++;
                            String key = finX + ","+i+","+time;
                            map.put(key, map.getOrDefault(key, 0) + 1);
                        }
                    }
                }
                x = finX;
                y = finY;
            }            
        }
        

        for(int cnt : map.values()){
            if(cnt>=2)answer++;
        }

        return answer;
    }
}