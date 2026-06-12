import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int end = Arrays.stream(diffs).max().getAsInt();
        int start = 1;
        int level = 0;
        while(start<=end){
            level = (start + end)/2;
            //System.out.println("level"+level);
            long sum = 0;
            for(int i = 0; i<diffs.length; i++){
                if(diffs[i]>level){
                    sum += (long)(times[i]+times[i-1]) * (diffs[i]-level)
                        +times[i];
                }else sum += times[i];
            }
                if(sum>limit){
                    start = level +1;
                    //System.out.println("start"+start);
                    //break;
                }else {
                    end = level-1;
                    //System.out.println(end);
                }
            }
        System.out.println(level);
        

        return start;
    }
}