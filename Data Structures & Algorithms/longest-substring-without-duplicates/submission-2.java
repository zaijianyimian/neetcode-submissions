class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int ans = 0;
        int[] arr = new int[128];
        while(r < s.length()){
            int tmp = s.charAt(r);
            arr[tmp] ++;
            while(arr[tmp] > 1 && l < r){
                int tmp1 = s.charAt(l);
                arr[tmp1] --;
                l += 1;
            }
            ans = Math.max(ans,r - l + 1);
            r ++;
        }
        return ans;
    }
}
