class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        
        for(int i = 0; i<arr.length; i++){
            String now = arr[i];
            if(now.length()==0)answer+=" ";
            else{
                answer+=now.substring(0,1).toUpperCase();
                answer+=now.substring(1).toLowerCase();
                answer+=" ";
            }
            
        }
        if(s.substring(s.length()-1, s.length()).equals(" ")){
    		return answer;
    	}
    	
    	// 맨 마지막 " " 제거하고 answer 반환
        return answer.substring(0, answer.length()-1);
        
 
    }
}