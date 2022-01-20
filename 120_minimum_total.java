class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int min = Integer.MAX_VALUE;
        int[] num = new int[triangle.size()];
        num[0] = triangle.get(0).get(0);
        int[] num2 = new int[triangle.size()];
        for (int i = 1; i < triangle.size(); i++) {
            int[] temp = num2;
            num2 = num;
            num = temp;
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    num[j] = num2[j];
                } else if (j == triangle.get(i).size() - 1) {
                    num[j] = num2[j - 1];
                } else {
                    num[j] = Math.min(num2[j], num2[j - 1]);
                }
                num[j] += triangle.get(i).get(j);
                if (i == triangle.size() - 1) {
                    min = Math.min(min, num[j]);
                }
            }
        }
        return min;
    }
}
