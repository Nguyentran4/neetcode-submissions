class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int n= edges.length;
        n=n+1;
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        int [] arr =new int[2];
        for(int[] a : edges){
            int u = a[0];
            int v =a[1];
            int pu=find(u);
            int pv=find(v);
            if(pu!=pv){
                parent[pv]=pu;
            }else{
                arr[0]=u;
                arr[1]=v;
                break;
            }
        }
        return arr;

    }
    public int find(int x){
        if(parent[x]==x){
            return x;
        }
        return find(parent[x]);
    }

}
