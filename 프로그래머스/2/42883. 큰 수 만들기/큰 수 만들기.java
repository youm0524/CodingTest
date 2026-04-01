import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder answerBuilder = new StringBuilder();

        int len = number.length()-k;
        int start = 0;
        for(int i = 0; i<len; i++){
            char max = '0';
            for(int j = start; j<=i+k;j++){
                if(number.charAt(j)>max){
                    max = number.charAt(j);
                    start = j+1;
                }
            }
            answerBuilder.append(Character.toString(max));
        }
        answer = answerBuilder.toString();
        return answer;
    }
}