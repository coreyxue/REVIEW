import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class BinaryHeapTest {

	@Test
	public void test() {
		Integer score = 0;
		Integer num_tests = 17;
		BinaryHeap my_heap = new BinaryHeap();
		
		my_heap.insert(1);
		int[] expected_result1 = {1,1};
		score+=result_check(my_heap,expected_result1);
		
		my_heap.insert(2);
		int[] expected_result2 = {2,1,2};
		score+=result_check(my_heap,expected_result2);
		
		my_heap.insert(3);
		int[] expected_result3 = {3,1,2,3};
		score+=result_check(my_heap,expected_result3);
		
		my_heap.insert(0);
		int[] expected_result4 = {4,0,1,3,2};
		score+=result_check(my_heap,expected_result4);
		
		my_heap.insert(0);
		int[] expected_result5 = {5,0,0,3,2,1};
		score+=result_check(my_heap,expected_result5);
		
		my_heap.insert(1);
		int[] expected_result6 = {6,0,0,1,2,1,3};
		score+=result_check(my_heap,expected_result6);
		
		my_heap.insert(4);
		int[] expected_result7 = {7,0,0,1,2,1,3,4};
		score+=result_check(my_heap,expected_result7);
		
		my_heap.insert(0);
		int[] expected_result8 = {8,0,0,1,0,1,3,4,2};
		score+=result_check(my_heap,expected_result8);
		
		my_heap.removeMin();
		int[] expected_result9 = {7,0,0,1,2,1,3,4};
		score+=result_check(my_heap,expected_result9);
		
		my_heap.removeMin();
		int[] expected_result10 = {6,0,1,1,2,4,3};
		score+=result_check(my_heap,expected_result10);
		
		my_heap.removeMin();
		int[] expected_result11 = {5,1,2,1,3,4};
		score+=result_check(my_heap,expected_result11);
		
		my_heap.removeMin();
		int[] expected_result12 = {4,1,2,4,3};
		score+=result_check(my_heap,expected_result12);
		
		my_heap.removeMin();
		int[] expected_result13 = {3,2,3,4};
		score+=result_check(my_heap,expected_result13);
		
		my_heap.removeMin();
		int[] expected_result14 = {2,3,4};
		score+=result_check(my_heap,expected_result14);
		
		my_heap.removeMin();
		int[] expected_result15 = {1,4};
		score+=result_check(my_heap,expected_result15);
		
		my_heap.removeMin();
		int[] expected_result16 = {0};
		score+=result_check(my_heap,expected_result16);
		
		//remove from empty heap
		my_heap.removeMin();
		int[] expected_result17 = {0};
		score+=result_check(my_heap,expected_result17);
		
		System.out.print("Score: "+score.toString()+"/"+num_tests.toString()+".");
	}
	public int result_check(BinaryHeap bh, int[] expected_result)
	{
		if(bh.size()+1!=expected_result.length)
			return 0;
		for(int i=0;i<expected_result.length;i++)
		{
			if(bh.store.get(i)!=expected_result[i])
				return 0;
		}
		return 1;
	}

}
