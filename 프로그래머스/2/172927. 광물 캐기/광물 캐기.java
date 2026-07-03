import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int totalPicks = picks[0] + picks[1] + picks[2];
        int maxMinerals = Math.min(minerals.length, totalPicks * 5);
        int groupCnt = (maxMinerals + 4) / 5;
        int[][] mineral = new int[groupCnt][4];
        for(int i = 0; i<maxMinerals; i++){
            int idx = i / 5;
            if(minerals[i].equals("diamond")){
                mineral[idx][0]++;
                mineral[idx][3]+=25;
            }else if(minerals[i].equals("iron")){
                mineral[idx][1]++;
                mineral[idx][3]+=5;
            }else{
                mineral[idx][2]++;
                mineral[idx][3]+=1;
            }
        }
        
        Arrays.sort(mineral,(a,b)->b[3]-a[3]);
        
        for(int i = 0; i<groupCnt; i++){
            if(picks[0]>0){
                answer+=mineral[i][0] + mineral[i][1] + mineral[i][2];
                picks[0]--;
                System.out.println(answer);
            }
            else if(picks[1]>0){
                answer+= mineral[i][0]*5 + mineral[i][1] + mineral[i][2];
                picks[1]--;
                System.out.println(answer);
            }
            else if(picks[2]>0){
                answer+= mineral[i][0]*25 + mineral[i][1]*5 + mineral[i][2];
                picks[2]--;
            }
            
        }
        return answer;
    }
}