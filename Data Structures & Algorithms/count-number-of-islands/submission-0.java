class Solution {
    public int numIslands(char[][] grid) {

        // we have adjacency matrix here
        // here we have to focus on direction


        int row = grid.length;
        int col = grid[0].length;

        // we have too perform dfs oon each and every nooode 
        int island=0;
        for(int i = 0;i<row ; i++)
        {
            for(int j = 0;j<col;j++)
            {
                if(grid[i][j]=='1')
                { 
                    island++;
                    dfs(i,j,grid);
                }
            }
        }
        return island; //mistake
        
    }

    private static void dfs(int row,int col,char[][] grid)//char mistake
    {
        int newrow=grid.length;
        int newcol=grid[0].length;

        //now we have focus on movement direction

        int [][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        

        if(row<0 || col<0 || newrow<=row || newcol<=col || grid[row][col]=='0') return; //boolean mistake

        grid[row][col]='0'; //visited node
        for(int [] dir: directions)
        {
            dfs(row+dir[0],col+dir[1],grid); //full argument passing bro
        }

    }

}
