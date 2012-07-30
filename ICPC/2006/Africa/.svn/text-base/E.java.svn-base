import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class E 
{
	static String s = "2 9\n1 3\n2 4 11\n3 5\n13 4 6\n5 7\n15 6\n9 18\n1 8 10\n9 11 20\n10 12 3\n11 13 22\n12 14 5\n13 15 24\n14 16 7\n15 26\n18 28\n17 19 8\n30 18 20\n19 21 10\n20 22 32\n21 23 12\n22 24 34\n23 25 14\n24 26 36\n25 27 16\n26 38\n17 29\n28 30 39\n29 31 19\n41 30 32\n31 33 21\n32 34 43\n33 35 23\n34 36 45\n35 37 25\n47 36 38\n37 27\n29 40\n39 41 48\n40 42 31\n41 43 50\n42 33 44\n43 45 52\n44 46 35\n45 47 54\n46 37\n40 49\n48 50\n42 49 51\n50 52\n51 53 44\n52 54\n53 46";
	
	public static void main(String[] args) throws FileNotFoundException
	{
		System.setOut(new PrintStream("salida.txt"));
		Scanner sc = new Scanner(s);
		int[][] vecinos = new int[55][];
		for(int i = 1; i < 55; i++)
		{
			String[] pedazos = sc.nextLine().split("\\s+");
			int[] actual = new int[pedazos.length];
			for(int j = 0; j < pedazos.length; j++)
				actual[j] = Integer.parseInt(pedazos[j]);
			vecinos[i] = actual;
		}
		sc = new Scanner(System.in);
		int caso = 1;
		while(true)
		{
			boolean[] ocupado = new boolean[55];
			int[] mios = new int[6];
			int[] otro = new int[6];
			for(int i = 0; i < 6; i++)
			{
				mios[i] = sc.nextInt();
				if(i == 0 && mios[i] == 0)
					return;
				ocupado[mios[i]] = true;
			}
			for(int i = 0; i < 6; i++)
			{
				otro[i] = sc.nextInt();
				ocupado[otro[i]] = true;
			}
			boolean perdio = false;
			for(int i = 0; i < 6; i++)
			{
				ocupado[mios[i]] = false; 
				for(int j : vecinos[mios[i]])
				{
					if(ocupado[j])
						continue;
					ocupado[j] = true;
					for(int k = 0; k < 6; k++)
					{
						boolean perdioE = true;
						ocupado[otro[k]] = false;
						for(int l : vecinos[otro[k]])
						{
							if(!ocupado[l])
								perdioE = false;
						}
						if(perdioE)
							perdio = true;
						ocupado[otro[k]] = true;
					}
					ocupado[j] = false;
				}
				ocupado[mios[i]] = true; 
			}
			if(perdio)
				System.out.println(caso++ + ". TRAPPED");
			else
				System.out.println(caso++ + ". FREE");
				
		}
			
	}

}
