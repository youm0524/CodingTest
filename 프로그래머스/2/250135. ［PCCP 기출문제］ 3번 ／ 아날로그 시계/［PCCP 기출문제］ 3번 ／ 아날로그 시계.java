class Solution {
    public int solution(int h1, int m1, int s1,
                        int h2, int m2, int s2) {

        int answer = 0;

        /*
         * 각도를 120배해서 정수로 표현
         *
         * 시침 1초 이동 = 1
         * 분침 1초 이동 = 12
         * 초침 1초 이동 = 720
         *
         * 360도 = 43200
         */

        int hour = (3600 * (h1 % 12) + 60 * m1 + s1);
        int min  = (720 * m1 + 12 * s1);
        int sec  = 720 * s1;

        int startTime = h1 * 3600 + m1 * 60 + s1;
        int endTime   = h2 * 3600 + m2 * 60 + s2;

        int time = endTime - startTime;

        // 시작 시각에 이미 겹쳐 있다면 1번
        if(sec == min || sec == hour){
            answer++;
        }

        for(int t = 0; t < time; t++){

            // 1초 후 각도
            // 아직 %43200 하지 않음!!
            int nextHour = hour + 1;
            int nextMin  = min + 12;
            int nextSec  = sec + 720;

            // 현재는 초침이 뒤에 있었는데
            // 1초 후에는 분침을 넘어섰다면
            boolean meetMin =
                    sec < min && nextSec >= nextMin;

            // 시침도 동일
            boolean meetHour =
                    sec < hour && nextSec >= nextHour;

            if(meetMin){
                answer++;
            }

            if(meetHour){
                answer++;
            }

            /*
             * 만약 같은 순간에
             * 시침, 분침, 초침이 모두 겹쳤다면
             * 위에서 2번 세었으므로 1번 빼줌.
             *
             * 분침과 만나는 시간:
             * (min-sec) / (720-12)
             *
             * 시침과 만나는 시간:
             * (hour-sec) / (720-1)
             */
            if(meetMin && meetHour){
                long minGap = min - sec;
                long hourGap = hour - sec;

                if(minGap * 719 == hourGap * 708){
                    answer--;
                }
            }

            // 비교가 끝난 다음 0~360도로 돌려놓기
            hour = nextHour % 43200;
            min  = nextMin % 43200;
            sec  = nextSec % 43200;
        }

        return answer;
    }
}