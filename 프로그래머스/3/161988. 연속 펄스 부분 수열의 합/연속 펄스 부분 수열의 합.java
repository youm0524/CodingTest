class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        long cur1 = 0;
        long cur2 = 0;
        
        for(int i = 0; i<sequence.length ; i++){
            int num = sequence[i];
            if(i%2==0){
                cur1 = Math.max(-num, cur1-num);
                cur2 = Math.max(num, cur2+num);
            }else{
                cur1 = Math.max(num, cur1+num);
                cur2 = Math.max(-num, cur2-num);
            }
            answer = Math.max(answer, Math.max(cur1, cur2));
        }
        
        return answer;
    }
}