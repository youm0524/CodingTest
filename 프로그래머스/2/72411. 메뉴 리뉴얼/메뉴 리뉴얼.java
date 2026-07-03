import java.util.*;
class Solution {
    Map<String, Integer> map = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();
        for(int cour : course){
            int max = 0;
            map.clear();
            for(String order : orders){
                char[] array = order.toCharArray();
                Arrays.sort(array);
                com(array, cour, 0 ,"");
            }
            for(String key : map.keySet()){
                int cnt = map.get(key);
                if(cnt>=2 && cnt>=max){
                    if(cnt>max){
                        result.removeIf(s -> s.length() == cour);
                        max = cnt;
                    }
                    result.add(key);
                }
                
            }
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
    public void com(char[] array, int cour, int idx, String menu){
    
        if(menu.length() == cour){
            map.put(menu, map.getOrDefault(menu,0)+1);
            return;
        }

        for(int i = idx; i<array.length; i++){
            com(array, cour, i+1, menu + array[i]);
        }
    }
}