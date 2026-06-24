class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtrack(nums,0);
        return ans;
    }
    public void backtrack(int[] nums,int start){
        ans.add(new ArrayList<>(path));
        for(int i = start;i < nums.length;i++){
            if(i > start && nums[i] == nums[i - 1]){
                used[i] = true;
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtrack(nums,i + 1);
            used[i] = false;
            path.removeLast();
        }
    }
}
