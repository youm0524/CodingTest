import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        String[][] file = new String[files.length][3];
        
        for(int i = 0; i<files.length; i++){
            String s = files[i];
            int idx = 0;
            while(idx<s.length() && !Character.isDigit(s.charAt(idx))){
                idx++;
            }
            //System.out.println(idx);
            String head = (s.substring(0,idx)).toLowerCase();
            file[i][0] = head;
            int start = idx;
            int count = 0;
            while(idx<s.length()&& count<5 && Character.isDigit(s.charAt(idx))){
                idx++;
                count++;
            }
            String tail = s.substring(start,idx);
            file[i][1] = tail;
            file[i][2] = s;
        }
        Arrays.sort(file,(a,b)->{
            int headCompare = a[0].compareTo(b[0]);
            if(headCompare!=0){
                return headCompare;
            }
            int tailA = Integer.parseInt(a[1]);
            int tailB = Integer.parseInt(b[1]);
            return tailA-tailB;
        });
        String[] answer = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            answer[i] = file[i][2];
        }
        
        return answer;

//         for(int i = 0; i<file.length; i++){
            
//             String head = file[i][0];
//             String tail = file[i][1];
            
//             System.out.println(head+" "+tail);
//         }
        
    }
}