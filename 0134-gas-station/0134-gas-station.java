class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        int total =0;
        int idx =0;
        
        for(int i = 0; i< gas.length; i++){
            int diff =  gas[i] - cost[i];
            total = total + diff;
            tank = tank + diff;

            if(tank < 0){
                tank = 0;
                idx = i + 1;
            }
        }
        if(total<0){
            return -1;
        }
        return idx;
    }
}