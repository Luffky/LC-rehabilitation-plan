class Solution {
    public List<String>  wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Set<String>[][] dp = new Set[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                dp[j][j + i] = new HashSet<>();
                String substring = s.substring(j, j + i + 1);
                if (set.contains(substring)) {
                    dp[j][j + i].add(substring);
                }
                if (i > 0) {
                    for (int k = j; k < j + i; k++) {
                        for (String strA : dp[j][k]) {
                            for (String strB : dp[k + 1][j + i]) {
                                dp[j][j + i].add(strA + " " + strB);
                            }
                        }
                    } 
                }
            }
        }
        return new LinkedList<>(dp[0][s.length() - 1]);
    }
}
