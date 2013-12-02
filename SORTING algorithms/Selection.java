class Selection
{
	/*
	 * Selection sort runs O(n^2)
	 */
	public static void Selection_sort(int []I)
	{
		int S=0;
		int min=I[0];
		int min_index=0;
		int temp;
		for(int i=0;i<I.length;i++)
		{
			min=I[i];
			min_index=i;
			for(int j=i;j<I.length;j++)
			{
				if(I[j]<min)
				{
					min=I[j];
					min_index=j;
				}
			}
			temp=I[S];
			I[S++]=min;
			I[min_index]=temp;
		}
	}
}