import java.util.Random;
import java.util.concurrent.TimeUnit;
public class ProcessGenerator
{
	private double probability;
	Random rand;
	public ProcessGenerator(double prob){
		probability = prob;
		rand = new Random();
	}	

	public Process getNewProcess(int time, int maxtime, int maxlevel)
	 //defines a process with time created, time until it should be run, and max priority level
	{
		int arrivalTime = (int) System.nanoTime();
		int timeRemaining = rand.nextInt(100);
		int priority = rand.nextInt(100);
		Process x = new Process (arrivalTime, timeRemaining, priority);
		return x;
	}
	public boolean query()
	{
		int result = rand.nextInt(100);
		if(result < ((probability*100))){
			return true;
		}
		return false;
	}


}