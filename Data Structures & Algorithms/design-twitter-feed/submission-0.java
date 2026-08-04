class Twitter {

    private int time;
    // userID -> list of users tweets ( int[]{time, tweetID} )
    private Map<Integer, List<int[]>> tweetMap;

    // followerID -> set of users they follow
    private Map<Integer, Set<Integer>> followMap;

    public Twitter() {
        time = 0;
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        // add user and tweet to tweetMap; check if absent first, if so, add user and make list for user
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{time, tweetId});
        time++; //increment time
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        
        // max heap so newest news first
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0] - a[0]);

        // user should see their own tweets too
        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);
        
        // go through everyone this person follows
        for(int followeeId : followMap.get(userId)){
            // if followee has no tweets, skip
            if(!tweetMap.containsKey(followeeId)){
                continue;
            }

            // add all tweets from this followee to heap
            for(int[] tweet : tweetMap.get(followeeId)){
                maxHeap.offer(tweet);
            }
        }

        // pull up to 10 newest tweets
        while(!maxHeap.isEmpty() && result.size() < 10){
            int [] tweet = maxHeap.poll();
            int tweetId = tweet[1];
            result.add(tweetId);
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        // if follower has no follow set yet, make it
        followMap.putIfAbsent(followerId, new HashSet<>());
        // add followee to follower's set
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        // if follow DNE, nothing to remove
        if(!followMap.containsKey(followerId)){
            return;
        }
        // else, remove followee from followers set
        followMap.get(followerId).remove(followeeId);
    }
}
