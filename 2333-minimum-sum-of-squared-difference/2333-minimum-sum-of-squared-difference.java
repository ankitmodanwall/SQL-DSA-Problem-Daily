class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length, m = 0;
        long k = (long) k1 + k2;
        int[] diff = new int[n];

        for (int i = 0; i < n; i++)
            m = Math.max(m, diff[i] = Math.abs(nums1[i] - nums2[i]));

        int[] bucket = new int[m + 1];
        for (int x : diff) bucket[x]++;

        for (int i = m; i > 0 && k > 0; i--) {
            int take = (int) Math.min(bucket[i], k);
            bucket[i] -= take;
            bucket[i - 1] += take;
            k -= take;
        }

        long ans = 0;
        for (int i = 1; i <= m; i++)
            ans += (long) bucket[i] * i * i;

        return ans;
    }
}