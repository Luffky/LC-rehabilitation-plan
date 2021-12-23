class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        } else if (word2.length() == 0) {
            return word1.length();
        }
        int[][] dp = new int[word1.length()][word2.length()];
        char[] cha1 = word1.toCharArray();
        char[] cha2 = word2.toCharArray();
        for (int i = 0; i < word1.length(); i++) {
            if (i == 0) {
                dp[0][0] = cha1[0] == cha2[0] ? 0 : 1;
            } else {
                if (cha1[i] == cha2[0]) {
                    dp[i][0] = i;
                } else { 
                    dp[i][0] = dp[i - 1][0] + 1;
                }
            }
        }
        for (int i = 1; i < word2.length(); i++) {
            if (cha1[0] == cha2[i]) {
                dp[0][i] = i;
            } else { 
                dp[0][i] = dp[0][i - 1] + 1;
            }
        }
        for (int i = 1; i < word1.length(); i ++) {
            for (int j = 1; j < word2.length(); j++) {
                int add = 1;
                if (cha1[i] == cha2[j]) {
                    add = 0;
                }
                dp[i][j] = Math.min(dp[i - 1][j - 1] + add, Math.min(dp[i - 1][j], dp[i][j - 1]) + 1);
            }
        }
        return dp[cha1.length - 1][cha2.length - 1];
    }
}
