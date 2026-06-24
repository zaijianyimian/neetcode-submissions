class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(0,s); 
        return ans;
    }
    private void dfs(int i,String s){
        if(i >= s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int j = i;j < s.length();j ++){
            if(isPali(s,i,j)){
                path.add(s.substring(i,j + 1));
                dfs(j + 1,s);
                path.remove(path.size() - 1);
            }
        }
    }
    private boolean isPali(String s,int l,int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l ++;
            r --;
        }
        return true;
    }
}
