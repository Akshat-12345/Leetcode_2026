class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s = 1;
        int e = 0;
        int n = piles.length;

        for(int i = 0 ; i  < n ; i++){
            e = Math.max(e,piles[i]);
        }

        int ans = 0;
        while(s <= e){
            int m = s + (e-s)/2;

            if(isPossible(m , piles , h)){
                ans = m;
                e = m -1;
            }else{
                s = m + 1;
            }

        }
        return ans;
    }

    public boolean isPossible(int curr , int [] piles, int h){
        long hours = 0;
        
        for(int i = 0 ; i < piles.length ; i++){
            hours += Math.ceil((double)piles[i]/curr);
            if(hours > h){
               return false;
            }
        }

        return true;
    }
}