import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class QuickTest {

	@Test
	public void test() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(0);
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		
		System.out.print(Quick.Quick_select(arr,0));
	}

}
