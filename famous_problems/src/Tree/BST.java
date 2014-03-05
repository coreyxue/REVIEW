package Tree;

import java.util.HashSet;

public class BST {
	protected TreeNode root;
	public TreeNode get_root()
	{
		return root;
	}
	public void construct_tree(TreeNode node)
	{
		node.left = new TreeNode(node.data*node.data % 400);
		node.right = new TreeNode((node.data*node.data+1) % 400);
		if(node.left.data == 50 || node.right.data == 50)
			return;
		if(node.data != node.left.data)
			construct_tree(node.left);
		construct_tree(node.right);
	}
	public TreeNode insert_node(int d)
	{
		if(root == null)
		{
			root = new TreeNode(d);
			return root;
		}
		else
		{
			TreeNode cur = root;
			TreeNode next = root;
			while(true)
			{
				cur = next;
				if(cur.data < d)
				{
					next = cur.right;
					if(next == null)
					{
						cur.right = new TreeNode(d);
						return cur.right;
					}
				}
				else
				{
					next = cur.left;
					if(next == null)
					{
						cur.left = new TreeNode(d);
						return cur.left;
					}
				}
			}
		}
	}
	public void preorder(TreeNode Node)
	{
		System.out.print(Node.data);
		if(Node.left!=null)
			preorder(Node.left);
		if(Node.right!=null)
			preorder(Node.right);
	}
	public void inorder(TreeNode Node)
	{
		if(Node.left!=null)
			postorder(Node.left);
		System.out.print(Node.data);
		if(Node.right!=null)
			postorder(Node.right);
	}
	public void postorder(TreeNode Node)
	{
		if(Node==null)
			return;
		postorder(Node.left);
		postorder(Node.right);
		System.out.print(Node.data);
	}
	public int max_num_lv(TreeNode node)
	{
		if(node == null)
			return 0;
		return 1+Math.max(max_num_lv(node.left),max_num_lv(node.right));
	}
	public int min_num_lv(TreeNode node)
	{
		if(node == null)
			return 0;
		return 1+Math.min(max_num_lv(node.left),max_num_lv(node.right));
	}
	public boolean check_bal()
	{
		return max_num_lv(root)-min_num_lv(root)<=1;
	}
}
