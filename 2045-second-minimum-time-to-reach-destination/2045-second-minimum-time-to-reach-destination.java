class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) 
    {
       ArrayList<Edge>[] graph=new ArrayList[n+1];
        createGraph(graph,edges);
         return  (Djiktra(graph,1,change,time));
    }

    static class Pair implements Comparable<Pair>
    {
        int node;
        int dist;


        Pair(int n, int d)
        {
            this.node=n;
            this.dist=d;
        }


        @Override
        public int compareTo(Pair o) {
            return this.dist-o.dist;
        }
    }


    static class Edge {
        int src;
        int dest;

        Edge(int s,int d)
        {
            this.src=s;
            this.dest=d;

        }
    }


    public static void createGraph(ArrayList<Edge>[] graph,int[][] edge)
    {

        for(int i=0;i<graph.length;i++)
        {
            graph[i]=new ArrayList<Edge>();
        }
        for(int i=0;i<edge.length;i++)
        {
            int u=edge[i][0];
            int v=edge[i][1];
            graph[u].add(new Edge(u,v));
            graph[v].add(new Edge(v,u));
        }
    }
    

     public static int Djiktra(ArrayList<Edge>[] graph, int src, int change, int time) {
    int n = graph.length;
    int[] dist1 = new int[n];
    int[] dist2 = new int[n];

    Arrays.fill(dist2, Integer.MAX_VALUE);
    Arrays.fill(dist1, Integer.MAX_VALUE);
    dist1[src] = 0;

    PriorityQueue<Pair> pq = new PriorityQueue<>();
    pq.add(new Pair(src, 0));

    while (!pq.isEmpty()) {
        Pair p = pq.remove();
        int currnode = p.node;
        int prevtime = p.dist;

        for (Edge e : graph[currnode]) {
            int v = e.dest;
           int x = prevtime / change;
           int remainder = prevtime % change;
           int currtime = prevtime+time;

// Adjust current time for the red light
          if (x % 2 == 1) {
           currtime = prevtime+ change - remainder;
           currtime+=time;
            }

            if (currtime < dist1[v]) {
                if (dist1[v] != Integer.MAX_VALUE) {
                    dist2[v] = dist1[v];
                }
                dist1[v] = currtime;
                pq.add(new Pair(v, dist1[v]));
            } else if (currtime > dist1[v] && currtime < dist2[v]) {
                dist2[v] = currtime;
                pq.add(new Pair(v, dist2[v]));
            }
        }
    }

    return dist2[n - 1];
}
}
