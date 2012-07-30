import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Automata
{
	
	static int[] dna = new int[10];
	static int[] dishes = new int[40];
	static int[] dishesNuevos = new int[40];
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++)
		{
			if(i != 0)
				System.out.println();
			br.readLine();
			String entrada = br.readLine();
			String[] pedazos = entrada.split(" ");
			for(int j = 0; j < 10; j++)
				dna[j] = Integer.parseInt(pedazos[j]);
			for(int j = 0; j < 40; j++)
				dishes[j] = 0;
			dishes[19] = 1;
			for(int j = 0; j < 50; j++)
			{
				for(int k = 0; k < 40; k++)
				{
					System.out.print(convertir(dishes[k]));
					int cuenta = dishes[k];
					if(k != 0)
						cuenta += dishes[k - 1];
					if(k != 39)
						cuenta += dishes[k + 1];
					dishesNuevos[k] = dna[cuenta];
				}
				for(int k = 0; k < 40; k++)
					dishes[k] = dishesNuevos[k];
				System.out.println();
			}
				
		}
	}

	private static char convertir(int i)
	{
		if(i == 0)
			return ' ';
		if(i == 1)
			return '.';
		if(i == 2)
			return 'x';
		return 'W';
	}

}
