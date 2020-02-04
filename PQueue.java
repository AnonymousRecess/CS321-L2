

public class PQueue {
	private int size = 24; 
	private Process[] priorityQueue;
	MaxHeap maxHeap;
	private int length =0;
	public PQueue() {
		priorityQueue = new Process[size];

		maxHeap = new MaxHeap();
	}

	public void enPQueue(Process p)
	{
		isFull();
		maxHeap.MaxHeapInsert(priorityQueue, p);
		length++;
	}
	
	public Process dePQueue() 
	{
		length--;
			return (maxHeap.ExtractMax(priorityQueue));
			
	}
	
	public boolean isEmpty()
	{
		if(0 == length)
		return true;
		else
			return false;
	}
	
	public void isFull()
	{
		if(size == length)
		{
			Process[] temp = new Process[size*2];
			System.arraycopy(priorityQueue, 0, temp, 0, size);
			priorityQueue = temp;
		}
	}
	
	public void update(int timeToIncrement, int maxLevel)
	{
		if(maxHeap.getLength() == 0)
		{
			return;
		}
		for (int i = 1; i < maxHeap.getLength(); i++)
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
