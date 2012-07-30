import java.util.Arrays;


public class Filtering 
{
	
	static class Number implements Comparable<Number>
	{
		public Number(int i, boolean b) 
		{
			number = i;
			accept = b;
		}
		
		int number;
		boolean accept;
		@Override
		public int compareTo(Number o) 
		{
			return Integer.valueOf(number).compareTo(o.number);
		}
	}
	int[] designFilter(int[] sizes, String outcome)
	{
		Number[] numbers = new Number[sizes.length];
		for(int i = 0; i < sizes.length; i++)
			numbers[i] = new Number(sizes[i], outcome.charAt(i) == 'A');
		Arrays.sort(numbers);
		int start = -1;
		int end = -1;
		boolean finish = false;
		boolean bad = false;
		for(int i = 0; i < sizes.length; i++)
		{
			if(start == -1 && numbers[i].accept)
			{
				start = i;
			}
			if(numbers[i].accept)
			{
				end = i;
			}
			if(!finish && end != -1 && !numbers[i].accept)
			{
				finish = true;
			}
			else if(finish && numbers[i].accept)
			{
				bad = true;
			}
		}
		if(bad)
		{
			return new int[0];
		}
		else
		{
			return new int[]{numbers[start].number, numbers[end].number};
		}
	}
}
