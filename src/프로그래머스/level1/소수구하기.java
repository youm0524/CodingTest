package 프로그래머스.level1;

public class 소수구하기 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            int[] num = new int[n+1];

            //2~n까지 배열에 넣기
            for(int i = 2; i<=n; i++){
                num[i]=i;
            }

            for(int i = 2; i<= n ; i++){
                //0이면 패스
                if(num[i] == 0) continue;
                //2,3,5,7순으로 배수 다 0으로 만들기
                for(int j = 2*i; j<= n; j+=i){
                    num[j] = 0;
                }
                //0 아니면 ++
                if(num[i] != 0)
                    answer++;
            }


            return answer;
        }
    }
}
