class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordSet = set(wordList)
        if endWord not in wordSet:
            return 0
        queue = deque([(beginWord,1)])
        while queue:
            word,step = queue.popleft()
            for i in range(len(word)):
                for ch in "abcdefghijklmnopqrstuvwxyz":
                    if ch == word[i]:
                        continue
                    nextWord = word[:i] + ch  + word[i + 1 :]
                    if nextWord == endWord:
                        return step + 1
                    if nextWord in wordSet:
                        wordSet.remove(nextWord)
                        queue.append((nextWord,step + 1))
        return 0