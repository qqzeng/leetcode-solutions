class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return true;
        
        ArrayList[] graph = new ArrayList[numCourses];
        int[] deps = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();            
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            deps[prerequisites[i][0]]++;
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        int count = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (deps[i] == 0) queue.offer(i);
        }
        
        while(queue.size() > 0) {
            int course = queue.poll();
            count++;
            for (int i = 0; i < graph[course].size(); i++) {
                int dep = (int)graph[course].get(i);
                deps[dep]--;
                if (deps[dep] == 0) queue.offer(dep);
            }
        }
        
        return count == numCourses;
        
    }

    
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return true;
        
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();            
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if(!dfs(graph, visited, i)) return false;
        }
        
        return true;
    }
    
    
    private boolean dfs(ArrayList[] graph, boolean[] visited, int i) {
        if (visited[i]) return false;
        visited[i] = true;
        for (int j = 0; j < graph[i].size(); j++) {
            if (!dfs(graph, visited, (int)graph[i].get(j))) return false;
        }
        visited[i] = false;
        return true;
    }
}