class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        // endWord 不在字典中，无法转换到终点
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);

        int step = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            // 当前 BFS 层的所有单词
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                char[] chars = word.toCharArray();

                // 尝试替换每一位字符
                for (int j = 0; j < chars.length; j++) {
                    char oldChar = chars[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == oldChar) {
                            continue;
                        }

                        chars[j] = ch;
                        String nextWord = new String(chars);

                        if (nextWord.equals(endWord)) {
                            return step + 1;
                        }

                        // 该单词存在且此前未访问
                        if (wordSet.contains(nextWord)) {
                            wordSet.remove(nextWord); // 标记访问，避免重复入队
                            queue.offer(nextWord);
                        }
                    }

                    // 恢复当前位，下一轮替换别的位置
                    chars[j] = oldChar;
                }
            }

            step++;
        }

        return 0;
    }
}