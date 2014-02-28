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
	//Recursion version, base on P(n-1)+"new_str" = P(n)
	public ArrayList<String> subsets_recur(ArrayList<String> arr)
	{
		ArrayList<String> temp = new ArrayList<String>();
		if(arr.size()==0)
		{
			temp.add("");
			return temp;
		}
		if(arr.size()>0)
		{
			String new_str = arr.remove(arr.size()-1);
			temp = this.subsets_recur(arr);
			ArrayList<String> with_new_str = new ArrayList<String>();
			for(String str:temp)
				with_new_str.add(str+new_str);
			temp.addAll(with_new_str);
		}
		return temp;
	}
	

}
