class HeapSort
{
	public static void Simple_Heap_Sort(int[] I)
	{
		BinaryHeap heap = new BinaryHeap();
		//construct heap takes O( n log n )
		for(int i=0;i<I.length;i++)
			heap.insert(I[i]);
		for(int i=0;i<I.length;i++)
			I[i]=heap.removeMin();
	}
	private static void bottomUpHeap(int[] I)
	{
		
	}
}