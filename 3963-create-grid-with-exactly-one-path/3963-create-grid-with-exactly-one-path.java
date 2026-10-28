class Solution {
    public String[] createGrid(int m, int n) {

        String[] grid = new String[m];
        for(int i = 0; i<m; i++){
            StringBuilder row = new StringBuilder();
            for(int j = 0; j<n; j++){
                if (i == 0 || j==n-1){
                row.append('.');
        }
                else{
                    row.append('#');
                }
                    
                }
        // ans.add(row.toString());    
        grid[i] = row.toString();   
        }
        
    return grid;
        }
    }
