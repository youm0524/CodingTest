class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] server = new int[players.length];

        for(int i = 0; i<=23; i++){
            if(players[i]/m>server[i]){
                int need = players[i]/m-server[i];
                for(int j = i; j<Math.min(i+k,players.length); j++){
                    server[j] += need;
                }
                answer+=need;
            }
        }
        return answer;
    }
}