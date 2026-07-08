import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] crew = new int[timetable.length];
        
        for(int i = 0; i<timetable.length; i++){
            crew[i] = toMin(timetable[i]);
        }
        
        Arrays.sort(crew);

        int idx = 0;
        int answer = 0;
        
        for(int bus = 0; bus<n; bus++){
            //9시 시작이니까
            int busT = 540 + t * bus;
            int cnt = 0;
            //태울 수 있는 수만큼 태움
            while(idx<crew.length && crew[idx]<=busT && cnt<m){
                idx++;
                cnt++;
            }
            
            //마지막에 cnt기준으로 확인
            if (bus == n - 1) {
                //m보다 작다는건 마지막 셔틀에 가면 됨
                if (cnt < m) {
                    answer = busT;
                } else { // 크면 마지막 크루보다 1분 더 빨리오기
                    answer = crew[idx - 1] - 1;
                }
            }
        }
        //출력 형식 맞게
        return toTime(answer);
    }
    public int toMin(String time) {
        String[] split = time.split(":");
        int h = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        return h * 60 + m;
    }
    
    public String toTime(int minute) {
        int h = minute / 60;
        int m = minute % 60;
        return String.format("%02d:%02d", h, m);
    }
}