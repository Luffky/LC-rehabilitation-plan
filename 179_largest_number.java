class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        int i = 0;
        for (int num : nums) {
            strs[i++] = String.valueOf(num);
        }
        Arrays.sort(strs, new MyComparator());
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            if (sb.length() == 0 && str.equals("0")) {
                continue;
            }
            sb.append(str);
        }
        if (sb.length() == 0) {
            sb.append("0");
        }
        return sb.toString();
    }

    class MyComparator implements Comparator<String> {
        public int compare(String o1, String o2) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            sb.append(o1);
            sb.append(o2);
            sb2.append(o2);
            sb2.append(o1);
            String s1 = sb.toString();
            String s2 = sb2.toString();
            return s2.compareTo(s1);
        }
    }
}
