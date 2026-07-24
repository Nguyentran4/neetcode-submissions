class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> nei=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            nei.add(new ArrayList<>());
        }
        int ind[]=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++)
        {
            ind[prerequisites[i][0]]++;;
            nei.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(ind[i]==0)
            q.add(i);
        }
        int i=0;
        int r[]=new int[numCourses];
        while(!q.isEmpty())
        {
            int cur=q.poll();
            r[i]=cur;
            i++;
            for(int n:nei.get(cur))
            {
                ind[n]--;
                if(ind[n]==0)
                q.add(n);
            }
        }
        if(i==numCourses)
        return r;
        return new int[0];
    }
}
