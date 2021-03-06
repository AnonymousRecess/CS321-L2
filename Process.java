import java.util.Random;
/**
 *This class specifies processes with priorities, timeRemaining, arrivalTime and timeNotProcessed
 * @author Jeff Kahn
 * @version 1.0
 * @since 2-7-2020
 */
public class Process implements Comparable<Process> {

	Random rand = new Random();
	private int priority, timeRemaining, arrivalTime, timeNotProcessed;
		public Process(int currentTime, int maxProcessTime, int maxLevel)
		{
			this.priority = rand.nextInt((maxLevel-1) + 1) +1;
			this.timeRemaining = rand.nextInt((maxProcessTime-1)+1)+1;
			this.arrivalTime = currentTime;
			this.timeNotProcessed = 0;
		}
	public int getTimeRemaining()
	{
		return timeRemaining;
	}
	public int getPriority()
	{
		return priority;
	}
	public int getArrivalTime()
	{
		return arrivalTime;
	}
	
	/**
	 * Returns -1 if smaller, and 1 if larger
	 * @param p - Priority to be compared
	 */
	public int compareTo(Process p) {
		if(this.priority == p.priority)
		{
			if(this.arrivalTime <= p.arrivalTime)
				return 1;
			else
				return -1;
		}
		else if(this.priority > p.priority)
			return 1;
		else
			return -1;
		
	}
	/**
	 * Tests if process is finished
	 */
	public boolean finish()
	{
		return(timeRemaining == 0);
	}
	public void reduceTimeRemaining()
	{
		timeRemaining--;
	}
	public void resetTimeNotProcessed()
	{
		this.timeNotProcessed = 0;
	}
	public void incrementTimeNotProcessed()
	{
		this.timeNotProcessed++;
	}
	public int getTimeNotProcessed()
	{
		return timeNotProcessed;
	}
	public void increasePriority()
	{
		this.priority++;
	}
}
