class Solution {
    class SegmentTree{
        int [] st;
        int [] arr;

        public SegmentTree(int [] arr , int n){
            this.arr = arr;
            st = new int[4*n];
            buildTree(0,0,n-1);
        }

        public void buildTree(int i , int s, int e){
            if(s == e){
                st[i] = arr[s];
                return;
            }

            int mid = (s + e)/2;
            buildTree(2*i+1, s, mid);
            buildTree(2*i+2, mid+1, e);

            st[i] = st[2*i+1] + st[2*i + 2];
        }

    }
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;

        int [] arr = new int[n];
        int [] vis = new int [n];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j  <n ; j++){
                if(fruits[i] <= baskets[j] && vis[j] == 0){
                    arr[i] = 1;
                    vis[j] = 1;
                    break;
                }
            }
        }

        SegmentTree s = new SegmentTree(arr,n);

        return n - s.st[0];
    }
}