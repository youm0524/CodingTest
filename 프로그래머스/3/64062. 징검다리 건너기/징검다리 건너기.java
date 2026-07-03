class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        for(int i : stones){
            max = Math.max(i,max);
        }
        int l = 1;
        int r = max;
        while(l<=r){
            int mid = (l+r)/2;
            if(check(mid, stones,k)){
                answer = mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return answer;
    }
    public boolean check(int people, int[] stones, int k){
        int cnt = 0;
        for(int s : stones){
            if((s-people)<0){
                cnt++;
                if(cnt>=k)return false;
            }
            else cnt = 0;
        }
        return true;
    }
}