import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        double cnt = 0;
        int prev_y = k;
        Map<Double,Double> map = new HashMap<>();
        map.put(0.0,0.0);
        double prev_size = 0;
        while(k>1){
            if(k%2==0)k/=2.0;
            else k=k*3+1;
            cnt++;
            double size = 0;
            if(prev_y<=k){
                size = k - (k-prev_y)/2.0;
            }else size = prev_y - (prev_y-k)/2.0;
            prev_y = k;
            prev_size += size;
           // System.out.println(prev_size+" "+size+" "+cnt);
            map.put(cnt,prev_size);
        }
        
        // Set<Double> set = map.keySet();
        // for(double i : set){
        //     System.out.println(i+" "+map.get(i));
        // }
        int idx = 0;
        for(int[] range : ranges){
            double a = range[0];
            double b = range[1];
            double x1 = a;
            double x2 = cnt+b;
            //System.out.println(x1+" "+x2);
            if(x1>x2) answer[idx] = -1.0;
            else answer[idx] = map.get(x2)-map.get(x1);
            idx++;
        }
        return answer;
    }
}