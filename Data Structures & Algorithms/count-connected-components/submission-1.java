class Solution {
    class DSU {
        int[] par;
        int[] rank;
        int connectedComponent;
        DSU (int n) {
            par = IntStream.rangeClosed(0, n).toArray();
            rank = new int[n + 1];
            Arrays.fill(rank, 1);
            connectedComponent = n;
        }
        int doFind(int x) {
            if (par[x] != x) {
                par[x] = doFind(par[x]);
            }

            return par[x];
        }
        boolean doUnion(int n1, int n2) {
            int p1 = doFind(n1);
            int p2 = doFind(n2);

            if (p1 == p2)
                return false;
            
            if (rank[p1] >= rank[p2]) {
                par[p2] = p1;
                rank[p1] += rank[p2];
            } else {
                par[p1] = p2;
                rank[p2] += rank[p1];
            }

            connectedComponent--;
            return true;
        }
    }
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for (int i = 0; i < edges.length; i++) {
            int n1 = edges[i][0], n2 = edges[i][1];
            dsu.doUnion(n1, n2);
        }

        return dsu.connectedComponent;
    }
}
