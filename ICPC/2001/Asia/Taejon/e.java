import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class e 
{
	
	public static int sequencia(String[] numeros)
	{
		int[] numBase = new int[numeros.length];
		for(int i = 2; i <= 10; i++)
		{
			try
			{
				for(int j = 0; j < numeros.length; j++)
				{
					numBase[j] = Integer.parseInt(numeros[j], i);
				}
			}
			catch(Exception e)
			{
				continue;
			}
			int diferencia = numBase[1] - numBase[0];
			boolean bien = true;
			for(int j = 1; j < numeros.length; j++)
			{
				if(numBase[j] - numBase[j - 1] != diferencia)
				{
					bien = false;
					break;
				}
			}
			if(bien)
				return i;
		}
		return 11;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				return;
			int res = sequencia(br.readLine().split(" "));
			System.out.println(res == 11 ? "No base <= 10 can be found." : "Minimum base = " + res + ".");
		}
	}
}
