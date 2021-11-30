class Solution {
    public int romanToInt(String s) {
        int[] nums = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] strs = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("IV", 4);
        map1.put("IX", 9);
        map1.put("XL", 40);
        map1.put("XC", 90);
        map1.put("CD", 400);
        map1.put("CM", 900);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("I", 1);
        map2.put("V", 5);
        map2.put("X", 10);
        map2.put("L", 50);
        map2.put("C", 100);
        map2.put("D", 500);
        map2.put("M", 1000);
        int sum = 0;
        for (int i = 0; i < s.length();) {
            if (i != s.length() - 1) {
                if (map1.containsKey(s.substring(i, i + 2))) {
                    sum += map1.get(s.substring(i, i + 2));
                    i += 2;
                } else {
                    sum += map2.get(s.substring(i, i + 1));
                    i += 1;
                }
            } else {
                sum += map2.get(s.substring(i, i + 1));
                i++;
            }
        }
        return sum;
    }
}
