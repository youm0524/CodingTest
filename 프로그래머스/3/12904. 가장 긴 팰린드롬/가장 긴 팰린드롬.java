class Solution
{
    public int solution(String s)
    {
        int answer = 1;
    
        for(int i = 0; i<s.length(); i++){
            int flag = 1;
            int left = 0;
            int right = 0;
            if(i-1>=0 && i+1<s.length()){
                left = i-1;
                right = i+1;
                while(left >= 0 && right < s.length()){
                    if(s.charAt(left) == s.charAt(right)){
                        answer = Math.max(answer, right-left+1);
                        left--;
                        right++;
                    }else{
                        break;
                    }
                }
            }
            if(i+1<s.length()){
                left = i;
                right = i+1;
                while(left >= 0 && right < s.length()){
                    if(s.charAt(left) == s.charAt(right)){
                        answer = Math.max(answer, right-left+1);
                        left--;
                        right++;
                    }else{
                        break;
                    }
                }
            }
        }

        return answer;
    }
}