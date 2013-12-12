import static org.junit.Assert.*;

import org.junit.Test;

public class MERGESORTTest {

	@Test
	public void testIter_merge() {
		//fail("Not yet implemented");
		int[] test_arr;
		int[] arg_arr1 = new int[3];
		arg_arr1[0] = 1;arg_arr1[1] = 3;arg_arr1[2] = 5;
		int[] arg_arr2 = new int[3];
		arg_arr2[0] = 1;arg_arr2[1] = 4;arg_arr2[2] = 6;
		test_arr = MERGESORT.iter_merge(arg_arr1,arg_arr2);
		for(int i = 0;i<test_arr.length;i++)
			System.out.print(test_arr[i]+" ");
	}
}
