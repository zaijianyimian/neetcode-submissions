
class Solution {
    public String foreignDictionary(String[] words) {
        // 1. 收集所有出现过的字符
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                graph.putIfAbsent(ch, new HashSet<>());
                indegree.putIfAbsent(ch, 0);
            }
        }

        // 2. 比较相邻单词，建立有向边
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            // 前缀错误：["abc", "ab"]
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            int minLen = Math.min(word1.length(), word2.length());

            for (int j = 0; j < minLen; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                // 只看第一个不同字符
                if (c1 != c2) {
                    // c1 必须排在 c2 前面：c1 -> c2
                    if (graph.get(c1).add(c2)) {
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        // 3. 拓扑排序：先找所有入度为 0 的字符
        Queue<Character> queue = new ArrayDeque<>();

        for (char ch : indegree.keySet()) {
            if (indegree.get(ch) == 0) {
                queue.offer(ch);
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!queue.isEmpty()) {
            char ch = queue.poll();
            ans.append(ch);

            for (char next : graph.get(ch)) {
                indegree.put(next, indegree.get(next) - 1);

                if (indegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }

        // 4. 结果字符数不够，说明图中有环
        return ans.length() == graph.size() ? ans.toString() : "";
    }
}