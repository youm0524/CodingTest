import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] list = new String[numbers.length];
        for(int i = 0; i<numbers.length; i++){
            list[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(list, (str1,str2)->(str2+str1).compareTo(str1+str2));
        
        for(String s : list){
            answer+=s;
        }      
        if(answer.charAt(0) == '0'){
            answer = "0";
        }

        return answer;
    }
}