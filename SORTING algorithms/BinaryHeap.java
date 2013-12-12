import java.util.*;
public class BinaryHeap {
	// ArrayList use to store elements of the heap,start with index 1, 
	// index 0 use to keep the number of elements
	ArrayList<Integer> store;
	
	public BinaryHeap()
	{
		store = new ArrayList<Integer>();
		store.add(0);
	}
	//return the real size of the heap
	public int size()
	{
		return store.get(0);
	}
	// Return the minimum element in the heap O(1)
	public int min()
	{
		return store.get(0)==0? null:store.get(1);
	}
	// Insert an item into the heap O(log n)
	public int insert(Integer item)
	{
		//add a spot to store
		store.add(null);
		//index of the last element + 1
		int insert_index = store.size()-1;
		int parent_index = (int) Math.floor(insert_index/2);
		//looking for the right place to do insertion
		while(parent_index!=0 && store.get(parent_index)>=item )
		{
			//bubble up a empty spot
			store.set(insert_index, store.get(parent_index));
			//item is the minimum element
			if(parent_index==1)
			{
				insert_index=parent_index;
				break;
			}
			//renew index
			insert_index = parent_index;
			parent_index = (int) Math.floor(insert_index/2);
		}
		// insert into the right place 
			store.set(insert_index, item);
		// increment the heap size
		store.set(0, store.get(0)+1);
		return item;
	}
	/*helper function to check special cases
	 * return 0: not a special case
	 *        1: child_index1 is illegal
	 *        2: child_index2 is illegal
	 * We need to run check_special_case() every time we update our indices!
	 */
	private int check_special_case(int child_index1, int child_index2)
	{
		if(child_index1 >= store.size())
			return 1;
		if(child_index2 >= store.size())
			return 2;
		return 0;
	}
	/*helper function to handle special cases
	 * case_num is 1 or 2 refer to special case 1 and 2
	 */
	private void handle_special_case(Integer replace_item, int replace_index, int child_index1, int child_index2, int case_num)
	{
		//at a leaf node
		if(case_num == 1)
		{
			store.set(replace_index,replace_item);
		}
		else //only one child 
		{
			//a swap is needed
			if(store.get(child_index1) < replace_item)
			{
				store.set(replace_index, store.get(child_index1));
				store.set(child_index1, replace_item);
			}
			else// no swap needed
				store.set(replace_index, replace_item);
		}
		//decrement the size
		store.set(0, store.get(0)-1);
	}
	// Remove the minimum element from the heap, runs O(log n)
	public Integer removeMin()
	{
		//if the heap is empty return null
		if(store.size()==1)
			return null;
		Integer min = store.get(1);
		Integer replace_item;
		//Handle only one or two elements
		if(store.get(0)==1 || store.get(0)==2)
		{
			store.set(0, store.get(0)-1);
			return store.remove(1);
		}
		// remove the last element
		replace_item = store.remove(store.size()-1);
		int replace_index = 1;
		int child_index1 = 2*replace_index;
		int child_index2 = 2*replace_index+1;
		// We need to run check_special_case function every time we update our indices
		int case_num = check_special_case(child_index1,child_index2);
		if(case_num != 0)
		{
			handle_special_case(replace_item,replace_index,child_index1,child_index2,case_num);
			return min;
		}
		//get the left child
		Integer left = store.get(child_index1);
		//get the right child
		Integer right = store.get(child_index2);
		//decide which way to swap elements
		Integer child = left<right?left:right;
		//swap all the way down
		while(child < replace_item)
		{
			//go left
			if(child == left)
			{
				store.set(replace_index, store.get(child_index1));
				replace_index = child_index1;
			}
			else // go right
			{
				store.set(replace_index, store.get(child_index2));
				replace_index = child_index2;
			}
			//update indices
			child_index1 = 2*replace_index;
			child_index2 = 2*replace_index+1;
			//check for special cases
			case_num = check_special_case(child_index1,child_index2);
			//if special case encountered
			if(case_num != 0)
			{
				handle_special_case(replace_item,replace_index,child_index1,child_index2,case_num);
				return min;
			}
			//update left and right child
			left = store.get(child_index1);
			right = store.get(child_index2);
			child = left<right?left:right;
		}
		//found the right place to end the swap process
		store.set(replace_index, replace_item);
		//decrement the size
		store.set(0, store.get(0)-1);
		return min;
	}
	//simple print method that prints the heap
	public void print_heap()
	{
		System.out.println("There are "+store.get(0).toString()+" elements.");
		for(int i=1;i<store.size();i++)
			System.out.print(" "+store.get(i));
	}
}
