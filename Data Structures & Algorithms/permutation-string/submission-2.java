class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()){
            return false;
        }
        int[] arr = new int[26];
        for(char c : s1.toCharArray()){
            arr[c - 'a'] ++; 
        }
        int l = 0,r = 0;
        while(r < s2.length()){
            int c = s2.charAt(r) - 'a';
            arr[c] --;
            while (arr[c] < 0){
                int index = s2.charAt(l) - 'a';
                arr[index] ++;
                l ++;
            }
            if (r - l + 1 == s1.length()){
                for(int i : arr){
                    if(i != 0){
                        return false;
                    }
                }
                return true;
            }
            r ++;
        }
        return false;
    }
}
