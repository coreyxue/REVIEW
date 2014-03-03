import java.util.*;
public class count_reverse {
	public static class fit_array{
		public ArrayList<Integer> arr= new ArrayList<Integer>();
		public int count;
	}
	//runs in O(n log n)
	public fit_array counting_reverse(ArrayList<Integer> arr)
	{
		if(arr.size()<=1)
		{
			fit_array temp = new fit_array();
			temp.count=0;
			temp.arr = arr;
			return temp;
		}
		ArrayList<Integer> part1 = new ArrayList<Integer>();
		ArrayList<Integer> part2 = new ArrayList<Integer>();
		for(int i=0;i<arr.size();i++)
		{
			if(i<arr.size()/2)
				part1.add(arr.get(i));
			else
				part2.add(arr.get(i));
		}
		return merge(counting_reverse(part1),counting_reverse(part2));
	}
	public fit_array merge(fit_array A, fit_array B)
	{
		int i=0;
		fit_array partial = new fit_array();
		partial.count = A.count+B.count;
		for(int j=0;j<B.arr.size();j++)
		{
			if(i>=A.arr.size())
			{
				partial.arr.addAll(B.arr.subList(j, B.arr.size()));
				break;
			}
			if(B.arr.get(j) < A.arr.get(i))
			{
				partial.count+=A.arr.size()-i;
				partial.arr.add(B.arr.get(j));
			}
			else
			{
				partial.arr.add(A.arr.get(i));
				i++;
				j--;
			}
		}
		partial.arr.addAll(A.arr.subList(i, A.arr.size()));
		return partial;
	}

}
