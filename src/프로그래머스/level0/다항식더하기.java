package 프로그래머스.level0;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class 다항식더하기 {

    class Solution {
        public String solution(String polynomial) {

            polynomial = polynomial.replaceAll(" ","");
            String[] poly = polynomial.split("\\+");
            List<String>list = new ArrayList<>();
            for(String str:poly){
                list.add(str);
            }
            int xcount = 0;
            int count = 0;
            for(String e:list){
                if(e.contains("x")){
                    e = e.replace("x","");
                    if(e.equals("")){
                        xcount++;
                    }
                    else{
                        int num1 = Integer.parseInt(e);
                        xcount+=num1;
                    }
                }
                else{
                    int num2 = Integer.parseInt(e);
                    count += num2;
                }

            }
            String answer = "";
            if(count == 0){
                if(xcount == 1){
                    answer = "x";
                }
                else{
                    answer = xcount + "x";
                }
            }
            else if(xcount == 0){
                answer = ""+count;
            }
            else{
                if(xcount == 1){
                    answer = "x" + " + " + count;
                }
                else{
                    answer = xcount + "x" + " + " + count;
                }
            }
            return answer;
        }
    }
}
