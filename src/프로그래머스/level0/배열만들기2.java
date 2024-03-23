package 프로그래머스.level0;
import java.util.*;
public class 배열만들기2 {
    class Solution {
        public int[] solution(int l, int r) {
            List<Integer> a = new ArrayList<>();
            for(int i = l; i<=r; i++){
                int flag = 0;
                char[] st = Integer.toString(i).toCharArray();
                for(int j = 0; j<st.length; j++){
                    if(st[j] != '0' && st[j] != '5'){
                        flag = 1;
                        break;
                    }
                }

                if(flag==0)
                    a.add(i);

            }


            int[] answer = new int[a.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = a.get(i);
            }
            if(answer.length == 0){
                answer=new int[1];
                answer[0]=-1;
            }

            return answer;
        }
    }
}
