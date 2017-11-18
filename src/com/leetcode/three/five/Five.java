package com.leetcode.three.five;

import java.util.*;

public class Five {
    static class Twitter {
        HashMap<Integer,List<int[]>> map = new HashMap<>();
        HashMap<Integer,HashSet<Integer>> following = new HashMap<>();
        int cnt = 0;
        /** Initialize your data structure here. */
        public Twitter() {

        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            List<int[]> list = map.get(userId);
            if(list == null){
                list = new ArrayList<>();
                map.put(userId,list);
            }
            list.add(new int[]{cnt++,tweetId});
            follow(userId,userId);
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            HashSet<Integer> followees = following.get(userId);
            if(followees == null) return new ArrayList<>();

            List<Integer> followeeL = new ArrayList<>(followees);

            int[] cur = new int[followees.size()];
            List<int[]>[] posts = new List[followeeL.size()];
            PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    List<int[]> posts1 = posts[o1],posts2 = posts[o2];
                    int[] post1 = posts1.get(cur[o1]),post2 = posts2.get(cur[o2]);
                    return post2[0] - post1[0];
                }
            });

            for(int i = 0;i<followeeL.size();i++){
                posts[i] = map.get(followeeL.get(i));
                if(posts[i] != null){
                    cur[i] = posts[i].size() - 1;
                    pq.add(i);
                }
            }

            List<Integer> ret = new ArrayList<>();
            for(int i = 0;i<10;i++){
                if(pq.isEmpty()) break;
                Integer idx = pq.remove();
                ret.add(posts[idx].get(cur[idx]--)[1]);
                if(cur[idx] >= 0) pq.add(idx);
            }
            return ret;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            HashSet<Integer> set = following.get(followerId);
            if(set == null){
                set = new HashSet<>();
                following.put(followerId,set);
            }
            set.add(followeeId);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if(followeeId == followerId) return;
            HashSet<Integer> set = following.get(followerId);
            if(set != null) set.remove(followeeId);
        }
    }

}
