package 프로그래머스.level1;

public class 둘만의암호 {
    class Solution {
        public String solution(String s, String skip, int index) {
            String answer = "";

            for(int i = 0; i<s.length(); i++){
                //한 문자씩 받아옴
                char a = s.charAt(i);
                //인덱스 만큼 돌면서 skip에 있는지 비교하기
                for(int j = 0; j<index; j++){
                    //받아온 문자 다음 문자
                    a+=1;
                    //z를 넘어갈 경우
                    if(a>'z')
                        a='a';
                    //skip에 포함되면 -1, 반복문 더 돌 수 있게
                    if(skip.contains(String.valueOf(a)))
                        j--;
                }
                //마지막에 답에 더하기
                answer+=a;
            }
            return answer;
        }
    }
}
