import java.util.*;
public class counting_change {
	private int[] values = new int[]{1,5,10};
	private HashMap<Integer,Integer> dp_map = new HashMap<Integer,Integer>();
	//number of ways to change n using values, runs in O(values.size^n)
	public int count(int n)
	{
		if(n<0)
			return 0;
		if(n==0)
			return 1;
		int sum =0;
		for(int v:values)
			sum+=count(n-v);
		return sum;
	}
	//with dp, runs in linear time
	public int count_dp(int n)
	{
		if(n<0)
			return 0;
		if(n==0)
			return 1;
		if(this.dp_map.get(n)!=null)
			return this.dp_map.get(n);
		int sum =0;
		for(int v:values)
			sum+=count(n-v);
		this.dp_map.put(n, sum);
		return this.dp_map.get(n);
	}
	private int min(int a, int b)
	{
		return a<b?a:b;
	}
	//minimum ways to change n
	public int change(int n)
	{
		if(n<0)
			return 0;
		if(n==0)
			return 0;
		return min(change(n-1)+1,change(n-5)+1);
		
	}
}
