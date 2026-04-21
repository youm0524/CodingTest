import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String s : skill_trees){
            List<Character> list = new ArrayList<>();
            boolean valid = false;
            for(int i=0; i<s.length(); i++){
                if(skill.contains(String.valueOf(s.charAt(i)))){
                    int idx = 0;
                    for(int j = 0; j<skill.length(); j++){
                        if(skill.charAt(j)==s.charAt(i)){
                            idx = j;
                        }
                    }
                    if(idx!=0){
                        char c = skill.charAt(idx-1);
                        System.out.println(c);
                        if(!list.contains(c)){
                            //System.out.println("out");
                            valid = true;
                            break;
                        }
                    }
                    list.add(s.charAt(i));
                    //System.out.println("aa");
                }
                
            }
            if(!valid)answer++;
            //System.out.println(answer);
        }
        return answer;
    }
}