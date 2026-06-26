class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // [a, b] 表示 b -> a
        for (int[] pre : prerequisites) {
            int a = pre[0];
            int b = pre[1];

            graph.get(b).add(a);
            inDegree[a]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for (int course = 0; course < numCourses; course++) {
            if (inDegree[course] == 0) {
                queue.addLast(course);
            }
        }

        int[] ans = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int course = queue.pollFirst();
            ans[index++] = course;

            for (int nextCourse : graph.get(course)) {
                inDegree[nextCourse]--;

                if (inDegree[nextCourse] == 0) {
                    queue.addLast(nextCourse);
                }
            }
        }

        return index == numCourses ? ans : new int[0];
    }
}