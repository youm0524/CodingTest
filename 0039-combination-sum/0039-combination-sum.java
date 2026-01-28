class Solution {
    static int depth = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(result, path, candidates,target,0,0);
        return result;
    }
    public void dfs(List<List<Integer>> result, List<Integer> path, int[] candidates, int target, int idx, int sum){
        if(sum>target)return;
        if(sum==target){
            result.add(new ArrayList<>(path));
        }
        for(int i=idx; i<candidates.length; i++){
            path.add(candidates[i]);
            dfs(result, path, candidates, target, i, sum+candidates[i]);
            path.remove(path.size()-1);
        }
        

    }
}