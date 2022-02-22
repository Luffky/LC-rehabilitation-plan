class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        while (i < v1.length && i < v2.length) {
            if (Integer.valueOf(v1[i]) > Integer.valueOf(v2[i])) {
                return 1;
            } else if (Integer.valueOf(v1[i]) < Integer.valueOf(v2[i])) {
                return -1;
            }
            i++;
        }
        String[] v = v1;
        int k = 1;
        if (i == v1.length) {
            v = v2;
            k = -1;
        }
        while (i < v.length) {
            if (Integer.valueOf(v[i]) > 0) {
                return k;
            }
            i++;
        }
        return 0;
    }
}
