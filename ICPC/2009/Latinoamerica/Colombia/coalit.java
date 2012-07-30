package UVA;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class coalit 
{
	static int numeroMagico = 0;
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int n = sc.nextInt();
			int i = sc.nextInt();
			if(n == 0 && i == 0)
				return;
			LinkedList <Integer> lista = new LinkedList <Integer> ();
			for(int j = 0; j < n; j++)
			{
				BigDecimal d = new BigDecimal(sc.next());
				lista.add(d.scaleByPowerOfTen(2).intValue());
			}
			int buscado = lista.get(i - 1);
			numeroMagico = 5001 - buscado;
			int respuesta;
			if(numeroMagico <= 0)
			{
				System.out.println("100.00");
				continue;
			}
			else
			{
				lista.remove(i - 1);
				Collections.sort(lista);
				respuesta = solucionar(lista);
			}
			System.out.println(new BigDecimal(buscado).divide(new BigDecimal(respuesta + buscado), 4, BigDecimal.ROUND_HALF_UP).scaleByPowerOfTen(2));
		}
	}
	
	private static int solucionar(LinkedList <Integer> lista) 
	{
		HashSet <Integer> conjunto = new HashSet <Integer> ();
		conjunto.add(0);
		int mejor = lista.peekLast() >= numeroMagico ? lista.pollLast() : 10000;
		for(int porcentaje : lista)
		{
			HashSet <Integer> conjuntoNuevo = new HashSet <Integer> ();
			for(int sumatoria : conjunto)
			{
				int actual = sumatoria + porcentaje;
				if(actual >= numeroMagico)
				{
					if(actual < mejor)
					{
						mejor = actual;
					}
				}
				else
				{
					conjuntoNuevo.add(actual);
				}
			}
			conjunto.addAll(conjuntoNuevo);
		}
		return mejor;
	}

}
