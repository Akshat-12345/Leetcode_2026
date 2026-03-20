class Solution {
    Map<String, PriorityQueue<String>> adj = new HashMap<>();
    LinkedList<String> ans = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        
        // Build graph
        for (List<String> ticket : tickets) {
            adj.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>())
               .add(ticket.get(1));
        }

        dfs("JFK");
        return ans;
    }

    public void dfs(String src) {
        PriorityQueue<String> pq = adj.get(src);

        while (pq != null && !pq.isEmpty()) {
            String next = pq.poll(); // smallest lexicographic
            dfs(next);
        }

        ans.addFirst(src); // reverse add
    }
}