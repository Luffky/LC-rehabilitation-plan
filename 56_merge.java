class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new MyComparator());
        List<int[]> list = new LinkedList<>();
        int prev = -1;
        int end = -1;
        for (int i = 0; i < intervals.length; i++) {
            if (prev == -1) {
                prev = intervals[i][0];
                end = intervals[i][1];
            } else {
                if (intervals[i][0] > end) {
                    list.add(new int[]{prev, end});
                    prev = intervals[i][0];
                    end = intervals[i][1];
                } else {
                    end = Math.max(end, intervals[i][1]);
                }
            }
        }
        list.add(new int[]{prev, end});
        int[][] ret = new int[list.size()][2];
        int i = 0;
        for (int[] ele : list) {
            ret[i][0] = ele[0];
            ret[i++][1] = ele[1];
        }
        return ret;
    }

    class MyComparator implements Comparator<int[]>{
        @Override
        public int compare(int[] a1, int[] a2) {
            if (a1[0] == a2[0]) {
                return 0;
            } else {
                return a1[0] > a2[0] ? 1 : -1;
            }
        }
    }
}
