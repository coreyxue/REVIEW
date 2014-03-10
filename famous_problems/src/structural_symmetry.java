import Tree.*;
import java.util.*;
public class structural_symmetry {
	//dummy code to check if a binary tree is structural symmetry
	public ArrayList<Integer> list1 = new ArrayList<Integer>();
	public ArrayList<Integer> list2 = new ArrayList<Integer>();
	
	public boolean symmetry(TreeNode root)
	{
		if(root == null)
			return true;
		left_sub(root.left);
		right_sub(root.right);
		if(list1.size()!=list2.size())
			return false;
		for(int i=0;i<list1.size();i++)
			if(list1.get(i)!=list2.get(i))
				return false;
		return true;
	}
	public void left_sub(TreeNode Node)
	{
		if(Node==null)
			return;
		if(Node.left!=null)
		{
			list1.add(1);
			left_sub(Node.left);
		}
		if(Node.right!=null)
		{
			list1.add(2);
			left_sub(Node.right);
		}
	}
	public void right_sub(TreeNode Node)
	{
		if(Node==null)
			return;
		if(Node.right!=null)
		{
			list2.add(1);
			left_sub(Node.right);
		}
		if(Node.left!=null)
		{
			list2.add(2);
			left_sub(Node.left);
		}
	}
	public void print()
	{
		System.out.println();
		for(int i=0;i<list1.size();i++)
			System.out.print(list1.get(i));
		System.out.println();
		for(int i=0;i<list2.size();i++)
			System.out.print(list2.get(i));
	}
}
