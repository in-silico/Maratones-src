package GoogleCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class crazyRows
{
	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File("a.in"));
		int t = sc.nextInt();
		for(int i = 0; i < t; i++)
		{
			int n = sc.nextInt();
			String [] lineas = new String[n];
			for(int j = 0; j < n; j++)
			{
				lineas[j] = sc.next();
			}
			int acumulado = 0;
			for(int j = 0; j < n; j++)
			{
				if(bueno(lineas[j], j))
					continue;
				for(int k = j + 1; k < n; k++)
				{
					if(bueno(lineas[k], j))
					{
						while(k != j)
						{
							String temp = lineas[k - 1];
							lineas[k - 1] = lineas[k];
							lineas[k] = temp;
							acumulado++;
							k--;
						}
						break;
					}
				}
			}
			System.out.println("Case #" + (i + 1) + ": " + acumulado);
		}	
	}
	
	public static boolean bueno(String linea, int num)
	{
		int n = 0;
		for(char c : linea.toCharArray())
		{
			if(n++ > num)
			{
				if(c == '1')
					return false;
			}
		}
		return true;
	}

}
