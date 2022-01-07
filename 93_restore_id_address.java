class Solution {
    List<String> ret = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        helper(s.toCharArray(), 0, 3, new LinkedList<>());
        return ret;
    }
    public void helper(char[] chs, int index, int remain, LinkedList<Integer> list) {
        if (chs.length - index > (remain + 1) * 3 || index == chs.length) {
            return;
        }
        if (remain == 0) {
            if (index == chs.length - 1 || chs[index] != '0') {
                int sum = 0;
                for (int i = index; i < chs.length; i++) {
                    sum = sum * 10 + (chs[i] - '0');
                }
                if (sum <= 255) {
                    StringBuilder sb = new StringBuilder(new String(chs));
                    int cur = 1;
                    for (int i : list) {
                        sb.insert(i + cur, '.');
                        cur++;
                    }
                    ret.add(sb.toString());
                }
            }
            return;
        }
        if (chs[index] == '0') {
            list.addLast(index);
            helper(chs, index + 1, remain - 1, list);
            list.pollLast();
        } else {
            int sum = chs[index] - '0';
            while (sum <= 255) {
                list.addLast(index);
                helper(chs, index + 1, remain - 1, list);
                list.pollLast();
                index++;
                if (index == chs.length) {
                    break;
                }
                sum = 10 * sum + (chs[index] - '0');
            }
        }
    }
}
