class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();

        for(int i = 0 ; i < n ; i++){
            String str = rotate(s,i);
            if(str.equals(goal)){
                return true;
            }
        }
        return false;
    }

    public String rotate (String s , int k){
        String str = "";
        int n = s.length();
        char [] arr = s.toCharArray();
        spin(arr,0,k);
        spin(arr,k+1,n-1);
        spin(arr,0,n-1);
        
        for(int i = 0 ; i < arr.length ; i++){
            str = str + arr[i];
        }

        return str;
    }

    public void spin(char [] arr, int s, int e){

        while(s < e){
           char temp = arr[s];
           arr[s] = arr[e];
           arr[e] = temp;

           s++;
           e--;
        }
    }
}