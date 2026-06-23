import heapq
from collections import defaultdict
from typing import List


class Tweet:
    def __init__(self, tweet_id: int, time: int, next_tweet=None):
        self.tweet_id = tweet_id
        self.time = time
        self.next = next_tweet  # 当前用户更早的一条推文


class Twitter:

    def __init__(self):
        self.time = 0

        # userId -> 该用户最新的一条 Tweet
        self.tweet_map = {}

        # followerId -> {followeeId1, followeeId2, ...}
        self.follow_map = defaultdict(set)

    def postTweet(self, userId: int, tweetId: int) -> None:
        # 头插法：新推文永远放在该用户推文链表最前面
        new_tweet = Tweet(
            tweet_id=tweetId,
            time=self.time,
            next_tweet=self.tweet_map.get(userId)
        )

        self.tweet_map[userId] = new_tweet
        self.time += 1

    def getNewsFeed(self, userId: int) -> List[int]:
        ans = []
        max_heap = []

        # 自己的推文也要进入新闻流
        users = set(self.follow_map[userId])
        users.add(userId)

        # 每个人只先放最新的一条推文进入堆
        for user in users:
            tweet = self.tweet_map.get(user)

            if tweet:
                # heapq 是小顶堆，时间取负数模拟大顶堆
                heapq.heappush(max_heap, (-tweet.time, tweet))

        # 每次取当前所有候选中最新的一条
        while max_heap and len(ans) < 10:
            _, tweet = heapq.heappop(max_heap)
            ans.append(tweet.tweet_id)

            # 该用户还有更旧的推文，放回堆继续比较
            if tweet.next:
                heapq.heappush(max_heap, (-tweet.next.time, tweet.next))

        return ans

    def follow(self, followerId: int, followeeId: int) -> None:
        if followerId != followeeId:
            self.follow_map[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        self.follow_map[followerId].discard(followeeId)