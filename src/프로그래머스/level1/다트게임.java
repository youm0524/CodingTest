package 프로그래머스.level1;

public class 다트게임 {
    class Solution {
        public int solution(String dartResult) {
            int[] dart = new int[3];//3개 다트 점수
            int index = 0;//다트 인덱스
            String str = "";//받아올 숫자

            for(int i = 0; i<dartResult.length();i++){
                char c = dartResult.charAt(i);

                if( c>='0' && c<='9'){//숫자일때 str에 넣기
                    str += c;
                }

                //보너스
                else if(c=='S' || c=='D' || c=='T'){
                    int num = Integer.parseInt(str);//다트 점수
                    str = "";
                    if(c=='S'){
                        dart[index] = (int)Math.pow(num,1);
                    }
                    else if(c=='D'){
                        dart[index] = (int)Math.pow(num,2);
                    }
                    else if(c=='T'){
                        dart[index] = (int)Math.pow(num,3);
                    }
                    index++;
                }

                //옵션
                else{
                    if(c == '*'){
                        dart[index-1] *= 2;
                        if(index-2>=0) dart[index-2] *= 2;
                    }
                    else{
                        dart[index-1] *= -1;
                    }
                }

            }

            int answer = dart[0] + dart[1] + dart[2];
            return answer;
        }
    }
}
