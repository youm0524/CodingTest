package 프로그래머스.level1;

public class 요일구하기 {
    class Solution {
        public String solution(int a, int b) {
            int day = 0; //총 일수
            String answer = "";
            String[] week = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
            int[] month = {31,29,31,30,31,30,31,31,30,31,30,31};

            //a까지의 일수
            for(int i = 0; i<a-1; i++){
                day += month[i];
            }
            //b까지의 일수 더해주기
            day += b-1;
            answer = week[day%7];

            return answer;
        }
    }
}
