class Solution {
    public String countAndSay(int n) {
        String ret = "1";
        for (int i = 2; i <= n; i++) {
            ret = processNumber(ret);
        }
        return ret;
    }

    public String processNumber(String input) {
        char prev = '.';
        int prevIndex = -1;
        char[] chs = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chs.length; i++) {
            if (prev == '.') {
                prev = chs[i];
                prevIndex = i;
            } else if (prev != chs[i]) {
                sb.append((char) ('0' + i - prevIndex));
                sb.append(prev);
                prev = chs[i];
                prevIndex = i;
            }
        }
        sb.append((char) ('0' + chs.length - prevIndex));
        sb.append(prev);
        return sb.toString();
    }
}
