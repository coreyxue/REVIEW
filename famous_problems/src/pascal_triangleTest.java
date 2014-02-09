import static org.junit.Assert.*;

import org.junit.Test;


public class pascal_triangleTest {

	@Test
	public void test() {
		pascal_triangle pt = new pascal_triangle();
		int[][] result = pt.construct_triangle(5);
		for(int i=0;i<result.length;i++)
		{
			for(int j=0;j<result[i].length;j++)
				System.out.print(result[i][j]);
			System.out.print("\n");
		}
		System.out.print(pt.get_mn(5, 1));
	}

}
