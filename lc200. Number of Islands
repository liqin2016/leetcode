// 1. the type of grid is char[][]  we should compare grid to '0'and '1'
// 2. The length of grid could be 0
// 3  the condition of dfs

class Solution {
    public int numIslands(char[][] grid) {
        int n= grid.length;
        if(n==0) return 0;
        int m= grid[0].length;
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }
    
    private void dfs(char[][] grid,int i,int j){
        //set all '1' to '0'
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]!='1'){
            return;
        }
        
        grid[i][j]='0';
        dfs(grid,i,j+1);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i+1,j);
        
    }
    
}
