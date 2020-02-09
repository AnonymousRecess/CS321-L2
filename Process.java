public class Process
{
	private static int arrivalTime;
	private static int priority;
	private int timeRemaining;
	private int timeNotProcessed;

	public Process(int arrTime, int timeRem, int pri){
		arrivalTime = arrTime;
		timeRemaining = timeRem;
		priority = pri;
		timeNotProcessed = 0;
	}

	public static int getArrivalTime()
	{
		int retVal = arrivalTime;
		return retVal;
	}
	public static int getPriority() 
	{
		return priority;
	}
	public static void incrementPriority() 
	{
		priority++;
	}
	public int compareTo(Process otherProc)
	{
		return 0;
	}
	public void resetTimeNotProcessed()
	{
		timeNotProcessed = 0;
	}
}
