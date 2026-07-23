import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i<genres.length; i++){
            map.put(genres[i],map.getOrDefault(genres[i],0)+plays[i]);
        }
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((a,b)->map.get(b).compareTo(map.get(a)));
        int n = map.size();
        List<Integer> list = new ArrayList<>();
        for(String key : keySet){
            HashMap<Integer, Integer> an = new HashMap<>();
            for(int i = 0; i<genres.length; i++){
                if(genres[i].equals(key)){
                    an.put(i, plays[i]);
                }
            }
            List<Integer> keyset = new ArrayList<>(an.keySet());
            keyset.sort((a,b)->an.get(b).compareTo(an.get(a)));
            if(an.size()==1)list.add(keyset.get(0));
            else{
                for(int i = 0; i<2; i++){
                    list.add(keyset.get(i));
                }
            }
            
        }
        int[] answer=new int[list.size()];
        
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}