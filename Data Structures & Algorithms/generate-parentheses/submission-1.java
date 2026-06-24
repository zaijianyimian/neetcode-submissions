class Solution {
    List<String> ans = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        backtrack(0,0,n);
        return ans;
    }
    public void backtrack(int left,int right,int n){
        if(left == right && right == n){
            ans.add(path.toString());
        }
        if(left < n){
            path.append("(");
            backtrack(left + 1,right,n);
            path.deleteCharAt(path.length() - 1);
        }

        if(right < left){
            path.append(")");
            backtrack(left,right + 1,n);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
