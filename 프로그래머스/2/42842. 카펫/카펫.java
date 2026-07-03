class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        for(int i = 1; i<total; i++){
            int w = 0;
            int h = 0;
            if(total%i==0){
                if(total/i>=i){
                    w = total/i;
                    h = i;
                }else{
                    w = i;
                    h = total/i;
                }
                if((w-2)*(h-2) == yellow){
                    answer[0] = w;
                    answer[1] = h;
                    break;
                }
            }
        }
        return answer;
    }
}