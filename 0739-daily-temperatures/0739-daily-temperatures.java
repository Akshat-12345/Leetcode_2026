class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int n = temperatures.length;
        int [] res = new int [n];

        for(int i = n-1 ; i >= 0 ; i--){
            int val = temperatures[i];
            
            while(!s.isEmpty() && temperatures[s.peek()] <= val){
                s.pop();
            }           

            if(!s.isEmpty()){
               int calcDay = s.peek() - i;
               res[i] = calcDay;
            }else{
                res[i] = 0;
            }
            
            s.push(i);
            
        } 

        return res;
    }
}