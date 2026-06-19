class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for(int i : piles){
            r = Math.max(r,i);
        }
        while(l <= r){
            int mid = (r - l) / 2 + l; 
            int total = cal(piles,mid);
            if(total <= h){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
    private int cal(int[] piles,int mid){
        int totalTime = 0;
        for(int pile : piles){
            totalTime += (pile + mid - 1) / mid;
        }
        return totalTime;
    }
}
