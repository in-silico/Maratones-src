package UVA;
import java.util.Arrays;
import java.util.Scanner;


public class heronian {

	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			double radio = sc.nextInt();
			double area = sc.nextInt();
			if(radio == 0 && area == 0)
				return;
			double afact = 4 * radio * area;			
			double index = 0;
			double[] factores = new double[40000];
			for(int i = 1; i < 40001; i++)
			{
				if(afact % i == 0)
				{
					factores[(int) index++] = i;
				}
			}
			double minimo = Integer.MAX_VALUE;
			double as = 0, bs = 0, cs = 0;
			for(int i = 0; i < index; i++)
				for(int j = 0; j < index; j++)
				{
					double a = factores[i];
					double b = factores[j];
					double c = (((double) afact) / ((double) a * b));
					double s = (a + b + c) / 2;
					if(c < 40001 && (int) c == c)
					{
						double area1 = Math.sqrt(s * (s - a) * (s - b) * (s - c));
						if(area1 == area)
						{
							int min = (int) Math.min(a, Math.min(b, c));
							if(min < minimo)
							{
								minimo = min;
								as = a;
								bs = b;
								cs = c;
							}
						}
					}
				}
			if(minimo == Integer.MAX_VALUE)
				System.out.println("-1 -1 -1");
			else
			{
				double[] sol = {as, bs, cs};
				Arrays.sort(sol);
				System.out.println((int)sol[0] + " " + (int)sol[1] + " " + (int)sol[2]);
			}
		}
	}
}