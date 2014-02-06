import java.util.*;

public class Quick {
	/* In-place quick sort runs O(n log(n)) on average, worst case O(n^2) for pivot happens to always be
	 *  the smallest or largest element, space O(log n) call stacks
	 */
	public static void Quicksort(int[] a,int low,int high)
	{
		if(low<high) // base case
		{
			Random random = new Random();
			int pivot_index = random.nextInt(high-low)+low; // pick a pivot, usually pick randomly
			int pivot = a[pivot_index]; 
			a[pivot_index] = a[high];   // swap pivot and the last element
			a[high] = pivot;
			
			int i = low-1;
			int j = high;
			do {
				do {i++;} while(a[i]<pivot);  // increment i until sees an element which greater than the pivot
				do {j--;} while(a[j]>pivot && j>low); //decrement j until sees an element which less than the pivot
				if(i<j){
					int temp = a[i];  // swap the two elements
					a[i] = a[j];
					a[j] = temp;
				}
			}while(i<j);
			a[high] = a[i]; //restore the pivot
			a[i] = pivot;
			Quicksort(a,low,i-1); // recursively sort the left half
			Quicksort(a,i+1,high); // recursively sort the right half
		}
	}
	/*
	 * Sample version of Quicksort, space complexity? hmm...
	 */
	public static ArrayList<Integer> Quicksort_rec(ArrayList<Integer> a)
	{
		if(a.size()==0)  //base case
		{
			return new ArrayList<Integer>();
		}
		ArrayList<Integer> middle = new ArrayList<Integer>();
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		Random random = new Random();
		int pivot_index = random.nextInt(a.size()); // pick a pivot, usually pick randomly
		int pivot = a.get(pivot_index);
		a.remove(pivot_index);
		middle.add(pivot);
		for(Integer i : a)
		{
			if(i>pivot)
				right.add(i);
			else if(i<pivot)
				left.add(i);
			else
				middle.add(i);
		}
		ArrayList<Integer> temp = Quicksort_rec(left);
		temp.addAll(middle);
		temp.addAll(Quicksort_rec(right));
		return temp;
	}
	public static Integer Quick_select(ArrayList<Integer> arr, int k)
	{
		if(k<=0||k>arr.size())
			return null;
		ArrayList<Integer> mid = new ArrayList<Integer>();
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		Random random = new Random();
		int pivot_index = random.nextInt(arr.size());
		Integer pivot = arr.get(pivot_index);
		
		for(int i=0;i<arr.size();i++)
		{
			if(arr.get(i) > pivot)	
				right.add(arr.get(i));
			else if(arr.get(i)<pivot)
				left.add(arr.get(i));
			else
				mid.add(arr.get(i));
		}
		if(left.size()>=k)
			return Quick_select(left,k);
		else if(k>left.size()+mid.size())
			return Quick_select(right,k-left.size()-mid.size());
		else
			return pivot;
	}
}
