class Solution {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2)
            return "";
        return findNiceString(s, 0, s.length());
    }

    private static String findNiceString(String s, int l, int r) {
        if (r - l < 2) return "";
        
        Set<Character> set = new HashSet<>();
        for (int i = l; i < r; i++) {
            set.add(s.charAt(i));
        }

        for (int i = l; i < r; i++) {
            char chr = s.charAt(i);
            if ((!set.contains(Character.toLowerCase(chr))) || 
                (!set.contains(Character.toUpperCase(chr)))) {
                //  Bad character → split here
                String left = findNiceString(s, l, i);
                String right = findNiceString(s, i + 1, r);
                return left.length() >= right.length() ? left : right;
            }
        }
        //  Whole substring is nice
        return s.substring(l, r);
    }
}