class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int cnt = 0;
        int start = 0;
        while(answer.length()!=t){
            String ch = Integer.toString(start,n).toUpperCase();
            for(int i = 0; i<ch.length(); i++){
                cnt++;
                if(cnt==p){
                    if(answer.length()>=t){
                        break;
                    }
                    answer+=ch.charAt(i);
                    p+=m;
                    //System.out.println("p: "+p+"cnt: "+cnt+"answer: "+answer.length());
                }
            }
            start++;
            
        }
        return answer;
    }
}