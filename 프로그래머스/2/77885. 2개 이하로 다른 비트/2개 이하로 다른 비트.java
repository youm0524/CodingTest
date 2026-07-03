class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int index = 0;
        for(long n : numbers){
            String s = Long.toBinaryString(n);
            int idx = 0;
            for(int i = 0; i<s.length(); i++){
                if(s.charAt(i)=='0') idx = i;
            }
            if(idx == s.length()-1){
                answer[index]=n+1;
            }
            else if(idx ==0){
                s = "10"+s.substring(idx+1);
                answer[index] = Long.parseLong(s,2);
            }
            else{
                //System.out.println(s);
                s = s.substring(0,idx)+"10"+s.substring(idx+2);
                //System.out.println(s);
                answer[index] = Long.parseLong(s,2);
            }
            index++;
        }
        return answer;
    }
}