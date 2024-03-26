package 프로그래머스.level1;
import java.util.Arrays;
public class 문자열나누기 {


    class Solution {
        public int solution(String s) {
            char[] ch = s.toCharArray();
            char first = ch[0];
            int answer = 1;
            int count = 1;
            int diff = 0;
            for(int i = 1; i<ch.length; i++){
                char temp = ch[i];
                System.out.println(first);
                if(count == diff){
                    answer++;
                    first = temp;
                    count = 1;
                    diff = 0;
                }
                else{
                    if(first==temp)
                        count++;
                    else
                        diff++;
                }
            }

            return answer;
        }
    }
}
