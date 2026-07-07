class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord))
            return 0;

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);

        int len = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {

            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> next = new HashSet<>();

            for (String word : beginSet) {

                char[] ch = word.toCharArray();

                for (int i = 0; i < ch.length; i++) {

                    char old = ch[i];

                    for (char c = 'a'; c <= 'z'; c++) {

                        ch[i] = c;
                        String target = new String(ch);

                        if (endSet.contains(target))
                            return len + 1;

                        if (!visited.contains(target) && wordSet.contains(target)) {
                            visited.add(target);
                            next.add(target);
                        }
                    }

                    ch[i] = old;
                }
            }

            beginSet = next;
            len++;
        }

        return 0;
    }
}