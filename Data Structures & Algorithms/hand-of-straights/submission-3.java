class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0){
            return false;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : hand){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Arrays.sort(hand);
        for(int num : hand){
            if(map.get(num) == 0){
                continue;
            }
            for(int i = 0;i < groupSize;i ++){
                if(map.getOrDefault(num + i,0) == 0){
                    return false;
                }
                map.put(num + i,map.get(num + i) - 1);
            }
        }
        return true;
    }
}
