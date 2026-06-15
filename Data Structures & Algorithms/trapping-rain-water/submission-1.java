class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] right = new int[n];
        for(int i = n - 2;i >= 0;i --){
            right[i] = Math.max(height[i + 1],right[i + 1]);

        }
        int lef = 0;
        int ans = 0;
        for (int i = 0;i < n;i ++){
            int tmp = Math.min(lef,right[i]);
            int water = tmp - height[i];
            if(tmp < height[i]){
                water = 0;
            }
            lef = Math.max(lef,height[i]);
            ans += water;
        }
        return ans;
    }
}
