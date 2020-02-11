import java.util.Random;
/**
 *This class specifies if a new process should be created based on a random double
 * @author Jeff Kahn
 * @version 1.0
 * @since 2-7-2020
 */
public class ProcessGenerator {
	private double probability;
	private Random rand = new Random();
	private double probabilityTest; // number to determine if new process should be made
	public ProcessGenerator(double probability)
	{
		this.probability = probability;
		this.probability *= 100;
		
		
	}
	public boolean query()
	{
		this.probabilityTest = rand.nextDouble();
		this.probabilityTest*= 100;
		if(probabilityTest <= probability)
		{
			return true;
		}
		else
			return false;
	}
	public Process getNewProcess(int currentTime, int maxProcessTime, int maxLevel)
	{
		return new Process(currentTime, maxProcessTime, maxLevel);
	}
}
