import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files,(a,b)->{
            int aIdx = 0;
            int bIdx = 0;
            // head 끝 찾기
            while (aIdx < a.length() && !Character.isDigit(a.charAt(aIdx))){
                aIdx++;
            }
            while(bIdx<b.length() && !Character.isDigit(b.charAt(bIdx))){
                bIdx++;
            }
            String aHead = a.substring(0,aIdx).toLowerCase();
            String bHead = b.substring(0,bIdx).toLowerCase();
            int headCompare = aHead.compareTo(bHead);
            if (headCompare != 0) {
                return headCompare;
            }
            
            int aNumEnd = aIdx;
            int bNumEnd = bIdx;
            int aCount = 0;
            int bCount = 0;
            
            while (aNumEnd < a.length() && Character.isDigit(a.charAt(aNumEnd)) && aCount < 5) {
                aNumEnd++;
                aCount++;
            }
            while (bNumEnd < b.length() && Character.isDigit(b.charAt(bNumEnd)) && bCount < 5) {
                bNumEnd++;
                bCount++;
            }
            
            int aNumber = Integer.parseInt(a.substring(aIdx, aNumEnd));
            int bNumber = Integer.parseInt(b.substring(bIdx, bNumEnd));
            
            // 2. number 비교
            return aNumber - bNumber;
        });
        
        return files;
        
    }
}