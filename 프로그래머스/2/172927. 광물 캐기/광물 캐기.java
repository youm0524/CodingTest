import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int totalPicks = picks[0] + picks[1] + picks[2];
        
        int max = Math.min(minerals.length, totalPicks*5);
        int groupcnt = (max+4)/5;
        int[][] cnt = new int[groupcnt][4];
        for(int i = 0; i<groupcnt; i++){
            for(int j = 0; j<5; j++){
                int idx = i*5 + j;
                if(idx >= max) break;
                String s = minerals[idx];
                if(s.equals("diamond")){
                    cnt[i][0]++;
                    cnt[i][3]+=25;
                }else if(s.equals("iron")){
                    cnt[i][1]++;
                    cnt[i][3]+=5;
                }else{
                    cnt[i][2]++;
                    cnt[i][3]+=1;
                }
            } 
        }
        Arrays.sort(cnt,(a,b)->b[3]-a[3]);
        
        int idx = 0;

        while (idx < groupcnt && picks[0] > 0) {
            answer += cnt[idx][0] + cnt[idx][1] + cnt[idx][2];
            picks[0]--;
            idx++;
        }

        while (idx < groupcnt && picks[1] > 0) {
            answer += cnt[idx][0] * 5 + cnt[idx][1] + cnt[idx][2];
            picks[1]--;
            idx++;
        }

        while (idx < groupcnt && picks[2] > 0) {
            answer += cnt[idx][0] * 25 + cnt[idx][1] * 5 + cnt[idx][2];
            picks[2]--;
            idx++;
        }
        
        
        return answer;
    }
}