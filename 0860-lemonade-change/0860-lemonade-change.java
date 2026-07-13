class Solution {
    public boolean lemonadeChange(int[] bills) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = bills.length;

        if(bills[0] != 5 ){
            return false;
        }

        map.put(5,map.getOrDefault(5,0)+1);

        for(int i =1 ; i < n ; i++){
            if(bills[i] == 10){
                if(map.getOrDefault(5,0) <= 0){
                   return false;
                }
                map.put(5,map.getOrDefault(5,0)-1);
            }else if(bills[i] == 20){
                if((map.getOrDefault(5,0) >= 1 && map.getOrDefault(10,0) >= 1)){
                    map.put(5,map.getOrDefault(5,0)-1);
                    map.put(10,map.getOrDefault(10,0)-1);
                }else if(map.getOrDefault(5,0) >= 3){
                    map.put(5,map.getOrDefault(5,0)-3);
                }else{
                    return false;
                }
            }
            
            map.put(bills[i],map.getOrDefault(bills[i],0)+1);
        }
        return true;
    }
}