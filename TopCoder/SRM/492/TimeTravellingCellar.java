
public class TimeTravellingCellar
{
	public static int determineProfit(int[] profit, int[] decay)
	{
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < profit.length; i++)
			for(int j = 0; j < decay.length; j++)
				if(i != j)
				{
					max = Math.max(max, profit[i] - decay[j]);
				}
		return max;
	}
}
