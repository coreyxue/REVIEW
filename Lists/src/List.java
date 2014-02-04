
public class List {
	private Object[] array;
	private int size;
	private int num_elements;
	
	public List()
	{
		this.num_elements = 0;
		size = 10;
		this.array = new Object[size];
	}
	public List(int s)
	{
		this.num_elements = 0;
		size = s;
		this.array = new Object[size];
	}
	private boolean allocation_need()
	{
		if(this.num_elements==size)
			return true;
		return false;
	}
	public Object append(Object item)
	{
		if(allocation_need())
		{
			this.size*=2;
			Object[] temp = new Object[size];
			int i=0;
			for(Object o : this.array)
				temp[i++] = o;
			this.array = temp;
		}
		this.array[this.num_elements] = item;
		this.num_elements++;
		return this.array[this.num_elements-1];
	}
	public boolean insert(Object item, int index)
	{
		if(index<0||index>this.num_elements-1)
			return false;
		if(allocation_need())
		{
			this.size*=2;
			Object[] temp = new Object[size];
			for(int i=num_elements,j=i+1;i>0;i--,j--)
			{
				if(i==index)
				{
					temp[j] = item;
					j=i;
				}
				temp[j] = this.array[i];
			}
		}
		else
		{
			for(int i=num_elements-1;i>=0;i--)
			{
				this.array[i+1]=this.array[i];
				if(i==index)
				{
					this.array[i]=item;
					break;
				}
			}
		}
		this.num_elements++;
		return true;
	}
	public boolean delete(Object del_item)
	{
		for(int i=0;i<this.num_elements;i++)
		{
			if(this.array[i]==del_item)
			{
				for(int j=i;j<this.num_elements-1;j++)
					this.array[j]=this.array[j+1];
				this.num_elements--;
				return true;
			}
		}
		return false;
	}
	public void print()
	{
		for(int i=0;i<this.num_elements;i++)
		{
			System.out.print(this.array[i]);
			System.out.print(" ");
		}
	}
	public int length()
	{
		return this.num_elements;
	}
	public boolean is_empty()
	{
		return this.num_elements==0;
	}

}
