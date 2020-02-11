/**
 *This class organizes the queue into a heap and contains methods to mantain the heap.
 * @author Jeff Kahn
 * @version 1.0
 * @since 2-7-2020
 */
public class MaxHeap {
	private int heapSize = -1;
	private Process[] priorityQueue;
	/**
	 * Inserts process into priorityQueue then sorts process
	 * @param priorityQueue - queue holding processes
	 * @param p - Process to be inserted and sorted
	 */
	public void MaxHeapInsert(Process[] priorityQueue, Process p)
	{
		this.priorityQueue = priorityQueue;
		
		heapSize++;
		priorityQueue[heapSize] = p;
		
		MaxHeapifyUp(priorityQueue, heapSize);
	}
	/**
	 * Compares process with parent, swaps if process is larger
	 * @param priorityQueue - queue holding processes
	 * @param i - index of compared Process
	 */
	public void MaxHeapifyUp(Process[] priorityQueue, int i)
	{
		double parent;
		if( i <= 0)
		{
			parent = 0;
		}
		else
		{
		parent = (i-1)/2;
		}
		while( i > 0 && priorityQueue[i].compareTo(priorityQueue[(int) parent]) == 1)
		{
			
			swap(i, (int)parent);
			i = (int)parent;
			parent = (i-1)/2;
		}
	}
	/**
	 * Compares left and right child, swapping with largest
	 * @param priorityQueue - queue holding processes
	 * @param i - index of compared Process
	 */
	private void MaxHeapifyDown(Process[] priorityQueue, int i)
	{
		int l = (2*i +1);
		int r = (2*i + 2);
		int largest =i;
		if(l <= heapSize && priorityQueue[l].compareTo(priorityQueue[largest]) == 1) //might be <=
		{
			largest = l;
		}
		if(r<= heapSize && priorityQueue[r].compareTo(priorityQueue[largest]) == 1) //might be <=
		{
			largest = r;
		}
		if(largest != i)
		{
			swap(largest, i);
			MaxHeapifyDown(priorityQueue, largest);
		}
	}
	/**
	 * Switches elements held within index i and index parent
	 * @param parent - parent of index i
	 * @param i - index of compared Process
	 */
	private void swap(int i, int parent)
	{
		Process temp;
		temp = priorityQueue[i];
		priorityQueue[i] = priorityQueue[parent];
		priorityQueue[parent] = temp;
	}
	/**
	 * Returns process at front of queue
	 * @param priorityQueue - queue holding processes
	 */
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
	public int getLength()
	{
		return heapSize;
	}
}


