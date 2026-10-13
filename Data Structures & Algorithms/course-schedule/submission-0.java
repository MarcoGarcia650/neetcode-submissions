class Solution {
    private List<List<Integer>> adj = new ArrayList<>();
    private Set<Integer> visited = new HashSet<>();
    private Set<Integer> visiting = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // T: O(V + E) build adj, graph, dfs all across
        // S: O(V + E) adj space, 2 sets and recursion stack take O(V) additional space

        // make adj lists for each course
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        // get all adj into list
        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }

        // check for cycles
        for(int i = 0; i < numCourses; i++){
            if(!dfs(i)) return false;
        }
        return true;
    }

    private boolean dfs(int course){
        // if already visited and no cycle found prev,
        if(visited.contains(course)) return true;
        // if on curr active dfs path, false--cycle detected
        if(visiting.contains(course)) return false;

        visiting.add(course);

        for(int neighbor : adj.get(course)){
            if(!dfs(neighbor)) return false;
        }

        visiting.remove(course);
        visited.add(course);

        return true;
    }
}
