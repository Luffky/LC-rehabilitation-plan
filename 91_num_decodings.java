class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int numDecodings(String s) {
        char[] chs = s.toCharArray();
        return helper(chs, 0);
    }
    public int helper(char[] chs, int index) {
        if (map.containsKey(index)) {
            return map.get(index);
        }
        if (index == chs.length) {
            return 1;
        }
        if (chs[index] == '0') {
            map.put(index, 0);
            return 0;
        } else {
            int c1 = helper(chs, index + 1);
            if (index + 1 < chs.length && (chs[index] == '1'  || (chs[index] == '2' && chs[index + 1] < '7'))) {
                c1 += helper(chs, index + 2);
            } 
            map.put(index, c1);
            return c1;
        }
    }
}
