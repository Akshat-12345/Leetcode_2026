class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for(int i = 1; i < n ; i++){
            res = solve(res);
        }

        return res;
    }

    public String solve(String str){
        StringBuilder sb = new StringBuilder("");
        int count = 1;

        for(int i = 1; i < str.length() ; i++){
            if(str.charAt(i) == str.charAt(i-1)){
                count++;
            }else{
                sb.append(count).append(str.charAt(i-1));
                count = 1;
            }
        }

        sb.append(count).append(str.charAt(str.length() - 1));
        return sb.toString();
    }
}