class Solution {
    public String minWindow(String s, String t) {
        if(t.equals("")){
            return t;
        }
        Map<Character,Integer> countT = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        for(char c : t.toCharArray()){
            countT.put(c,countT.getOrDefault(c,0) + 1);
        }
        int have = 0,need = countT.size();
        int[] res = new int[2];
        int resLen = Integer.MAX_VALUE;
        int l = 0;
        for(int r = 0;r < s.length();r ++){
            char c = s.charAt(r);
            window.put(c,window.getOrDefault(c,0) + 1);
            if(countT.containsKey(c) && window.get(c).intValue() == countT.get(c).intValue()){
                have ++;
            }
            while(have == need){
                if ((r - l + 1) < resLen){
                    res[0] = l;
                    res[1] = r;
                    resLen = r - l + 1;
                }
                window.put(s.charAt(l),window.get(s.charAt(l)) - 1);
                if(countT.containsKey(s.charAt(l)) && window.get(s.charAt(l)) < countT.get(s.charAt(l))){
                    have --;
                }
                l ++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0],res[1] + 1);
    }
}
