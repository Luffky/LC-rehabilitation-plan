class Solution {
    public int minCut(String s) {
         boolean[][] g = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                if (i == 0) {
                    g[j][j] = true;
                } else if (i == 1 && s.charAt(j) == s.charAt(j + 1)) {
                    g[j][j + 1] = true;
                } else if (i > 1) {
                    g[j][j + i] = g[j + 1][j + i - 1] && s.charAt(j) == s.charAt(j + i);
                }
            }
        }

        int[] f = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (g[0][i]) {
                f[i] = 0;
                continue;
            }
            f[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (g[j + 1][i]) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        return f[s.length() - 1];
    }
}
