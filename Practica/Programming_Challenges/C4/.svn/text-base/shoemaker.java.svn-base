package UVA;

import java.util.Arrays;
import java.util.Scanner;

public class shoemaker 
{
	static class entrada implements Comparable <entrada>
	{
		int numero;
		double relacion;
		
		@Override
		public int compareTo(entrada otra) 
		{
			if(relacion == otra.relacion)
			{
				return numero - otra.numero;
			}
			return relacion > otra.relacion ? 1 : -1;	
		}
	}
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int ncasos = sc.nextInt();
		for(int i = 0; i < ncasos; i++)
		{
			int numero = sc.nextInt();
			entrada [] entradas = new entrada[numero];
 			for(int j = 0; j < numero; j++)
 			{
 				entradas[j] = new entrada();
 				entradas[j].numero = j + 1;
 				entradas[j].relacion = (sc.nextInt() + 0.0) / sc.nextInt();
 			}
 			Arrays.sort(entradas);
 			for(int j = 0; j < numero; j++)
 			{
 				if(j != 0)
 					System.out.print(" ");
 				System.out.print(entradas[j].numero);
 			}
 			System.out.println();
 			if(i != ncasos - 1)
 				System.out.println();
		}
	}

}
