import java.util.*;
class Solution {
    public static int n;
    public static int[][] q;
    public static int[] ans;
    public static int answer;
    public int solution(int n, int[][] q, int[] ans) {
        Solution.n = n;
        Solution.q = q;
        Solution.ans = ans;
        answer = 0; 
        List<Integer> list = new ArrayList<>();
        dfs(1,list);
        return answer;
    }
    public void dfs(int start, List<Integer> list){
        if(list.size()==5){
            //정답 확인 여부
            boolean check = true;
            for(int i = 0; i<q.length; i++){
                int[] tmp = q[i];
                int cnt = 0;
                for(int j = 0; j<5; j++){
                    if(list.contains(tmp[j]))cnt++;
                }
                if (cnt != ans[i]) {
                    check = false;
                    break;
                }
            }
            //System.out.println(check);
            if(check)answer++;
            return;
        }
        for(int i = start; i<=n; i++){
            list.add(i);
            dfs(i+1,list);
            list.remove(list.size()-1);
        }
    }
}