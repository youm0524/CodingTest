import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 1;
        long right = (long)times[times.length-1]*n;
        System.out.println(right);
        long sum = 0;
        while(left<=right){
            long middle = (left+right)/2;
            //System.out.println(middle);
            sum = 0;
            
            for(int i : times){
                sum+=middle/i;
                //System.out.println("sum"+sum);
            }
            if(sum>=n){
               right =middle-1;
            }
            else if(sum<n){
                left=middle+1;
            }
        }
        
        return left;
    }
}