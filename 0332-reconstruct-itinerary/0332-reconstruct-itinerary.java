class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> results = new LinkedList<>();
        Map<String, PriorityQueue<String>> fromTomap = new HashMap<>();

        for(List<String> ticket : tickets){
            fromTomap.putIfAbsent(ticket.get(0),new PriorityQueue());
            fromTomap.get(ticket.get(0)).add(ticket.get(1));
        }
        dfs(results, fromTomap, "JFK");
        return results;

    }

    public void dfs(List<String> results, Map<String, PriorityQueue<String>> fromTomap, String from){

        while(fromTomap.containsKey(from) && !fromTomap.get(from).isEmpty()){
            dfs(results, fromTomap, fromTomap.get(from).poll());
        }
        results.add(0,from);

    }
}