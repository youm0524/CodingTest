import java.util.*;
class Solution {
    
    int toMinute(String time){
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
    
    public int solution(String[][] book_time) {
        Arrays.sort(book_time,(a,b)->{
            return toMinute(a[0]) - toMinute(b[0]);
        });
        
        Map<Integer, String> map = new HashMap<>();
        int idx = 1;
        
        for(String[] t : book_time){
            if(map.isEmpty()){
                map.put(idx,t[1]);
            }
            else{
                int t1 = toMinute(t[0]);
                int flag = 1; 
                
                for(Map.Entry<Integer, String> entry : map.entrySet()){
                    int t2 = toMinute(entry.getValue());
                    
                    if((t2 + 10) <= t1){
                        flag = 0;
                        map.put(entry.getKey(),t[1]);
                        break;
                    }
                }
                
                if(flag == 1){
                    idx++;
                    map.put(idx,t[1]);
                }
            }
        }
        return map.size();
    }
}