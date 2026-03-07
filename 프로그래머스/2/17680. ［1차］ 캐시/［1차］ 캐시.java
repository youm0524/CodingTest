import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        int size = 0;
        if(cacheSize == 0){
            return cities.length*5;
        }
        for(String city : cities){
            String s = city.toLowerCase();
            if(!queue.contains(s)){
                if(queue.size()==cacheSize){
                    queue.poll();
                    queue.add(s);
                    answer+=5;
                }
                else{
                    queue.add(s);
                    answer+=5;
                    size++;
                }
            }
            else{
                queue.remove(s);
                queue.add(s);
                answer+=1;
            }
        }
        return answer;
    }
}