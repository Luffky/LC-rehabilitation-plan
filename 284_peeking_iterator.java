import java.util.Iterator;

/*
 * @lc app=leetcode.cn id=284 lang=java
 *
 * [284] 顶端迭代器
 */

// @lc code=start
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
	Iterator<Integer> iterator;
	Integer temp;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if (temp == null) {
			temp = iterator.next();
		}
		return temp;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if (temp != null) {
			Integer tmp = temp;
			temp = null;
			return tmp;
		}
		return iterator.next();
	}
	
	@Override
	public boolean hasNext() {
		return temp != null || iterator.hasNext();
	}
}
// @lc code=end

