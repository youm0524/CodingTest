class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int width = 0;
        int height = 0;
        for(int i = 1; i<=yellow; i++){
            int x = 0;
            int y = 0;
            if(yellow%i==0){
                x = i;
                y = yellow/i;
            }
            if((2*(x+2) + 2*(y))==brown && x>=y){
                width = x+2;
                height = y+2;
                break;
            }
        }
        answer[0] = width;
        answer[1] = height;
        return answer;
    }
}