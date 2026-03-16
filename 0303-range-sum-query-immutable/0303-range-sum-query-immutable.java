class NumArray {
    int [] segTree;
    int [] nums;
    public NumArray(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        segTree = new int[4*n];
        buildTree(0,0,n-1);
    }

    public void buildTree(int i,int start, int end){
        if( start == end){
            segTree[i] = nums[start];
            return;
        }

        int mid = (start + end)/2;
        buildTree(2*i + 1,start,mid);
        buildTree(2*i + 2,mid+1,end);

        segTree[i] = segTree[2*i + 1] + segTree[2*i + 2];
    }
    
    public int sumRange(int left, int right) {
        return getSum(0,0,nums.length-1,left,right);
    }

    public int getSum(int i, int s , int e , int l , int r){
        if(e < l || s > r){
            return 0;
        }else if(s >= l && e <= r){
            return segTree[i];
        }else{
            int mid = (s + e)/2;
            int le = getSum(2*i + 1, s, mid, l ,r);
            int ri = getSum(2*i + 2, mid+1 ,e ,l ,r);
            return le + ri;
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */