import java.util.*;
class Solution {
    public Map<String, Integer> map = new HashMap<>();
    public Map<String, String> parent = new HashMap<>();
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        
        for (int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
        }
        for(String enr : enroll){
            map.put(enr,0);
        }
        for(int i = 0; i<seller.length; i++){
            String sell = seller[i];
            int money = amount[i] * 100;
            update(sell, money);
        }
        for(int i = 0; i<enroll.length; i++){
            answer[i] = map.get(enroll[i]);
        }
        return answer;
    }
    public void update(String sell, int money){
        if (sell.equals("-") || money < 1) {
            return;
        }
        int div = money/10;
        int mine = money-div;
        map.put(sell, map.get(sell) + mine);

        if (div >= 1) {
            update(parent.get(sell), div);
        }

    }
}