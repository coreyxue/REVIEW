import java.util.*;
public class all_permutation {
	//O(n!) base on a -> ab,ba -> abc acb cab, bac bca cba
	public ArrayList<String> get_permutations(String set)
	{
		if(set.length()==1)
		{
			ArrayList<String> result = new ArrayList<String>();
			result.add(set);
			return result;
		}
		char new_element = set.charAt(0);
		ArrayList<String> result = get_permutations(set.substring(1, set.length()));
		ArrayList<String> new_result = new ArrayList<String>();
		ArrayList<String> temp;
		for(String element:result)
		{
			temp = generate_new_elements(element,new_element);
			new_result.addAll(temp);
		}
		return new_result;
	}
	//this function does insertions between each char in element
	public ArrayList<String> generate_new_elements(String element,char new_element)
	{
		ArrayList<String> all_perm = new ArrayList<String>();
		StringBuffer temp = new StringBuffer();
		for(int i=0;i<element.length()+1;i++)
		{
			for(int j=0;j<i;j++)
				temp.append(element.charAt(j));
			temp.append(new_element);
			for(int j=i;j<element.length();j++)
				temp.append(element.charAt(j));
			all_perm.add(temp.toString());
			temp.setLength(0);
		}
		return all_perm;
	}
}
