import java.util.*;

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        int maxEdgeWeight = 0;
        for (int[] e : edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            maxEdgeWeight = Math.max(maxEdgeWeight, e[2]);
        }
        
        // Binary search for the maximum possible bottleneck
        int left = 0;
        int right = maxEdgeWeight;
        int ans = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // If we can reach the end with a bottleneck of 'mid' and cost <= k
            if (isValid(mid, n, adj, online, k)) {
                ans = mid;         // Record the valid answer
                left = mid + 1;    // Try to be greedier and find a higher bottleneck
            } else {
                right = mid - 1;   // 'mid' is too high, scale it back
            }
        }
        
        return ans;
    }
    
    // Standard Dijkstra to find if a path exists under cost 'k'
    private boolean isValid(int minWeightRequired, int n, List<List<int[]>> adj, boolean[] online, long k) {
        long[] minDist = new long[n];
        Arrays.fill(minDist, Long.MAX_VALUE);
        minDist[0] = 0;
        
        // PQ strictly sorts by the lowest path sum
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.add(new long[]{0, 0});
        
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int u = (int) curr[0];
            long currentSum = curr[1];
            
            // Optimization: If we found a worse path to a visited node, skip it
            if (currentSum > minDist[u]) continue;
            
            // If we reached the end within the budget
            if (u == n - 1) return currentSum <= k;
            
            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int weight = edge[1];
                
                // CRITICAL: Ignore offline nodes AND edges that don't meet our bottleneck guess
                if (!online[v] || weight < minWeightRequired) {
                    continue;
                }
                
                long newSum = currentSum + weight;
                
                if (newSum < minDist[v]) {
                    minDist[v] = newSum;
                    pq.add(new long[]{v, newSum});
                }
            }
        }
        
        // If we exhaust the queue without returning true, the destination is unreachable 
        // with this bottleneck guess, or the cost was strictly > k.
        return minDist[n - 1] <= k;
    }
}