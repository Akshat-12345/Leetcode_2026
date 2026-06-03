class Solution {
    public String simplifyPath(String path) {
        String [] arr = path.split("/");
        int n = arr.length;
        Stack <String> s = new Stack<>();

        for(int i = 0 ; i< n ; i++){
            String str = arr[i];
            if(str.equals(".") || str.equals("")){
                continue;
            }else if(str.equals("..")){
                if(!s.isEmpty()){
                    s.pop();
                }
            }else{
                s.push(str);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (String dir : s) {
            sb.append("/").append(dir);
        }
        
        return sb.length() == 0 ? "/" : sb.toString();
    }
}