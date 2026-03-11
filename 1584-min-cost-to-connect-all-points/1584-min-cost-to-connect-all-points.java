import java.util.*;

class Solution {

    static class DSU{
        int[] parent;
        int[] rank;

        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++){
                parent[i] = i;
            }
        }

        int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x,int y){
            int px = find(x);
            int py = find(y);

            if(px == py) return;

            if(rank[px] > rank[py]) parent[py] = px;
            else if(rank[px] < rank[py]) parent[px] = py;
            else{
                parent[py] = px;
                rank[px]++;
            }
        }
    }

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;
        List<int[]> edges = new ArrayList<>();

        // create all edges
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){

                int dist = Math.abs(points[i][0]-points[j][0]) +
                           Math.abs(points[i][1]-points[j][1]);

                edges.add(new int[]{i,j,dist});
            }
        }

        // sort edges by weight
        edges.sort((a,b)->a[2]-b[2]);

        DSU d = new DSU(n);

        int cost = 0;

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];

            if(d.find(u) != d.find(v)){
                d.union(u,v);
                cost += w;
            }
        }

        return cost;
    }
}