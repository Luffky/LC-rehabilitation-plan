class Solution {
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            if (i == columnTitle.length() - 1) {
                sum += columnTitle.charAt(i) - 'A' + 1;
            } else {
                sum += columnTitle.charAt(i) - 'A' + 1;
                sum *= 26;
            }
        }
        return sum;
    }
}
