package 프로그래머스.level1;
import java.util.*;

public class 숫자짝꿍 {

    class Solution {
        public String solution(String X, String Y) {
            StringBuilder sb = new StringBuilder("");
            String answer = "";
            int[] Xcount = new int[10];
            int[] Ycount = new int[10];

            //X카운트
            for(String x : X.split("")){
                Xcount[Integer.parseInt(x)]++;
            }
            //Y카운트
            for(String y : Y.split("")){
                Ycount[Integer.parseInt(y)]++;
            }

            for(int i = 9; i>=0 ; i--){
                while(Xcount[i]>0 && Ycount[i] > 0){
                    sb.append(i);
                    Xcount[i]--;
                    Ycount[i]--;
                }
            }
            answer = sb.toString();
            if (answer.isEmpty()) {
                return "-1";
            }
            if (answer.replaceAll("0", "").isEmpty()) {
                return "0";
            }

            return answer;
        }
    }
}
