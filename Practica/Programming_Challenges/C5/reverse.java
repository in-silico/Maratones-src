package UVA;

import java.util.Scanner;

public class reverse 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int ncasos = sc.nextInt();
		for(int i = 0; i < ncasos; i++)
		{
			long numeroActual = sc.nextLong();
			int acumulado = 0;
			while(true)
			{
				long nuevoNumero = alReves(numeroActual);
				if(numeroActual == nuevoNumero)
				{
					System.out.println(acumulado + " " + numeroActual);
					break;
				}
				numeroActual += nuevoNumero;
				acumulado++;
			}
		}
	}
	
	private static long alReves(long numeroActual)
	{
		char [] numero = (numeroActual + "").toCharArray();
		reversar(numero);
		return Long.parseLong(new String(numero));
	}
	
	public static void reversar(char[] b) 
	{
		   int left  = 0;          // index of leftmost element
		   int right = b.length-1; // index of rightmost element
		  
		   while (left < right) {
		      // exchange the left and right elements
		      char temp = b[left]; 
		      b[left]  = b[right]; 
		      b[right] = temp;
		     
		      // move the bounds toward the center
		      left++;
		      right--;
		   }
	}
}
