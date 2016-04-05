import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation*/
public interface NestedInteger {
	// @return true if this NestedInteger holds a single integer, rather than a nested list.
	public boolean isInteger();
	// @return the single integer that this NestedInteger holds, if it holds a single integer
 	// Return null if this NestedInteger holds a nested list 
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}
 
public class NestedIterator implements Iterator<Integer> {

	public NestedIterator(List<NestedInteger> nestedList) {
		
	}

	@Override
	public Integer next() {
		
	}

	@Override
	public boolean hasNext() {
		
	}

	public static void main(String[] args) {
		
	}
}