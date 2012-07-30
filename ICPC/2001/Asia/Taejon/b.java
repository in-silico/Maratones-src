import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean empezo = false;
		boolean[] suma = new boolean[100000];
		int[] todas = new int[30];
		while(true)
		{
			String entrada = br.readLine();
			if(!empezo)
				empezo = true;
			else
				System.out.println();
			if(entrada == null)
				return;
			if(entrada.equals(""))
			{
				System.out.println("the least amount that can’t be made exactly is 1");
				System.out.println("the number of amounts between 0 and 0 that can’t be made exactly is 0");
				continue;
			}
			String[] pedazos = entrada.split("\\s+");
			int total = 0;
			for(int i = 0; i < pedazos.length; i++)
			{
				todas[i] = Integer.parseInt(pedazos[i]);
				total += todas[i];
			}
			suma[0] = true;
			for(int i = 1; i <= total; i++)
				suma[i] = false;
			int numero = 1 << pedazos.length;
			for(int i = 0; i < numero; i++)
			{
				int sum = 0;
				for(int j = 0; j < todas.length; j++)
				{
					if(((i >> j) & 1) == 1)
						sum += todas[j];
				}
				suma[sum] = true;
			}
			int cuantas = 0;
			boolean menor = false;
			for(int i = 0; i <= total; i++)
			{
				if(!suma[i])
				{
					if(!menor)
					{
						System.out.println("the least amount that can’t be made exactly is " + i);
						menor = true;
					}
					cuantas++;
				}
			}
			if(!menor)
				System.out.println("the least amount that can’t be made exactly is " + (total + 1));
			System.out.println("the number of amounts between 0 and " + total + " that can’t be made exactly is " + cuantas);
		}
	}
}
