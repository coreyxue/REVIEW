package slist;
public class SListNode {
	public Object item;
	public SListNode next;
	
	public SListNode(Object item)
	{
		this.item = item;
		this.next = null;
	}
	public SListNode(Object item,SListNode node)
	{
		this.item = item;
		this.next = node;
	}

}
