class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> finishToTakemap = new HashMap<>();

        for(int[] pre : prerequisites){
            finishToTakemap.putIfAbsent(pre[0], new ArrayList<>());
            finishToTakemap.get(pre[0]).add(pre[1]);
        }

        List<Integer> takes = new ArrayList<>();
        //시간 초과 방지
        List<Integer> taken = new ArrayList<>();
        for(int key : finishToTakemap.keySet()){
            if(!dfs(finishToTakemap, key,taken, takes)){
                return false;
            }
        }
        return true;

    }

    public boolean dfs(Map<Integer, List<Integer>> map,int key, List<Integer> taken, List<Integer> takes){
        if(takes.contains(key)){
            return false;
        }
        if(taken.contains(key))return true;

        if(map.containsKey(key)){
            takes.add(key);
            for(int take : map.get(key)){
                if(!dfs(map, take, taken, takes))return false;
            }
            takes.remove((Integer) key);
            taken.add(key);
        }
        return true;
    }
}