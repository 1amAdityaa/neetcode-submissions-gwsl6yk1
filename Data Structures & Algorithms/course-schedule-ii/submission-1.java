class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        

        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0 ;i<numCourses;i++)
        {
            List<Integer> list = new ArrayList<>();
            adj.add(list);
        }
        int indegree[] = new int[numCourses];
       List<Integer> res = new ArrayList<>();
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
                q.offer(i);
                res.add(i);
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
                res.add(ele);
                }
            }
        }


    
    
int[] result = new int[res.size()];

for (int i = 0; i < res.size(); i++) {
    result[i] = res.get(i);
}

return (result.length == numCourses) ? result : new int[0];
    }
}


