package Tree;

import java.util.*;
import java.util.Stack;

public class main {
	public static void main(String[] arg)
	{
		//BinaryTree my_tree = new BinaryTree();
		
		BST my_tree = new BST();
		//TreeNode root = my_tree.root;
		/*int[] sorted_list = new int[7];
		for(int i = 0; i<7; i++)
			sorted_list[i] = i+1;*/
		
		//TreeNode s,d;
		//s=my_tree.insert_node(5);
		my_tree.insert_node(3);
		my_tree.insert_node(4);
		my_tree.insert_node(1);
		my_tree.insert_node(0);
		my_tree.insert_node(7);
		my_tree.insert_node(6);
		my_tree.insert_node(8);
		//ArrayList<LinkedList<TreeNode>> all_list = new ArrayList<LinkedList<TreeNode>>();
		//offical_linked_lv(my_tree.root,0,all_list);
		
		//System.out.print(check_diff(my_tree.root));
		//System.out.print(dfs_tree(s,d));
		//ArrayList<LinkedList<TreeNode>> all_list = linked_lv(s);
		/*for(int i=0;i<all_list.size();i++)
		{
			System.out.print("\nlv "+ i + ":\n");
			for(int j=0;j<all_list.get(i).size();j++)
				System.out.print(all_list.get(i).get(j).data);
		}*/
		//t.construct_tree(t.root);
		/*t.insert(5);
		t.insert(3);
		t.insert(2);
		t.insert(4);
		t.insert(7);
		t.insert(6);
		t.postorder(t.root);
		t.inorder(t.root);*/
		//t.insert(8);
		///t.insert(9);
		//t.preorder(t.root);
		//t.postorder(t.root);
		//t.inorder(t.root);
		//System.out.print(t.max_num_lv(t.root));
		//System.out.print(t.min_num_lv(t.root));
		//System.out.print(t.check_bal());
		
		BinaryTree bt = new BinaryTree();
		bt.insert_node(1);
		bt.insert_node(2);
		bt.insert_node(3);
		bt.insert_node(4);
		bt.insert_node(5);
		bt.insert_node(6);
		bt.insert_node(7);
		bt.insert_node(8);
		System.out.println(wiki_is_BST(bt.root));
		//bt.inorder(bt.root);
		//System.out.print(max_sum(bt.root));
		//bt.lvorder();
		//coreys_iterative_inorder(my_tree.root);
	}
	public static void offical_linked_lv(TreeNode nood,int lv, ArrayList<LinkedList<TreeNode>> all_lists)
	{
		if(nood == null)
			return;
		if(lv<all_lists.size())
			all_lists.get(lv).add(nood);
		else
		{
			LinkedList<TreeNode> new_list = new LinkedList<TreeNode>();
			new_list.add(nood);
			all_lists.add(new_list);
		}
		offical_linked_lv(nood.left,lv+1,all_lists);
		offical_linked_lv(nood.right,lv+1,all_lists);
	}
	public static boolean is_BST(TreeNode nood)
	{
		ArrayList<TreeNode> my_stack = new ArrayList<TreeNode>();
		my_stack.add(0, nood);
		TreeNode pre = null;
		while(!my_stack.isEmpty())
		{
			if(my_stack.get(0).left!=null && my_stack.get(0).left!=pre)
				my_stack.add(0, my_stack.get(0).left);
			else
			{
				TreeNode n = my_stack.remove(0);
				if(pre!=null && pre.data > n.data)
					return false;
				pre = n;
				if(n.right!=null)
					my_stack.add(0,n.right);
			}
		}
		return true;
	}
	public static boolean wiki_is_BST(TreeNode node)
	{
		TreeNode pre = null;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		while(!stack.isEmpty()||node!=null)
		{
			if(node!=null)
			{
				stack.add(0,node);
				node=node.left;
			}
			else
			{
				TreeNode n = stack.remove(0);
				if(pre!=null && pre.data > n.data)
					return false;
				pre = n;
				node = n.right;
			}
		}
		return true;
	}
	public static void coreys_iterative_inorder(TreeNode node)
	{
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.add(0,node);
		TreeNode pre = null;
		while(!stack.isEmpty())
		{
			if(stack.get(0).left!=null && pre!=stack.get(0).left)
				stack.add(0,stack.get(0).left);
			else
			{
				TreeNode n = stack.remove(0);
				System.out.print(n.data);
				pre = n;
				if(n.right!=null)
					stack.add(0,n.right);
			}
		}
	}
	public static ArrayList<LinkedList<TreeNode>> linked_lv(TreeNode s)
	{
		ArrayList<LinkedList<TreeNode>> all_list = new ArrayList<LinkedList<TreeNode>>();
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		ArrayList<Integer> lv_list = new ArrayList<Integer>();
		LinkedList<TreeNode> pre_nodes = new LinkedList<TreeNode>();
		
		list.add(s);
		lv_list.add(0);
		int temp_lv;
		
		while(!list.isEmpty())
		{
			TreeNode temp = list.remove(0);
			pre_nodes.add(temp);
			temp_lv = lv_list.remove(0);
			if(lv_list.isEmpty() || temp_lv!=lv_list.get(0))
			{
				all_list.add(pre_nodes);
				pre_nodes = new LinkedList<TreeNode>();
			}
			if(temp.left!=null)
			{
				list.add(temp.left);
				lv_list.add(temp_lv+1);
			}
			if(temp.right!=null)
			{
				list.add(temp.right);
				lv_list.add(temp_lv+1);
			}
		}
		return all_list;
	}
	
	public static boolean dfs_tree(TreeNode s,TreeNode d)
	{
		java.util.Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(s);
		TreeNode temp;
		while(!stack.empty())
		{
			temp = stack.pop();
			if(temp==d)
				return true;
			if(temp.left!=null)
				stack.push(temp.left);
			if(temp.right!=null)
				stack.push(temp.right);
		}
		return false;
	}
	public static int max_sum(TreeNode node)
	{
		if(node.left==null && node.right == null)
			return node.data;
		if(node.right == null)
			return node.data+max_sum(node.left);
		else if(node.left == null)
			return node.data+max_sum(node.right);
		return node.data+Math.max(max_sum(node.left),max_sum(node.right));
		
	}
	public static int max(int a,int b)
	{
		if(a>b)
			return a;
		return b;
	}
	public static int min(int a,int b)
	{
		if(a<b)
			return a;
		return b;
	}
	public static int max_dep(TreeNode node)
	{
		if(node==null)
			return 0;
		return 1+max(max_dep(node.left),max_dep(node.right));
	}
	public static int min_dep(TreeNode node)
	{
		if(node==null)
			return 0;
		return 1+min(min_dep(node.left),min_dep(node.right));
	}
	public static boolean check_diff(TreeNode node)
	{
		if(max_dep(node)-min_dep(node)>1)
			return false;
		return true;
	}
}
