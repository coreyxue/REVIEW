package slist;

public class SList {
	private SListNode head;
	private SListNode tail;
	private int length;
	
	public SList()
	{
		head = null;
		tail = head;
		this.length = 0;
	}
	public Object append(Object item)
	{
		if(tail!=null)
		{
			tail.next=new SListNode(item);
			tail = tail.next;
		}
		else
		{
			tail = new SListNode(item);
			head = tail;
		}
		this.length++;
		return tail;
	}
	public boolean insert(Object item, int index)
	{
		if(index<0||index>this.length-1)
			return false;
		if(index == 0)
		{
			SListNode temp = head;
			head = new SListNode(item);
			head.next = temp;
			this.length++;
			return true;
		}
		SListNode cur = head;
		int i=0;
		while(cur!=null)
		{
			if(i == index-1)
			{
				cur.next = new SListNode(item,cur.next);
				this.length--;
				return true;
			}
			i++;
		}
		return false;
	}
	public boolean delete(Object item)
	{
		SListNode pre = null;
		SListNode cur = head;
		while(cur!=null)
		{
			if(cur.item==item)
			{
				//special case there is only one element
				if(pre == null)
				{
					head = head.next;
					cur = null;
					this.length--;
					return true;
				}
				pre.next = cur.next;
				this.length--;
				return true;
			}
			pre = cur;
			cur = cur.next;
		}
		return false;
	}
	public int size()
	{
		return this.length;
	}
}
