import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import Util.NestedInteger;

/**
 * 
 * Given a nested list of integers, implement an iterator to flatten it.
 * 
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * 
 * Example 1:
 * Given the list [[1,1],2,[1,1]],
 * 
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
 * 
 * Example 2:
 * Given the list [1,[4,[6]]],
 * 
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 * @author Shengyi
 *
 */
  

// Note: 记住思路

public class _341_Flatten_Nested_List_Iterator implements Iterator<Integer> {
	
	List<NestedInteger> nestedList;
	Stack<NestedInteger> stack = new Stack<NestedInteger>();
	
	public _341_Flatten_Nested_List_Iterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        
        for (int i = nestedList.size() - 1; i >= 0; i--) {
        	stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
    	while (!stack.isEmpty()) {
    		if (stack.pop().isInteger()) {
    			return true;
    		}
    		
    		NestedInteger temp = stack.pop();
    		
    		List<NestedInteger> list = temp.getList();
    		
    		for (int i = list.size() - 1; i >= 0; i--) {
            	stack.push(list.get(i));
            }
    	}
    	
    	return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
