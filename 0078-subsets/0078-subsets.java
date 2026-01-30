class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(result, path,nums,0);
        return result;
        
    }
    public void dfs(List<List<Integer>> result, List<Integer> path, int[] nums, int depth){
        if(!result.contains(path)){
            result.add(new ArrayList<>(path));
        }
        
        for(int i = depth; i<nums.length; i++){
            if(!path.contains(nums[i])){
                path.add(nums[i]);
                dfs(result, path, nums, i+1);
                path.remove(path.size()-1);
            }
        }
    }
}