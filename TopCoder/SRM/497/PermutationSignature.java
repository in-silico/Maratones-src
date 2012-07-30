
public class PermutationSignature 
{
	public int[] reconstruct(String signature)
	{
		int last = 0;
		int number = signature.length() + 1;
		int[] exit = new int[number];
		for(int i = 0; i < number; i++)
		{
			int j = i;
			int count = 1;
			for(; j < number - 1 && signature.charAt(j) == 'D'; j++, count++);
			if(count == 1)
				exit[i] = ++last;
			else
			{
				last += 1 + count; 
				int temp = last;
				for(j = i; j < i + count; j++)
					exit[j] = --last;
				i += count - 1;
				last = --temp;
			}
		}
		return exit;
	}
	
	public static void main(String[] args)
	{
		new PermutationSignature().reconstruct("DI");
	}
}
