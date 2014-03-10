import java.util.*;

import Tree.*;
public class tree_path {
	public ArrayList<LinkedList<Integer>> results = new ArrayList<LinkedList<Integer>>();
	public LinkedList<Integer> one_result = new LinkedList<Integer>();
	//return all tree pathes from the root
	public void get_all_path(TreeNode root)
	{
		if(root==null)
			return;
		one_result.add(root.data);
		if(root.left==null && root.right==null)
		{
			results.add((LinkedList<Integer>) one_result.clone());
			return;
		}
		if(root.left!=null)
		{
			get_all_path(root.left);
			one_result.remove(one_result.size()-1);
		}
		if(root.right!=null)
		{
			get_all_path(root.right);
			one_result.remove(one_result.size()-1);
		}
	}
}
