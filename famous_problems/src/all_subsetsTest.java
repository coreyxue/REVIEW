import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class all_subsetsTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		all_subsets test = new all_subsets();
		char[] arr = new char[]{'a','b','c','d'};
		ArrayList<String> result = new ArrayList<String>();
		result = test.get_all_subsets(arr);
		System.out.print(result);
		
	}

}
