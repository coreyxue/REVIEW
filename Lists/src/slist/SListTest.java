package slist;

import static org.junit.Assert.*;

import org.junit.Test;

public class SListTest {

	@Test
	public void test() {
		SList my_list = new SList();
		my_list.append(1);
		my_list.append(2);
		my_list.append(4);
		my_list.insert(3, 2);
		my_list.print();
	}

}
