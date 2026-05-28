class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        solve(n,n,sb,res);
        return res;
    }

    public void solve(int open, int close, StringBuilder sb ,List<String> res ){
        if(open == 0 && close == 0){
            res.add(sb.toString());
        }
        
        if(open > 0){
           sb.append("(");
           solve(open - 1, close, sb , res);
           sb.deleteCharAt(sb.length() - 1);
        }

        if(close > open){
           sb.append(")");
           solve(open, close - 1, sb , res);
           sb.deleteCharAt(sb.length() - 1);
        }
    }
}