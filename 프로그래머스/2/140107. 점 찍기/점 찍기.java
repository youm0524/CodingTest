import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for(int x = 0; x<=d; x+= k){
            long y = (long) Math.sqrt((long)d * d - (long)x * x);
            long cnt = y/k+1;
            //System.out.println(cnt+" "+y);
            answer+=cnt;
        }
        return answer;
    }
}