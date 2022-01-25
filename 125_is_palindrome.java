class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i <= j) {
            if (isValid(chars[i]) && isValid(chars[j])) {
                if (chars[i++] != chars[j--]) {
                    return false;
                }
            } else if (isValid(chars[j])) {
                i++;
            } else if (isValid(chars[i])) {
                j--;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public boolean isValid(char c) {
        return (c <= 'z' && c >= 'a') || (c <= '9' && c >= '0');
    }
}
