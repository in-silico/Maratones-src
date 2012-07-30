package UVA;

import java.util.ArrayList;
import java.util.Scanner;

public class informants
{
	static ArrayList <ArrayList <Integer>> confiables;
	static ArrayList <ArrayList <Integer>> noConfiables;
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int i = sc.nextInt();
			int a = sc.nextInt();
			if(i == 0 && a == 0)
				return;
			confiables = new ArrayList <ArrayList <Integer>> (20);
			noConfiables = new ArrayList <ArrayList <Integer>> (20);
			for(int j = 0; j < i; j++)
			{
				confiables.add(new ArrayList <Integer>  (40));
				noConfiables.add(new ArrayList <Integer>  (40));
			}
			for(int j = 0; j < a; j++)
			{
				int x = sc.nextInt();
				int y = sc.nextInt();
				if(y < 0)
					noConfiables.get(x - 1).add(-y);
				else
					confiables.get(x - 1).add(y);
			}
			Boolean [] vector = new Boolean[i];
			System.out.println(mejorNumero(vector, 0, 0, i));
		}
		
		
	}

	private static int mejorNumero(Boolean[] vector, int numero, int actual, int n) 
	{
		if(actual == n)
			return numero;
		else
		{
			int respuesta = 0;
			if(vector[actual] == null || vector[actual] == true)
			{
				boolean posible = true;
				Boolean[] vectorNuevo = vector.clone();
				vectorNuevo[actual] = true;
				for(int j : confiables.get(actual))
				{
					if(vectorNuevo[j - 1] == null)
					{
						vectorNuevo[j - 1] = true;
					}
					else if(vectorNuevo[j - 1] == false)
					{
						posible = false;
						break;
					}
				}
				if(posible)
				{
					for(int j : noConfiables.get(actual))
					{
						if(vectorNuevo[j - 1] == null)
						{
							vectorNuevo[j - 1] = false;
						}
						else if(vectorNuevo[j - 1] == true)
						{
							posible = false;
							break;
						}
					}
				}
				if(posible)
					respuesta = mejorNumero(vectorNuevo, numero + 1, actual + 1, n);
			}
			if(vector[actual] == null || vector[actual] != true)
			{
				Boolean[] vectorNuevo = vector.clone();
				vectorNuevo[actual] = false;
				if(respuesta < (numero + (n - (actual + 1))))
					respuesta = Math.max(respuesta, mejorNumero(vectorNuevo, numero, actual + 1, n));
			}
			return respuesta;
		}
	}

}
