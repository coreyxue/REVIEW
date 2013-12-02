import java.util.*;
/*
 Merge Sort runs O(nlog(n))
 */
public class Merge {
	//start index s, end index e(exclusive)
	private static int[] partition(int[] arr,int s,int e)
	{
		int[] new_arr = new int[e-s];
		for(int i=s,j=0;i<e;i++,j++)
			new_arr[j] = arr[i];
		return new_arr;
	}
	private static int[] catenate(int a,int[] arr)
	{
		int[] new_arr = new int[arr.length+1];
		new_arr[0] = a;
		for(int i=0;i<arr.length;i++)
			new_arr[i+1] = arr[i];
		return new_arr;
	}
	public static int[] Mergesort(int[] a)
	{
		if(a.length<=1)
			return a;
		
		return merge(Mergesort(partition(a,0,a.length/2)),Mergesort(partition(a,a.length/2,a.length)));
	}
	public static int[] merge(int[] arr1,int[] arr2)
	{
		if(arr1.length==0)
			return arr2;
		if(arr2.length==0)
			return arr1;
		if(arr1[0]>arr2[0])
			return catenate(arr2[0],merge(arr1,partition(arr2,1,arr2.length)));
		else
			return catenate(arr1[0],merge(partition(arr1,1,arr1.length),arr2));
	}
	public static int[] iter_merge(int[] arr1,int[] arr2)
	{
		int size = arr1.length+arr2.length;
		int[] new_arr = new int[size];
		//int iteration = arr1.length>arr2.length? arr2.length:arr1.length;
		int index1 = 0,index2 = 0;
		for(int i=0;i<size;i++)
		{
			if(index1==arr1.length)
			{
				for(int j=index2;j<arr2.length;j++)
					new_arr[i++] = arr2[j];
				break;
			}
			if(index2==arr2.length)
			{
				for(int j=index1;j<arr1.length;j++)
					new_arr[i++] = arr1[j];
				break;
			}
			if(arr1[index1]<arr2[index2])
				new_arr[i] = arr1[index1++];
			else
				new_arr[i] = arr2[index2++];
		}
		return new_arr;
	}
}
