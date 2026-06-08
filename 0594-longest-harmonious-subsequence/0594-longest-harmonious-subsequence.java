import java.util.HashMap;

class Solution {
    public int findLHS(int[] nums) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        int ans = 0;

        for (int key : hm.keySet()) {
            if (hm.containsKey(key + 1)) {
                ans = Math.max(ans, hm.get(key) + hm.get(key + 1));
            }
        }

        return ans;
    }
}