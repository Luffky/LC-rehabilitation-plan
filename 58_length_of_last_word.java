class Solution {
    public int lengthOfLastWord(String s) {
        boolean flag = false;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (flag) {
                    break;
                }
            } else {
                flag = true;
                count++;
            }
        }
        return count;
    }
}
