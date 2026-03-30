class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int l = 0;
        int r = 0;
        int sum = sequence[l];
        int len = 1000000000;
        while(l<sequence.length){
            
            //System.out.println(sum);
            if(sum==k){
                if((r-l)<len){
                    len = r-l;
                    answer[0] = l;
                    answer[1] = r;
                }
                sum-=sequence[l];
                l++;
            }
            else if(sum<k){
                if (r == sequence.length - 1) break;
                r++;
                sum += sequence[r];
            }
            else if(sum>k){
                sum-=sequence[l];
                l++;
            }
        }
        return answer;
    }
}