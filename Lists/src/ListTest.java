import static org.junit.Assert.*;

import org.junit.Test;


public class ListTest {

	@Test
	public void test() {
		List my_list = new List();
		my_list.append(1);
		my_list.append(1);
		my_list.append(1);
		my_list.append(1);
		my_list.append(1);
		my_list.append(1);
		my_list.append(1);
		my_list.append(1);
		my_list.append(1);
		my_list.append(1);
		my_list.append(1);
		my_list.append(1);
		my_list.append(1);
		my_list.append(1);
		my_list.append(1);
		my_list.insert(2, 5);
		//my_list.print();
		//my_list.delete(2);
		my_list.print();
		System.out.println(my_list.length());
	}

}
