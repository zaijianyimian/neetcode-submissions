class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int ans = 0;
        for(int c : set){
            if(set.contains(c - 1)){
                continue;
            }
            int tmp = 1;
            while(set.contains(c + 1)){
                tmp += 1;
                c += 1;
            }
            ans = Math.max(tmp,ans);
        }
        return ans;
    }
}
