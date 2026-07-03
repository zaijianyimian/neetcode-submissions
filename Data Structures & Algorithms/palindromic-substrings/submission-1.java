class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        for(int i = 0;i < s.length();i ++){
            int len1 = check(s,i,i);
            int len2 = check(s,i,i + 1);
            ans += (len1 + 1) / 2 + len2 / 2;
        }
        return ans;
    }
    public int check(String s,int l,int r){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l --;
            r ++;
        }
        return r - l - 1;
    }
}
