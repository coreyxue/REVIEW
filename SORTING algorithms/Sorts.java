import java.util.*;
class Sorts
{
	private static Random random;
	final static int num=10;
	public static void main(String []Str)
	{
		int [] I=new int [num];
		ArrayList<Integer> I2 = new ArrayList<Integer>();
		for(int i=0;i<num;i++)
		{
			I[i]=randInt(10);
			I2.add(I[i]);
			System.out.print(I[i]+" ");
			//System.out.print(I2.get(i)+" ");
		}
		
		 
		//I[0]=7;
		//I[1]=3;
		//I[2]=9;
		//I[3]=5;
		//I[4]=4;
												
		//Selection.Selection_sort(I);
		//Quick.Quicksort(I, 0, I.length-1);
		//I2 = Quick.Quicksort_rec(I2);
		//I = Merge.Mergesort(I);
		Insertion.Insertion_sort(I);
		System.out.print("\n");
		for(int i=0;i<num;i++)
		{
			System.out.print(I[i]+" ");
			//System.out.print(I2.get(i)+" ");
		}
	}
	private static int randInt(int choices) {
	    if (random == null) {
	      random = new Random();
	    }
	    int r = random.nextInt() % choices;
	    if (r < 0) {
	      r = -r;
	    }
	    return r;
	  }
}