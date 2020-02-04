import java.util.Random;

public class ProcessGenerator {
	private double probability;
	private Random rand = new Random();
	private double probabilityTest; // number to determine if new process should be made
	public ProcessGenerator(double probability)
	{
		this.probability = probability;
		this.probabilityTest = rand.nextDouble();
		
	}
	public boolean query()
	{
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