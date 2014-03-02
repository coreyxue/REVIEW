import static org.junit.Assert.*;

import org.junit.Test;


public class BubbleSortTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		int[] arr = new int[]{5,4,3,2,1};
		BubbleSort test = new BubbleSort();
		test.bubblesort(arr);
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]);
	}

}
