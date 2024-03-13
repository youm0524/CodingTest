package 프로그래머스.level0;

public class o_x퀴즈 {
    class Solution {
        public String[] solution(String[] quiz) {
            String[] answer = new String[quiz.length];

            for(int i = 0; i<quiz.length; i++){
                String[] st = quiz[i].split(" ");
                if(st[1].equals("-")){
                    if(Integer.parseInt(st[0]) - Integer.parseInt(st[2])
                            == Integer.parseInt(st[4])){
                        answer[i] = "O";
                    }
                    else{
                        answer[i] = "X";
                    }
                }
                else if(st[1].equals("+")){
                    if(Integer.parseInt(st[0]) + Integer.parseInt(st[2])
                            == Integer.parseInt(st[4])){
                        answer[i] = "O";
                    }
                    else{
                        answer[i] = "X";
                    }
                }
            }
            return answer;
        }
    }
}
