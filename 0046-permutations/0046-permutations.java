class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(result,nums,path);
        return result;

    }
    public void dfs(List<List<Integer>> result, int[] nums, List<Integer> path){
        if(path.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i : nums){
            if(!path.contains(i)){
                path.add(i);
                dfs(result,nums,path);
                path.remove(path.size()-1);
            }
        }
    }
}