
public class pascal_triangle {
	public int[][] construc_triangle(int n)
	{
		int[][] pt = new int[n][];
		pt[0] = new int[1];
		pt[0][0] = 1;
		for(int i=1;i<n;i++)
		{
			pt[i] = new int[i+1];
			pt[i][0]=1;
			for(int j=1;j<i;j++)
			{
				pt[i][j] = pt[i-1][j-1]+pt[i-1][j];
			}
			pt[i][i]=1;
		}
		return pt;
	}
	public int get_mn(int m, int n)
	{
		int[] pre;
		int[] cur;
		
		
	}

}