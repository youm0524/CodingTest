package 프로그래머스.level1;

public class 시저암호 {
    class Solution {
        public String solution(String s, int n) {
            String answer = "";

            char[] ch = s.toCharArray();

            for(char c : ch) {
                if(c == 32) answer += " ";
                else {
                    if(c <= 90) {
                        c += n;
                        if(c > 90) c -= 26;
                    } else {
                        c += n;
                        if(c > 122) c -= 26;
                    }
                    answer += c;
                }
            }

            return answer;
        }
    }
}
