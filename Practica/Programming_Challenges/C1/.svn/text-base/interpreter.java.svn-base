package UVA;
import java.util.Scanner;


public class interpreter 
{
	public static void main(String [] s)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		sc.nextLine();
		for(int i = 0; i < n; i++)
		{
			int [] registros = new int[10];
			int [] ram = new int[1000];
			int j = 0;
			while(true)
			{
				try
				{
					ram[j++] = Integer.parseInt(sc.nextLine());
				}
				catch(Exception e)
				{
					break;
				}
			}
			int actual = 0;
			boolean termino = false;
			int ninstrucciones = 0;
			while(!termino)
			{
				ninstrucciones++;
				int a = (int) Math.floor(ram[actual] / 100.0);
				int b = (int) Math.floor((ram[actual] - (100 * a)) / 10.0);
				int c = ram[actual] % 10;
				if(a == 1 && b == 0 && c == 0)
				{
					termino = true;
				}
				if(a == 0)
				{
					if(registros[c] != 0)
					{
						actual = registros[b];
					}
					else
					{
						actual++;
					}
				}
				else
				{
					actual++;
				}
				if(a == 2)
				{
					registros[b] = c;
				}
				else if(a == 3)
				{
					registros[b] += c;
					registros[b] %= 1000;
				}
				else if(a == 4)
				{
					registros[b] *= c;
					registros[b] %= 1000;
				}
				else if(a == 5)
				{
					registros[b] = registros[c];
				}
				else if(a == 6)
				{
					registros[b] += registros[c];
					registros[b] %= 1000;
				}
				else if(a == 7)
				{
					registros[b] *= registros[c];
					registros[b] %= 1000;
				}
				else if(a == 8)
				{
					registros[b] = ram[registros[c]];
				}
				else if(a == 9)
				{
					ram[registros[c]] = registros[b];
				}
			}
			System.out.println(ninstrucciones);
			if(i + 1 != n)
			{
				System.out.println();
			}
		}
	}
}
