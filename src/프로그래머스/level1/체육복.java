package 프로그래머스.level1;
import java.util.Arrays;
public class 체육복 {



    class Solution {
        public int solution(int n, int[] lost, int[] reserve) {

            int answer = n-lost.length;
            Arrays.sort(lost);
            Arrays.sort(reserve);
            for(int i = 0; i< lost.length; i++){
                for(int j = 0; j< reserve.length; j++){
                    if(lost[i] == reserve[j]){
                        answer++;
                        reserve[j] = -1;
                        lost[i] = -1;
                        break;
                    }
                }
            }
            // for(int i : reserve){
            //     System.out.println(i);
            // }
            for(int i : lost){
                for(int j = 0; j < reserve.length; j++){
                    if((i+1) == reserve[j] || (i-1) == reserve[j]){
                        //System.out.println(i);
                        //System.out.println(reserve[j]);
                        answer++;
                        reserve[j] = -1;


                        break;
                    }

                }
            }





            return answer;
        }
    }

}
