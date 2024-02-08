package 프로그래머스.level0;

public class 문자열밀기 {
    class Solution {
        public int solution(String A, String B) {
            String tA = A;
            int answer = 0;

            for(int i = 0;i<A.length();i++){
                if(tA.equals(B)){
                    return answer;
                }
                String a = tA.substring(tA.length()-1);
                tA = a + tA.substring(0,tA.length()-1);
                answer++;
            }
            return -1;
        }
    }
}
