class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] lastMatchIndex = new int[m];
        int p = n - 1;
        for (int j = m - 1; j >= 0; j--) {
            while (p >= 0 && word1.charAt(p) != word2.charAt(j)) {
                p--;
            }
            lastMatchIndex[j] = p;
            if (p >= 0) {
                p--;
            }
        }

        int[] result = new int[m];
        boolean usedChange = false;
        int i = 0, j = 0;

        while (i < n && j < m) {
            boolean isMatch = word1.charAt(i) == word2.charAt(j);
            boolean canChange = !usedChange && (j + 1 == m || lastMatchIndex[j + 1] >= i + 1);

            if (isMatch || canChange) {
                if (!isMatch) {
                    usedChange = true;
                }
                result[j] = i;
                j++;
            }
            i++;
        }

        return j == m ? result : new int[0];
    }
}