class TimeMap {
    // Create a private map where each String key points to a List of Pair objects
    // “A TimeMap object will have a variable called map.”
    private Map<String, List<Pair>> map;

    // create Pair class to hold values in one obi; private b/c outside doesnt need to access Pair/ mess with its data
    private static class Pair{
        // create vars int timestamp, String value
        int timestamp;
        String value;

        // create constructor
        Pair(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    public TimeMap() {
        //private Map<String, List<Pair>> map; // declare reference
        // map = new HashMap<>();               // create actual map
        // "Actually create the map"
        map = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        // put.if absent, make new key list 
        // Add the new timestamp/value Pair to the key's list
        map.putIfAbsent(key, new ArrayList<>());

        // Get the list stored under key, add a new Pair to that list--why we use .add (b/c it's a list in the map)
        map.get(key).add(new Pair(timestamp, value)); 
    }
    
    public String get(String key, int timestamp) {
        // if key not ever made, return """"
        // else, do binary search on values

        if(!map.containsKey(key)) return "";
        
        // make a list of pair valeus from key
        List<Pair> values = map.get(key);
        
        int left = 0;
        int right = values.size() - 1;

        String answer = "";

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(values.get(mid).timestamp <= timestamp){
                answer = values.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */