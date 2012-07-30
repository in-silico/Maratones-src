
public class TimeTravellingGardener
{
	public static double valorY(double x1, double x2, double y1, double y2, double x)
	{
		return ((y2 - y1) / (x2 - x1)) * (x - x1) + y1;
	}

	public static int determineUsage(int[] distance, int[] height)
	{
		double[] xs = new double[height.length];
		xs[0] = 0;
		for(int i = 1; i < height.length; i++)
		{
			xs[i] = xs[i - 1] + distance[i - 1];
		}
		int  minNumber = Integer.MAX_VALUE;
		for(int i = 0; i < height.length; i++)
			for(int j = i + 1; j < height.length; j++)
			{
				int num = 0;
				boolean no = false;
				for(int k = 0; k < height.length; k++)
				{
					double possible = valorY(xs[i], xs[j], height[i], height[j], xs[k]);
					if(possible < -1e-6 || (possible > height[k] && Math.abs(possible - height[k]) >= 1e-6))
					{
						no = true;
						break;
					}
					if(Math.abs(possible - height[k]) >= 1e-6)
						num++;
				}
				if(!no)
					minNumber = Math.min(minNumber, num);
			}
			for(int a = 0; a < height.length; a++)
			{
				int temp = height[a];
				for(int b = 0; b < 1; b++)
				{
					height[a] = b;
					for(int i = 0; i < height.length; i++)
						for(int j = i + 1; j < height.length; j++)
						{
							int num = 1;
							boolean no = false;
							for(int k = 0; k < height.length; k++)
							{
								double possible = valorY(xs[i], xs[j], height[i], height[j], xs[k]);
								if(possible < 0 || (possible > height[k] && Math.abs(possible - height[k]) >= 1e-6))
								{
									no = true;
									break;
								}
								if(Math.abs(possible - height[k]) >= 1e-6)
									num++;
							}
							if(!no)
								minNumber = Math.min(minNumber, num);
						}
				}
				height[a] = temp;
			}
			return Math.min(height.length, minNumber);
	}
	
	public static void main(String[] args)
	{
		System.out.println(determineUsage(new int[]{48, 38, 50, 36}, new int[]{102, 87, 51, 710, 246}));
	}
}
