class Solution {
    public int candy(int[] ratings) {
        int prev = 0;
        int[] counts = new int[ratings.length];
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                if (i - 1 == prev) {
                    counts[prev] = prev == 0 || ratings[prev] == ratings[prev - 1] ? 1 : counts[prev - 1] + 1;
                } else {
                    counts[i - 1] = 1;
                    for (int j = i - 2; j > prev; j--) {
                        counts[j] = counts[j + 1] + 1;
                    }
                    counts[prev] = prev == 0 || ratings[prev] == ratings[prev - 1] ? counts[prev + 1] + 1 : Math.max(counts[prev + 1], counts[prev - 1]) + 1;
                }
                prev = i;
            } 
        }
        int i = ratings.length;
        if (i - 1 == prev) {
            counts[prev] = prev == 0 || ratings[prev] == ratings[prev - 1] ? 1 : counts[prev - 1] + 1;
        } else {
            counts[i - 1] = 1;
            for (int j = i - 2; j > prev; j--) {
                counts[j] = counts[j + 1] + 1;
            }
            counts[prev] = prev == 0 || ratings[prev] == ratings[prev - 1] ? counts[prev + 1] + 1 : Math.max(counts[prev + 1], counts[prev - 1]) + 1;
        }
        int sum = 0;
        for (int j = 0; j < counts.length; j++) {
            sum += counts[j];
        }
        return sum;
    }
}
