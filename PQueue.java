public class PQueue
{
	private MaxHeap heap = new MaxHeap();

	public PQueue(){
		
	}
	
	public void enPQueue(Process addprocess) //Adds new process to end of queue from CPU Scheduling
	{
		heap.add(addprocess);
	}
	public Process dePQueue() //Remove top of queue for handling
	{
		
		Process res = heap.removeProcess();
		return res;
	}
	public void update(int maxTime, int maxPrior)
	{
		 if ((Process.getArrivalTime()< maxTime) && (Process.getPriority() < maxPrior))
			 Process.incrementPriority();
			//if (Heap
	}

}
