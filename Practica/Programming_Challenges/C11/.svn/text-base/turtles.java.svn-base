package UVA;

import java.util.Arrays;
import java.util.Scanner;


public class turtles 
{
	public static void main(String [] args)
	{
	    Tortuga [] arregloTortuga = new Tortuga[5700];
		long [][] matriz;
		Scanner sc = new Scanner(System.in);
		int i = 0;
		while(sc.hasNext())
		{
			long peso = sc.nextLong();
			long fuerza = sc.nextLong();
			if((fuerza - peso) >= 0)
			{
				arregloTortuga[i] = new Tortuga(peso, fuerza); 
				i++;
			}
		}
		if(i == 0)
		{
			System.out.println("0");
			return;
		}
		Arrays.sort(arregloTortuga, 0, i);
		
		matriz = new long[i][2];
		
		matriz[0][1] = arregloTortuga[0].peso;
		for(int n = 1; n < i; n++)
				matriz[n][1] = Long.MAX_VALUE;
		int respuesta = 0;
		for(int j = 1; j < i; j++)
		{
			for(int k = 0; k < i; k++)
			{
				matriz[k][0] = matriz[k][1];
				if(k == 0)
				{
					matriz[0][1] = Math.min(matriz[0][0], arregloTortuga[j].peso);
				}
				else
				{
		              matriz[k][1] = matriz[k][0];
		              if ((matriz[k - 1][0] + arregloTortuga[j].peso) <= arregloTortuga[j].fuerza)
		                matriz[k][1] = Math.min(matriz[k][1], matriz[k - 1][0] == Long.MAX_VALUE ? Long.MAX_VALUE : matriz[k - 1][0] + arregloTortuga[j].peso);
				}
				if(matriz[k][1] < Long.MAX_VALUE)
				{
					respuesta = Math.max(respuesta, k + 1);
				}
			}
		}
		System.out.println(respuesta + "");
	}

	static class Tortuga implements Comparable <Tortuga>
	{
		long peso;
		long fuerza;
		
		public Tortuga(long peso, long fuerza)
		{
			this.peso = peso;
			this.fuerza = fuerza;
		}

		@Override
		public int compareTo(Tortuga tortuga2) 
		{
			return fuerza > tortuga2.fuerza ? 1 : fuerza == tortuga2.fuerza ? (peso > tortuga2.peso ? 1 : -1) : -1;
		}
	}
}

