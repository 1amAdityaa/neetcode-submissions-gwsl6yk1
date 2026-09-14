class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        

        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0 ;i<numCourses;i++)
        {
            List<Integer> list = new ArrayList<>();
            adj.add(list);
        }
        int indegree[] = new int[numCourses];
        boolean [] vis = new boolean[numCourses];
        for(int grid[]:prerequisites)
        {
            adj.get(grid[1]).add(grid[0]);
            indegree[grid[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                vis[i]=true;
                q.offer(i);
            }
        }
        while(!q.isEmpty())
        {
            int front = q.poll();
            for(int ele:adj.get(front))
            {
                indegree[ele]--;
                if(indegree[ele]==0)
                {
                q.offer(ele);
                vis[ele]=true;
                }
            }
        }
        
        for(boolean i : vis)
        {
            if(i==false)
            return false;
        }

        return true;

    }
}
