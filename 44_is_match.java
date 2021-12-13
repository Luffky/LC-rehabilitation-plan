class Solution {
    public boolean isMatch(String s, String p) {
        char[] chs = s.toCharArray();
        char[] chp = p.toCharArray();
        int[][] records = new int[chs.length + 1][chp.length + 1];
        return isMatchHelper(chs, chp, 0, 0, records);
    }
    
    public boolean isMatchHelper(char[] chs, char[] chp, int ids, int idp, int[][] records) {
        //如果已经走过，就不在遍历。
        if (records[ids][idp] == 2) {
            return false;
        }

        if (ids == chs.length) {
            for (int i = idp; i < chp.length; i++) {
                if (chp[i] != '*') {
                    records[ids][idp] = 2;
                    return false;
                }
            }
            return true;
        } else if (idp == chp.length) {
            records[ids][idp] = 2;
            return false;
        }

        if (chp[idp] == '*') {
            for (int i = ids; i <= chs.length; i++) {
                boolean result = isMatchHelper(chs, chp, i, idp + 1, records);
                if (result) {
                    return true;
                }
            }
            records[ids][idp] = 2;
            return false;
        } else if (chp[idp] == '?' || chp[idp] == chs[ids]) {
            boolean result = isMatchHelper(chs, chp, ids + 1, idp + 1, records);
            if (result) {
                return true;
            } else {
                records[ids][idp] = 2;
                return false;
            }
        } else {
            records[ids][idp] = 2;
            return false;
        }
    }
}
