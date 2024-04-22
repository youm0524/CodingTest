package 프로그래머스.level1;

public class 옹알이2 {
    class Solution {
        public int solution(String[] babbling) {
            int answer = 0;
            int tmp = -1;
            String[] bab = {"aya","ye","woo","ma"};
            for(String s : babbling){
                for(String b : bab){
                    if(s.contains("ayaaya")||s.contains("yeye")||
                            s.contains("woowoo")||s.contains("mama"))
                        break;
                    if(s.contains(b)){
                        s = s.replace(b," ");
                    }
                }
                s = s.replaceAll(" ","");
                if(s.equals("")) answer++;
            }


            return answer;
        }
    }
}
