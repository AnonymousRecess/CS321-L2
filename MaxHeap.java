import java.util.*;

public class MaxHeap {
	private int left=0;
	private int right=0;
	private int last = -1;
	private Process largest;
	private int heapsize =0;
	private Process[] A;
	public MaxHeap(){
		
	}

	public Process[] Build_Array1() //Build initial array
	{
		int heapsize = 20;
		A = new Process[heapsize];
		return A;
	}
	
	public Process[] Build_Array2() //if heapsize exceeds initial heapsize, build larger and copy array
	{
		Process [] B;
		int heapsize = heapsize*2;
		B = new Process[heapsize];
		for(int i = 0; i < A.length; i++)
		{
			B[i] = A[i];
		}
		return B;
	}
	
	public void Build_Max_Heap()
	{
		{
			for (int i=0; i<heapsize/2;i++)
				Max_Heapify_Down(i);
		}
	}

	public void Max_Heapify_Down(int i)
	{
		largest = i;
		left = 2 * i + 1;
		right = 2 * i + 2;
		if (left < heapsize)
		{
			if (A[left] > A[i])
				largest = left;
		}
		if (right < heapsize)
		{
			if (A[right] > A[largest])
				largest = right;
		}
		if (largest !=i)
		{
			swap (A[largest],A[i]);
			Max_Heapify_Down(largest);
		}
	}
	
	public void Heapify_Up(int i) 
	{
		if (i<0) return;
		if(A[i]>=heapsize) return;
		A[i] = heapsize
				
	}

	public void add(Process newProc) {
		heapsize++;
		if(heapsize > A.length) {
			A = Build_Array2();
		}
		last++;
		A[last] = newProc;
		Heapify_Up(last);
	}
	
	public Process removeProcess() 
	{
		
		if (A.length == 0)
		{
		}
		Process F = A[1];
		A[1]=A[heapsize];
		A[heapsize] = F;
		swap(1,heapsize);
		heapsize -=1;
		Max_Heapify_Down(heapsize);
	}
	public void swap(int index_A,int index_B)
	{
		Process F = A[index_A];
		A[index_A] = A[index_B];
		A[index_B] = F;
	}
}
