
/**
 *This class holds the queue data structure containing priorities
 * @author Jeff Kahn
 * @version 1.0
 * @since 2-7-2020
 */
public class PQueue {
	private int size = 24; 
	private Process[] priorityQueue;
	MaxHeap maxHeap;
	private int length =0;
	public PQueue() {
		priorityQueue = new Process[size];

		maxHeap = new MaxHeap();
	}
	/**
	 * Adds process to queue/heap
	 * @param p - Process to be added to queue
	 */
	public void enPQueue(Process p)
	{
		isFull();
		maxHeap.MaxHeapInsert(priorityQueue, p);
		length++;
	}
	/**
	 * Extracts max element from queue/heap
	 * @param p - Process to be extracted from queue
	 */
	public Process dePQueue() 
	{
		length--;
			return (maxHeap.ExtractMax(priorityQueue));
			
	}
	/**
	 * Tests if queue is empty
	 */
	public boolean isEmpty()
	{
		if(0 == length)
		return true;
		else
			return false;
	}
	
	/**
	 * Tests if queue is full and doubles size if it is
	 */
	public void isFull()
	{
		if(size == length)
		{
			size = size*2;
			Process[] temp = new Process[size];
			System.arraycopy(priorityQueue, 0, temp, 0, size/2);
			priorityQueue = temp;
		}
	}
	/**
	 * Updates timeNotProcessed for Processes that didn't receive CPU time
	 */
	public void update(int timeToIncrement, int maxLevel)
	{
		if(maxHeap.getLength() == -1)
		{
			return;
		}
		for (int i = 0; i <= maxHeap.getLength(); i++)
		{
			priorityQueue[i].incrementTimeNotProcessed();
			int timeNotProcessed = priorityQueue[i].getTimeNotProcessed();
			if(timeNotProcessed >= timeToIncrement)
			{
				priorityQueue[i].resetTimeNotProcessed();
				
				if(priorityQueue[i].getPriority() < maxLevel)
				{
					priorityQueue[i].increasePriority();
					maxHeap.MaxHeapifyUp(priorityQueue, i);
				}
			}
		}
	}
	
}
