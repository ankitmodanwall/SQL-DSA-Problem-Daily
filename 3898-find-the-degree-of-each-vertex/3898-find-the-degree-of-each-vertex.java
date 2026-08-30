class Solution {
    public int[] findDegrees(int[][] matrix) {
        int n = matrix.length;
        int[] degree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                degree[i] += matrix[i][j];
            }
        }

        return degree;
    }
}