class Solution {
    public String longestPalindrome(String s) {
        int ans = 0;
        int start = 0;
        int end = 0;
        int n = s.length();
        for(int i = 0;i < n;i ++){
            int len1 = check(s,i,i);
            int len2 = check(s,i,i + 1);
            int len = Math.max(len1,len2);
            if(len > ans){
                ans = len;
                start = i  - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start,end + 1);
    }
    public int check(String s,int left,int right){
        while(left >= 0  && right < s.length() && s.charAt(left) == s.charAt(right)){
            left --;
            right ++;
        }
        return right - left - 1;
    }
}
