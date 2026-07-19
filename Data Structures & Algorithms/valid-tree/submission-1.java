class Solution {
    public boolean validTree(int n, int[][] edges) {
        //Valid tree iff 1. no cycle 2. all nodes connected
        if(edges.length > n-1) return false;
        
        Map<Integer, List<Integer>> m = new HashMap<>();
        for(int[] e: edges) {
            List<Integer> l1 = m.computeIfAbsent(e[0], k-> new ArrayList<Integer>());
            List<Integer> l2 = m.computeIfAbsent(e[1], k-> new ArrayList<Integer>());
            l1.add(e[1]);
            l2.add(e[0]);
        }
        Set<Integer> visited = new HashSet<>();
        if(!dfs(m, 0, -1, visited)) {
            return false;
        }

        return visited.size() == n;
    }

    boolean dfs( Map<Integer, List<Integer>> m, int cur,int parent, Set<Integer> visited ) {
        if(visited.contains(cur)) return false;
        visited.add(cur);
        if(!m.containsKey(cur)) return true;
        for(int node : m.get(cur)) {
            if(node == parent) continue;
            if(!dfs(m, node, cur, visited)) {
                return false;
            }
        }
        return true;
    }
}
