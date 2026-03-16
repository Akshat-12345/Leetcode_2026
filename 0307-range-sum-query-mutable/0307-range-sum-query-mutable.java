class NumArray {
    int [] segTree;
    int [] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        segTree = new int[4*n];
        
        buildTree(0,0,n-1);
    }
    
    public void update(int index, int val) {
        updateVal(0,0,nums.length-1,index,val);
    }

    public void updateVal(int i , int s, int e , int idx , int val){
        if(s == e){
            segTree[i] = val;
            return;
        }

        int mid = (s+e)/2;
        if(idx <= mid){
            updateVal(2*i+1,s,mid,idx,val);
        }else{
            updateVal(2*i + 2,mid+1,e,idx,val);
        }

        segTree[i] = segTree[2*i+1] + segTree[2*i+2];
    }
    
    public void buildTree(int i , int start, int end){
        if(start == end){
            segTree[i] = nums[start];
            return;
        }

        int mid = (start + end)/2;

        buildTree(2*i + 1, start, mid);
        buildTree(2*i + 2, mid+1, end);

        segTree[i] = segTree[2*i + 1] + segTree[2*i + 2];
    }

    public int sumRange(int left, int right) {
        return getSum(0,0,nums.length-1,left,right);
    }

    public int getSum(int i , int s, int e, int l , int r){
        if(e < l || s > r){
            return 0;
        }else if(s >= l && e <= r){
            return segTree[i];
        }else{
            int mid = (s+e)/2;
            int li = getSum(2*i+1,s,mid,l,r);
            int ri = getSum(2*i+2,mid+1,e,l,r);

            return li + ri;
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */