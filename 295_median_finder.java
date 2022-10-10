import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 */

// @lc code=start
class MedianFinder {
    PriorityQueue<Integer> maxPq;
    PriorityQueue<Integer> minPq;
    public MedianFinder() {
        maxPq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        minPq = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (maxPq.size() == 0) {
            maxPq.add(num);
            return;
        }
        if (maxPq.peek() >= num) {
            maxPq.add(num);
        } else {
            minPq.add(num);
        }
        if (maxPq.size() < minPq.size()) {
            maxPq.add(minPq.poll());
        } else if (maxPq.size() - minPq.size() > 1) {
            minPq.add(maxPq.poll());
        }
    }
    
    public double findMedian() {
        if ((minPq.size() + maxPq.size()) % 2 == 0) {
            return ((float) minPq.peek() + maxPq.peek()) / 2;
        } else {
            return maxPq.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

