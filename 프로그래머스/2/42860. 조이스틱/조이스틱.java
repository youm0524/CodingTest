import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length()-1;
        for(int i = 0; i<name.length(); i++){
            int num = name.charAt(i)-'A';
            answer += Math.min(num, 26 - num);
            
            int next = i+1;
            while(next<name.length() && name.charAt(next)=='A'){
                next++;
            }
            move = Math.min(move, i*2+name.length()-next);
            move = Math.min(move,(name.length() - next) * 2 + i);
            
        }
        return answer+move;
    }
}