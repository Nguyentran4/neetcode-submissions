class Twitter {
    Map<Integer, Set<Integer>> following; 
    Tweet mostRecent, leastRecent; 

    public Twitter() {
        following = new HashMap(); 
        mostRecent = null;
        leastRecent = null; 
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(tweetId, userId);

        if (mostRecent == null && leastRecent == null) {
            mostRecent = newTweet; 
            leastRecent = newTweet; 
        } else {
            mostRecent.prev = newTweet;
            newTweet.next = mostRecent; 
            mostRecent = newTweet; 
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList();
        int count = 10; 
        Tweet currTweet = mostRecent; 

        while (currTweet != null && count > 0) {
            // user with userId is following the author of currTweet, OR is the author themself
            if (currTweet.userId == userId || (following.containsKey(userId) && following.get(userId).contains(currTweet.userId))) {
                res.add(currTweet.tweetId); 
                count--;
            }
            currTweet = currTweet.next; 
        }
        return res; 
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if (!following.containsKey(followerId)) {
            following.put(followerId, new HashSet<Integer>());
        }
        following.get(followerId).add(followeeId); 
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId); 
        }
    }   
}

class Tweet { 
    int tweetId; 
    int userId; 
    Tweet next; 
    Tweet prev; 

    Tweet(int tweetId, int userId) {
        this.tweetId = tweetId;
        this.userId = userId;  
    }
}