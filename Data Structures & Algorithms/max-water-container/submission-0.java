class Solution {
    public int maxArea(int[] heights) {
        int ans = 0;
        int l = 0;
        int r = heights.length - 1;
        while(l < r){
            int height = Math.min(heights[l],heights[r]);
            int length = r - l;
            ans = Math.max(ans,height * length);
            if(heights[l] <= heights[r]){
                l ++;
            }else{
                r --;
            }
        }
        return ans;
    }
}
