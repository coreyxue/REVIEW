package Tree;
import java.util.*;
public class BinaryTree {
	public TreeNode root;
	//insert_node in lv_order
	public void insert_node(int d)
	{
		if(root == null)
		{
			root = new TreeNode(d);
			return;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while(true)
		{
			TreeNode temp = q.poll();
			if(temp.left==null)  //only work for binary trees
			{
				temp.left = new TreeNode(d);
				break;
			}
			else if(temp.right==null)
			{
				temp.right = new TreeNode(d);
				break;
			}
			else
			{
				q.add(temp.left);
				q.add(temp.right);
			}
		}
	}
	public void inorder(TreeNode Node)
	{
		if(Node.left!=null)
			inorder(Node.left);
		System.out.print(Node.data);
		if(Node.right!=null)
			inorder(Node.right);
	}
	public void lvorder()
	{
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		TreeNode temp;
		while(q.size()!=0)
		{
			temp = q.poll();
			System.out.print(temp.data);
			if(temp.left!=null)
			{
				q.add(temp.left);
			}
			if(temp.right!=null)
			{
				q.add(temp.right);
			}
		}
	}
}
