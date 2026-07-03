import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        //answer[0] = 1;
        Set<String> set = new HashSet<>();
        int cnt = 1;
        String last=words[0];
        set.add(last);
        int idx = 1;
        
        for(int i = 1; i<words.length; i++){
            String now = words[i];
            System.out.println(now);
            cnt++;
            idx++;
            if(now.charAt(0)!=last.charAt(last.length()-1)){
                idx = 0;
                break;
            }
            //말한 단어 다시 말하기
            if(set.contains(now)){
                idx = 0;
                //System.out.println(idx);
                break;
            }
            else if(!set.contains(now)){
                set.add(now);
                last = words[i];
            }
        }
        System.out.println(cnt);
        //System.out.println(idx);


        if(cnt==words.length && idx == words.length){
            return new int[]{0,0};
        }
        
        if(cnt%n!=0){
            answer[1] = (cnt/n)+1;
            answer[0] = cnt%n;
        }
        else {
            answer[1] = cnt/n;
            answer[0] = n;
        }

        return answer;
    }
}