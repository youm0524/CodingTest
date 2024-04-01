package 프로그래머스.level1;

public class 이상한문자만들기 {
    class Solution {
        public String solution(String s) {
            String answer = "";
            char[] ch = s.toCharArray();
            int idx = 0; // 짝 홀
            for(int i = 0; i<ch.length; i++){
                if(ch[i] == ' '){
                    idx = 0;
                    continue;
                }
                if(idx % 2 == 0){
                    ch[i] = Character.toUpperCase(ch[i]);
                }
                else ch[i] = Character.toLowerCase(ch[i]);
                idx++;
            }
            return String.valueOf(ch);
        }
    }
}
