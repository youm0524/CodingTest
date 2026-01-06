class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i<=n; i++){
            int sum = 0;
            for(int j = i; j<=n; j++){
            sum+=j;
            //같으면 
            if(sum==n){
                answer++;
                break;
            }
            //sum 이 더 커지면 break
            else if(sum>n){
                break;
            }
            }
        }
        return answer;
    }
}