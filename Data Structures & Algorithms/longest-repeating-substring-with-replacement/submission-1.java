class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int ans = 0;
        int maxFreq = 0;
        Map<Character,Integer> map = new HashMap<>();
        while(r < s.length()){
            char c = s.charAt(r);
            map.put(c,map.getOrDefault(c,0) + 1);
            maxFreq = Math.max(maxFreq,map.get(c));
            while(r - l + 1 - maxFreq > k){
                char tmp  = s.charAt(l);
                map.put(tmp,map.get(tmp) - 1);
                l++;
            }
            ans = Math.max(ans,r - l + 1);
            r += 1;
        }
        return ans;
    }
}
