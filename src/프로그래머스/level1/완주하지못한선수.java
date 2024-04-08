package 프로그래머스.level1;
import java.util.Arrays;
public class 완주하지못한선수 {

    class Solution {
        public String solution(String[] participant, String[] completion) {
            Arrays.sort(participant);
            Arrays.sort(completion);
            int i;
            for ( i=0; i<completion.length; i++){

                if (!participant[i].equals(completion[i])){
                    return participant[i];
                }
            }
            return participant[i];
        }
    }
}
