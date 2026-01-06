import java.util.*;
class Solution {
    private static Set<Integer> set = new HashSet<>();
    private static boolean[] visited;
    public int solution(String numbers) {
        int cnt = 0;
        int answer =0;
        visited = new boolean[numbers.length()];
        dfs("",numbers,cnt);
        
        for(int i : set){
            if(isPrime(i))answer++;
        }
        return answer;
    }
    
    public void dfs(String start, String numbers, int cnt){
        if(cnt>numbers.length())return;
       if(!start.equals("")){
            set.add(Integer.parseInt(start)); // 이번 조합 숫자 저장
        }
        for(int i = 0; i < numbers.length(); i++){
            if(!visited[i]){
            visited[i] = true;
            dfs(start + numbers.charAt(i), numbers,cnt+1); // 재귀 호출
            visited[i] = false; // 백트래킹
            }
        }

   
    }
    
    static boolean isPrime(int num) {
        if (num < 2) return false;           // 0과 1은 소수가 아님
        for (int i = 2; i <= Math.sqrt(num); i++) { // 2부터 √num까지 확인
            if (num % i == 0) return false;  // 나누어 떨어지면 소수가 아님
        }
    return true;                         // 나누어 떨어지는 수가 없으면 소수
}
}