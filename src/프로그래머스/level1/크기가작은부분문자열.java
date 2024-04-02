package 프로그래머스.level1;

public class 크기가작은부분문자열 {
    class Solution {
        public int solution(String t, String p) {
            int pLen = p.length();
            int answer = 0;

            for(int i = 0; i < t.length(); i++){
                int j = i + pLen;
                if(j<=t.length()){
                    long num = Long.parseLong(t.substring(i, j));
                    if(num <= Long.parseLong(p)) answer++;
                }
            }

            return answer;
        }
    }
}
