import java.util.*;
public class all_subsets {
	//runs in O(2^n), using binary indicator
	public ArrayList<String> get_all_subsets(char[] arr)
	{
		int size = (int) Math.pow(2,arr.length);
		ArrayList<String> result = new ArrayList<String>();
		int indicator = 0;
		String temp= "";
		int index_tracker = 0;
		for(int i=1;i<=size;i++)
		{
			index_tracker = 0;
			while(indicator!=0)
			{
				int digit = 1&indicator;
				indicator = indicator>>1;
				if(digit==1)
					temp+=arr[index_tracker];
				index_tracker++;
			}
			result.add(temp);
			temp = "";
			indicator = i;
		}
		return result;
	}
	

}
