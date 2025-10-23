import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> maps = new HashMap<>();
        //count
        for(int i = 0; i<genres.length; i++){
            String key = genres[i];
            Integer count = plays[i];
            maps.put(key,maps.getOrDefault(key,0)+count);
        }
        //장르순위 오름차순정렬
        List<String> keySets = new ArrayList<>(maps.keySet());
        keySets.sort((o1,o2)-> maps.get(o2).compareTo(maps.get(o1)));
        int index = 0;
        List<Integer> result = new ArrayList<>();

        //정렬값 순회하면서 index, plays 값 구함
        for(String s : keySets){
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i = 0; i<genres.length;i++){
                if(s.equals(genres[i])){
                    map.put(i,plays[i]);
                }
            }
            List<Integer> keySet = new ArrayList<>(map.keySet());
            keySet.sort((o1, o2) -> {
                int cmp = map.get(o2).compareTo(map.get(o1));
                if (cmp == 0) return o1 - o2; // 재생 수 같으면 인덱스 오름차순
                return cmp;
            });

            int count = 0;
            for(Integer key : keySet){
                result.add(key);
                count++;
                if(count>=2)break;
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}