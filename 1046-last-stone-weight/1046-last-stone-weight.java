class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int n = stones.length;

        for(int i = 0 ; i < n ; i++){
            pq.add(stones[i]);
        }

        while(pq.size() != 1){
            int a = pq.poll();
            int b = pq.poll();

            int res = Math.abs(a - b);
            pq.add(res);
        }

        return pq.poll();
    }
}