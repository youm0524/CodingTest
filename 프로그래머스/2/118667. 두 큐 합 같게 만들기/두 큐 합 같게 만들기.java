import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        int q1 = queue1.length;
        int q2 = queue2.length;
        long lsum = Arrays.stream(queue1).sum();;
        long rsum = Arrays.stream(queue2).sum();
        int[] sum = new int[(q1 + q2)*4];
        for(int i = 0; i<q1; i++){
            sum[i] = queue1[i];
            sum[i+q1] = queue2[i];
            sum[i+q1*2] = queue1[i];
            sum[i+q1*3] = queue2[i];
        }
        int lStart = 0;
        int rStart = q1;
        int count = 0;
        long half = (lsum+rsum)/2;
        int limit = (q1 + q2) * 3;
        while(count<=limit){
            if(lsum==half){
                return count;
            }
            if(lsum>half){
                lsum-=sum[lStart++];
            }
            else{
                lsum+=sum[rStart++];
            }
            count++;
        }
        return -1;
    }
}