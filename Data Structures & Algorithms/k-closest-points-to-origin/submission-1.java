class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int[] point : points) {
            int a = point[0];
            int b = point[1];
            int dist = a * a + b * b;
            queue.offer(new int[] {dist, a, b});
        }
        int[][] arr = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] tmp = queue.poll();
            arr[i][0] = tmp[1];
            arr[i][1] = tmp[2];
        }
        return arr;
    }
}
