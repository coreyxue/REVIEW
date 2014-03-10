import static org.junit.Assert.*;

import org.junit.Test;
import Tree.*;

public class structural_symmetryTest {

	@Test
	public void test() {
		structural_symmetry test = new structural_symmetry();
		BST mytree = new BST();
		mytree.insert_node(6);
		mytree.insert_node(4);
		mytree.insert_node(5);
		mytree.insert_node(3);
		mytree.insert_node(8);
		mytree.insert_node(7);
		mytree.insert_node(9);
		mytree.insert_node(2);
		mytree.insert_node(1);
		mytree.insert_node(0);
		System.out.print(test.symmetry(mytree.get_root()));
		test.print();
	}

}
