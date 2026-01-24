class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        dfs(result, 1, n, k, path,visited);
        return result;
    }
    public void dfs(List<List<Integer>> result, int start, int n, int k, List<Integer> path, boolean[] visited){
        if(path.size()==k){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i<n+1; i++){
            path.add(i);
            dfs(result, i+1,n, k, path,visited);
            path.remove(path.size()-1);
                        
        }

    }
}