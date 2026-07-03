import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(String s : operations){
            String[] op = s.split(" ");
            if(op[0].equals("I")){
                dq.add(Integer.valueOf(op[1]));
                dq = add(dq);
            }
            else if(op[0].equals("D")){
                if(dq.isEmpty())continue;
                if(op[1].equals("1")){
                   dq.removeLast();
                }
                else {
                    dq.remove();
                }
            }
        }
        if(dq.isEmpty())return new int[]{0,0};
        if(dq.size()==1){
            int n = dq.remove();
            return new int[]{n,n};
        }
        answer[0] = dq.removeLast();
        answer[1] = dq.remove();
        return answer;
    }
    public Deque<Integer> add(Deque<Integer> deque){
        List<Integer> list = new ArrayList<>(deque);
        Collections.sort(list);
        Deque<Integer> dq = new ArrayDeque<>();
        for(int j:list){
            dq.add(j);
        }
        return dq;
    }
}