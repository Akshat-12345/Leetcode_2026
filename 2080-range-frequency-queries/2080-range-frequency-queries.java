class RangeFreqQuery {
    int [] nums;
    Map<Integer,Integer> [] st;

    public RangeFreqQuery(int[] arr) {
        this.nums = arr;
        int n = arr.length;
        st = new HashMap[4 * n];
        buildTree(0,0,n-1);
    }
    
    public void buildTree(int i , int s, int e){
        st[i] = new HashMap<>();
        if(s == e){
            st[i].put(nums[s],1);
            return;
        }

        int mid = (s+e)/2;

        buildTree(2*i+1,s,mid);
        buildTree(2*i+2,mid+1,e);

        Map<Integer, Integer> left = st[2 *i + 1];
        Map<Integer, Integer> right = st[2 * i + 2];

        for(int key : left.keySet()){
            st[i].put(key,left.get(key));
        }

        for (int key : right.keySet()) {
            st[i].put(key, st[i].getOrDefault(key, 0) + right.get(key));
        }
    }

    public int query(int left, int right, int value) {
        return getElement(0 , 0 , nums.length - 1, left, right, value);
    }

    public int getElement(int i , int s, int e, int l , int r, int val){
        if(e < l || s > r){
            return 0;
        }else if( s >= l && e <= r){
            return st[i].getOrDefault(val,0);
        }else{
            int mid = (s+e)/2;
            int li = getElement(2*i+1,s,mid,l,r,val);
            int ri = getElement(2*i+2,mid+1,e,l,r,val);

            return li + ri;
        }
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */