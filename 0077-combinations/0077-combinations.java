class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        dfs(result, n, k, path, 0,visited);
        return result;
    }
    public void dfs(List<List<Integer>> result, int n, int k, List<Integer> path, int count,boolean[] visited){
        if(count==k){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = 1; i<n+1; i++){
            if(!visited[i]){
            path.add(i);
            visited[i] = true;
            dfs(result, i, k, path, count+1,visited);
            path.remove(path.size()-1);
            visited[i] = false;
            }            
        }

    }
}