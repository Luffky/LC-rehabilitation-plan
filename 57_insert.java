class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new LinkedList<>();
        int begin = -1;
        int end = -1;
        for (int i = 0; i < intervals.length; i++) {
            if (interval(intervals[i], newInterval)) {
                if (begin == -1) {
                    begin = i;
                }
                end = i;
            }
        }
        boolean hasAdd = false;
        for (int i = 0; i < intervals.length; i++) {
            if (begin == -1) {
                if (newInterval[0] < intervals[i][0] && hasAdd == false) {
                    list.add(newInterval);
                    hasAdd = true;
                }
                list.add(intervals[i]);
            } else {
                if (i < begin || i > end) {
                    list.add(intervals[i]);
                } else if (i == begin) {
                    hasAdd = true;
                    list.add(new int[]{Math.min(intervals[begin][0], newInterval[0]), Math.max(intervals[end][1], newInterval[1])});
                    i = end;
                }
            }
        }
        if (hasAdd == false) {
            list.add(newInterval);
        }
        int[][] ret = new int[list.size()][2];
        int id = 0;
        for (int[] i : list) {
            ret[id++] = i;
        }
        return ret;
    }

    public boolean interval(int[] intervalA, int[] intervalB) {
        if (intervalA[1] < intervalB[0] || intervalA[0] > intervalB[1]) {
            return false;
        } else {
            return true;
        }
    }
}
