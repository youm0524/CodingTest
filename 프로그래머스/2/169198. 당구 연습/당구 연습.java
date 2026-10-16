import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        int idx = 0;

        for(int[] ball : balls){
            int bx = ball[0];
            int by = ball[1];

            int left = (startX+bx)*(startX+bx)
                     + (startY-by)*(startY-by);

            int right = (2*m-startX-bx)*(2*m-startX-bx)
                      + (startY-by)*(startY-by);

            int down = (startX-bx)*(startX-bx)
                     + (startY+by)*(startY+by);

            int up = (startX-bx)*(startX-bx)
                   + (2*n-startY-by)*(2*n-startY-by);

            // 목표 공을 먼저 맞히는 방향 제외
            if(startX == bx){
                if(startY < by) up = Integer.MAX_VALUE;
                else down = Integer.MAX_VALUE;
            }

            if(startY == by){
                if(startX < bx) right = Integer.MAX_VALUE;
                else left = Integer.MAX_VALUE;
            }

            int min = Math.min(Math.min(left,right), Math.min(down,up));

            answer[idx] = min;
            idx++;
        }

        return answer;
    }
}