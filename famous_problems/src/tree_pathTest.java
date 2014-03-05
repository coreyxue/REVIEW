import static org.junit.Assert.*;

import org.junit.Test;
import Tree.*;
import java.util.*;
public class tree_pathTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		//BinaryTree my_tree = new BinaryTree();
		//for(int i=0;i<10;i++)
		//	my_tree.insert_node(i);
		BST my_tree = new BST();
		my_tree.insert_node(5);
		my_tree.insert_node(3);
		my_tree.insert_node(7);
		my_tree.insert_node(6);
		//my_tree.insert_node(4);
		tree_path test = new tree_path();
		test.get_all_path(my_tree.get_root());
		for(int i=0;i<test.results.size();i++)
		{
			for(int j=0;j<test.results.get(i).size();j++)
				System.out.print(test.results.get(i).get(j));
			System.out.println();
		}
	}

}
