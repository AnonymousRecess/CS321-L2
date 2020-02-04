
public class MaxHeap {
	private int heapSize;
	private Process[] priorityQueue;
	
	public void MaxHeapInsert(Process[] priorityQueue, Process p)
	{
		this.priorityQueue = priorityQueue;
		heapSize++;
		priorityQueue[heapSize] = p;
		MaxHeapifyUp(priorityQueue, heapSize);
	}
	
	public void MaxHeapifyUp(Process[] priorityQueue, int i)
	{
		double parent = Math.ceil(((1/2) *i));
		while( i > 0 && priorityQueue[i].compareTo(priorityQueue[(int) parent]) == 1)
		{
			swap(i, (int)parent);
			i = (int)parent;
		}
	}
	private void MaxHeapifyDown(Process[] priorityQueue, int i)
	{
		int l = (2*i +1);
		int r = (2*i + 2);
		int largest;
		if(l <= heapSize && priorityQueue[l].compareTo(priorityQueue[i]) == 1)
		{
			largest = l;
		}
		else
			largest = i;
		if(r<= heapSize && priorityQueue[r].compareTo(priorityQueue[i]) == 1)
		{
			largest = r;
		}
		if(largest != i)
		{
			swap(largest, i);
			MaxHeapifyDown(priorityQueue, largest);
		}
	}
	private void swap(int i, int parent)
	{
		Process temp;
		temp = priorityQueue[i];
		priorityQueue[i] = priorityQueue[parent];
		priorityQueue[parent] = temp;
	}
	public Process ExtractMax(Process[] priorityQueue) 
	{
		Process max;
		this.priorityQueue = priorityQueue;
		max = priorityQueue[0];
		priorityQueue[0] = priorityQueue[heapSize];
		heapSize--;
		MaxHeapifyDown(priorityQueue, 0);
		return max;
	}
}


