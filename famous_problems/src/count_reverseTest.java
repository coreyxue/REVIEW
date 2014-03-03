import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class count_reverseTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		count_reverse test = new count_reverse();
		count_reverse.fit_array A = new count_reverse.fit_array();
		A.arr.add(1);
		A.arr.add(2);
		count_reverse.fit_array B = new count_reverse.fit_array();
		B.arr.add(0);
		B.arr.add(3);
		count_reverse.fit_array C = new count_reverse.fit_array();
		C = test.merge(A, B);
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(4);
		arr.add(3);
		arr.add(2);
		arr.add(1);
		C = test.counting_reverse(arr);
		System.out.print(C.count);
	}

}
