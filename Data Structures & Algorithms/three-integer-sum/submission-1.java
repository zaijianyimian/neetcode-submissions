class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i < nums.length - 2;i ++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r){
                int threeSum = nums[i] + nums[l] + nums[r];
                if(threeSum < 0){
                    l ++;
                }else if (threeSum > 0){
                    r --;
                }else{
                    List<Integer> arr = Arrays.asList(nums[i], nums[l], nums[r]);
                    ans.add(arr);
                    l ++;
                    while(l < r && nums[l] == nums[l - 1]){
                        l ++;
                    }
                }

            }
        }
        return ans;
    }
}
