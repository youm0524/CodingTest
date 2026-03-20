import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        List<int[]> list = new ArrayList<>();
        
        Arrays.sort(routes,(a,b)->Integer.compare(a[1], b[1]));
        list.add(routes[0]);
        for(int i = 1; i<routes.length; i++){
            int a = routes[i][0];
            int b = routes[i][1];
            int idx = 0;
            int[] re = new int[2];
            for(int[] li : list){
                int start = li[0];
                int end = li[1];
                if(b<start || a>end){
                    idx = 1;
                    re[0] = a;
                    re[1] = b;
                    //System.out.println(start+" "+end);
                }
                else{
                    idx = 0;
                    break;
                    //System.out.println(a+" "+b);
                    //answer++;
                }
            }
            if(idx==1){
                answer++;
                list.remove(re);
                int k = a>re[0]?re[0]:a;
                int p = b>re[1]?re[1]:b;
                list.add(new int[]{k,p});
            }
        }
        return answer;
    }
}