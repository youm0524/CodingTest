class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int sum = sequence[0];
        while(left<sequence.length){
            if(sum==k){
                if((right-left+1)<min){
                    min = right - left + 1;
                    answer[0] = left;
                    answer[1] = right;
                }
                sum -= sequence[left];
                left++;

            }
            else if(sum>k){
                sum-=sequence[left];
                left++;
            }
            else{
                if(right<sequence.length-1){
                    right++;
                    sum+=sequence[right];
                }else break;
            }
        }
        return answer;
    }
}