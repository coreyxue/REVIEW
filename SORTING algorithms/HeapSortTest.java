import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class HeapSortTest {

	@Test
	public void test() {
		int [] I=new int [10];
		for(int i=0;i<10;i++)
		{
			I[i]=randInt(10);
			System.out.print(I[i]+" ");
		}
		HeapSort.Simple_Heap_Sort(I);
		System.out.print("\n");
		for(int i=0;i<10;i++)
		{
			System.out.print(I[i]+" ");
		}
	}
	private static int randInt(int choices) {
		Random random = new Random();
	    int r = random.nextInt() % choices;
	    if (r < 0) {
	      r = -r;
	    }
	    return r;
	  }

}
