import java.util.*;

class Solution {

    static class Pair {
        int node;
        long dist;

        Pair(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {

        // Graph
        List<List<Pair>> graph = new ArrayList<>();
        List<List<Pair>> revGraph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            revGraph.add(new ArrayList<>());
        }

        // Build graph + reverse graph
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            graph.get(u).add(new Pair(v, w));
            revGraph.get(v).add(new Pair(u, w)); // reverse
        }

        // 3 Dijkstra runs
        long[] d1 = dijkstra(src1, graph, n);
        long[] d2 = dijkstra(src2, graph, n);
        long[] d3 = dijkstra(dest, revGraph, n); // reverse graph

        long INF = Long.MAX_VALUE;
        long ans = INF;

        for (int i = 0; i < n; i++) {
            if (d1[i] == INF || d2[i] == INF || d3[i] == INF) continue;

            ans = Math.min(ans, d1[i] + d2[i] + d3[i]);
        }

        return ans == INF ? -1 : ans;
    }

    private long[] dijkstra(int src, List<List<Pair>> graph, int n) {

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

        dist[src] = 0;
        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int node = cur.node;
            long d = cur.dist;

            if (d > dist[node]) continue;

            for (Pair nei : graph.get(node)) {
                int next = nei.node;
                long newDist = d + nei.dist;

                if (newDist < dist[next]) {
                    dist[next] = newDist;
                    pq.offer(new Pair(next, newDist));
                }
            }
        }

        return dist;
    }
}