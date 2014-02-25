import java.math.BigInteger;


public class pascal_triangle {
	//my version
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
	//lecture version
	public int[][] construct_triangle(int n)
	{
		int[][] pt = new int[n][];
		for(int i=0;i<n;i++)
		{
			pt[i] = new int[i+1];
			pt[i][0] = 1;
			for(int j=1;j<i;j++)
			{
				pt[i][j] = pt[i-1][j-1]+pt[i-1][j];
			}
			pt[i][i] = 1;
		}
		return pt;
	}
	//get the element of mth row nth col,time O(n^2) space O(n)
	public int get_mn(int m, int n)
	{
		int[] pre;
		int[] cur;
		pre = new int[1];
		pre[0]=1;
		cur = new int[2];
		cur[0]=1;cur[1]=1;
		for(int i=3;i<=m;i++)
		{
			pre = cur;
			cur = new int[i];
			cur[0]=1;
			for(int j=1;j<i-1;j++)
				cur[j] = pre[j]+pre[j-1];
			cur[i-1]=1;
		}
		return cur[n];
		
	}
    public int solution(int[] A) {
        // write your code in Java SE 6
        BigInteger sum = new BigInteger("0");
        BigInteger b_point = new BigInteger("0");
        for(int i=0;i<A.length;i++)
            sum = sum.add(new BigInteger(""+A[i]));
        for(int i=A.length-1;i>0;i--){
            if(sum.subtract(new BigInteger(""+A[i-1]))==new BigInteger(""+b_point))
                return A[i-1];
            sum = sum.subtract(new BigInteger(""+A[i]));
            b_point= b_point.add(new BigInteger(""+A[i]));
        }
        return 0;
    }

}

