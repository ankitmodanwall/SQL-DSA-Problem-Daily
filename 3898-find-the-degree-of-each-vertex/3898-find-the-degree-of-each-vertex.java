class Solution {
    public int[] findDegrees(int[][] matrix) {
        int v = matrix.length;
        int [] degree = new int[v];
        for(int i = 0; i < v; i++){
            for(int j = 0; j<matrix[i].length; j++){
                if(matrix[i][j] == 1){
                    degree[j]++;
                }
            }
        }
        return degree;
    }
}