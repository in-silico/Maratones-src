import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class SDS
{
	public static void main(String[] args)
	{
		ArrayList <Integer> numeros = new ArrayList <Integer> ();
		long cuenta = 0;
		numeros.add(0);
		numeros.add(1);
		numeros.add(2);
		numeros.add(2);
		cuenta += 5;
		int numActual = 3;
		while(cuenta <= 2000000000L)
		{
			for(int i = 0; i < numeros.get(numActual); i++)
			{
				numeros.add(numActual);
				cuenta += numActual;
			}
			numActual++;
		}
		long[] imagenIntegral = new long[numeros.size()];
		for(int i = 1; i < numeros.size(); i++)
			imagenIntegral[i] = imagenIntegral[i - 1] + numeros.get(i);
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			long n = sc.nextLong();
			if(n == 0)
				return;
			int res = Arrays.binarySearch(imagenIntegral, n);
			if(res < 0)
			{
				res++;
				res = -res;
				System.out.println(res);
			}
			else
				System.out.println(res);
		}
	}

}
