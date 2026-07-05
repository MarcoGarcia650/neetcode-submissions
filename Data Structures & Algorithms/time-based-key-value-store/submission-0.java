class TimeMap {
    private Map<String, List<Pair>> map;

    private static class Pair {
        int timestamp;
        String value;

        Pair(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)){
            return "";
        }

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
