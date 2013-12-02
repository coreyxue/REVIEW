class Insertion
{
	/*
	 * Insertion sort runs O(n^2)
	 */
	// first attempt
	public static void Insertion_sort2(int[] I)
	{
		int s=0,j; //s is the sorted index(index of the last sorted element)
		int temp;
		for(int i=1;i<I.length;i++)
		{
			temp=I[i];   //temp is the item we want to insert
			for( j=s;j>=0;j--)  //looking for right place to insert(backward)
			{
				if(I[j]<=temp)  //found the right place
				{
					I[j+1]=temp;
					s++;
					break;
				}
				I[j+1]=I[j]; //move element behind
				if(j==0)  //handle insert front
				{
					I[j]=temp;
					s++;
					break;
				}
			}
		}
	}
	//more readable version
	public static void Insertion_sort(int[] arr)
	{
		int sorted_index=0;
		int unsorted_index=1;
		for(int i=unsorted_index;i<arr.length;i++)
		{
			int temp = arr[i];
			for(int j=sorted_index;j>=0;j--)
			{
				if(arr[j]>temp)
					arr[j+1] = arr[j];
				else
				{
					arr[j+1] = temp;
					sorted_index++;
					break;
				}
				if(j==0)
				{
					sorted_index++;
					arr[0] = temp;
					//break;
				}
			}
		}
	}
}