class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] chs = new char[s.length()];
        int cur = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j = j + 2 * numRows - 2) {
                chs[cur++] = s.charAt(j);
                if (i != 0 && i != numRows - 1) {
                    int tmp = j + 2 * numRows - 2 - i * 2;
                    if (tmp < s.length()) {
                        chs[cur++] = s.charAt(tmp);
                    }
                }
            }
        }
        return String.valueOf(chs);
    }
}
