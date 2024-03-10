package 프로그래머스.level0;
import java.util.*;
public class 코드처라하기 {


    class Solution {
        public String solution(String code) {
            StringBuilder sb = new StringBuilder();
            char[] codes = code.toCharArray();
            int mode = 0;
            for (int i = 0; i<codes.length;i++){
                if(codes[i] == '1'){
                    if(mode == 0){
                        mode = 1;
                    }
                    else{
                        mode = 0;
                    }
                    continue;
                }
                if(mode == 0){
                    if(i % 2 == 0)
                        sb.append(codes[i]);
                }
                if(mode == 1){
                    if(i%2 == 1)
                        sb.append(codes[i]);
                }

            }
            if(sb.length() == 0){
                return "EMPTY";
            }
            return sb.toString();
        }
    }
}
