class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int i = 0;
        solve(i , nums, new ArrayList<>() , list);
        return list;
    }

    public void solve(int i , int [] arr, List<Integer> l , List<List<Integer>> list){
        int n = arr.length;
        if( i == n){
            list.add(new ArrayList<>(l));
            return;
        }

        l.add(arr[i]);
        solve(i+1,arr,l, list);
        l.remove(l.size()-1);

        solve(i+1,arr,l, list);
    }
}