class Solution {
    public int solution(int n) {
        int answer = n+1;
        int count = Integer.bitCount(n);
        
        while(true){
            if(count==Integer.bitCount(answer)){
                break;
            }
            answer++;
        }
            // for(int i = n; i<n+100; i++){
            //     String tmp = Integer.toBinaryString(i);
            //     int cnt = 0;
            //     for(int j = 0; j<tmp.length(); j++){
            //         if(tmp.charAt(j)=='1')cnt++;
            //     }
            //     if(cnt==count && i!=n){
            //         answer = i;
            //         break;
            //     }
            // }
        
        return answer;
    }
}