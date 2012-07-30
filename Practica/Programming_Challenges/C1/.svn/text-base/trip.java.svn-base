package UVA;

import java.util.Locale;
import java.util.Scanner;

public class trip 
{
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				return;
			int[] valores = new int[n];
			for(int i = 0; i < n; i++)
			{
				valores[i] = (int) Math.round(sc.nextDouble() * 100);
			}
			int promedio = 0;
			for(int i = 0; i < n; i++)
			{
				promedio += valores[i];
			}
			double promedio1 = (promedio + 0.0) / n;
			promedio /= n;
			int valor = 0;
			if(promedio == promedio1)
			{
				for(int i = 0; i < n; i++)
				{
					if(valores[i] < promedio)
					{
						valor -= valores[i] - promedio;
					}
				}
			}
			else
			{
				promedio += 1;
				for(int i = 0; i < n; i++)
				{
					if(valores[i] > promedio)
					{
						valor += valores[i] - promedio;
					}
				}
				promedio -= 0.01;
				int valorTemp = valor;
				for(int i = 0; i < n; i++)
				{
					if(valores[i] < promedio)
					{
						valor += valores[i] - promedio;
					}
				}
				if(valor < 0)
					valor = Math.abs(valor) + valorTemp;
				else
					valor = valorTemp;
			}
			if(valor < 10)
			{
				System.out.println("$0.0" + valor);
			}
			else if(valor < 100)
			{
				System.out.println("$0." + valor);
			}
			else
			{
				System.out.println("$" + (valor / 100) + "." + ((valor % 100) < 10 ? "0" + (valor % 10) : (valor % 100)));
			}
		}
	}

}
