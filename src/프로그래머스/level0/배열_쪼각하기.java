package 프로그래머스.level0;

public class 배열_쪼각하기 {
    class Solution {
        public int[] solution(int[] arr, int[] query) {
            int start = 0;
            int end = arr.length-1;

            for(int i=0;i<query.length;i++){
                if(i%2==0){
                    end = query[i]+start;
                }
                else{
                    start +=query[i];
                }
            }

            int[] answer = new int[end-start+1];
            int temp=0;
            for(int i = start;i<end+1;i++){
                answer[temp] = arr[i];
                temp++;
            }
            return answer;
        }
    }
}
