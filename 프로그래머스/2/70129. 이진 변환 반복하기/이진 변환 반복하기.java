class Solution {
    static int count = 0;
    static int ch_count = 0;
    public int[] solution(String s) {
        int[] answer = new int[2];
        remove(s);
        answer[1] = count;
        answer[0] = ch_count;
        return answer;
    }
    
    public void remove(String s){
        if(s.equals("1")){
            return;
        }
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)=='0'){
                count++;
            }
        }
        s = s.replaceAll("0","");
        int len = s.length();
        String change = String.valueOf(Integer.toBinaryString(len));
        ch_count++;
        remove(change);
        
        
    }
}