package 프로그래머스.level1;

public class 대충만든자판 {
    class Solution {
        public int[] solution(String[] keymap, String[] targets) {

            int[] answer = new int[targets.length];
            int idx = 0;

            for(String str : targets){ //"ABCD"
                int sum = 0;
                char[] tar = str.toCharArray(); //A,B,C,D

                for(int i = 0; i<tar.length;i++){
                    int min = 101;
                    for(String st : keymap){ //"ABACD","BECFD"
                        char[] key = st.toCharArray(); //A.B.A.C.D
                        for(int j = 0; j<key.length; j++){
                            if(j>min) break;
                            if(tar[i]==key[j]){
                                if(j<min){
                                    min = j+1;
                                }
                            }
                        }
                    }
                    if(min == 101){
                        sum = -1;
                        break;
                    }
                    sum += min;

                }
                if(sum == -1){
                    answer[idx] = -1;
                    idx++;
                    continue;
                }
                answer[idx] = sum;
                idx++;
            }

            return answer;
        }
    }
}
