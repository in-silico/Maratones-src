package UVA;

import java.math.BigInteger;
import java.util.Scanner;


public class tres
{

	public static int [] iteraciones = new int [1000000];
	public static long maximo = ((Long.MAX_VALUE - 1) / 3);
	public static BigInteger maximoBig = new BigInteger(maximo + "");
	
	public static int resolver(Number numero)
	{
		if(numero instanceof Long)
		{
			long numeroLong = (Long) numero;
			if(numeroLong == 1)
			{
				return 1;
			}
			if(numeroLong > 999999)
			{
				if(numeroLong % 2 == 0)
				{
					return 1 + resolver(numeroLong >> 1);
				}
				else
				{
					if(numeroLong > maximo)
					{
						BigInteger siguiente = new BigInteger(numeroLong + "");
						siguiente = siguiente.add(siguiente).add(siguiente).add(BigInteger.ONE);
						return 1 + resolver(siguiente);
					}
					else
					{
						return 1 + resolver(numeroLong + numeroLong + numeroLong + 1);
					}
				}
			}
			else if (iteraciones [(int) numeroLong] != 0)
			{
				return iteraciones [(int) numeroLong];
			}
			else if ((numeroLong % 2 == 0))
			{
				if(iteraciones [(int) (numeroLong >> 1)] != 0 && (((numeroLong >> 1) % 2 == 0)))
				{
					iteraciones [(int) numeroLong] = 1 + iteraciones [(int) (numeroLong >> 1)];
				}
				else
				{
					iteraciones [(int) numeroLong] = 1 + resolver(numeroLong >> 1);
				}
			}
			else if (((numeroLong - 1) % 3) == 0)
			{
				if(iteraciones [(int) ((numeroLong - 1) / 3)] != 0 && (((numeroLong - 1) / 3) % 2 != 0))
				{
					iteraciones [(int) numeroLong] = 1 + iteraciones [(int) ((numeroLong - 1) / 3)];
				}
				else
				{
					iteraciones [(int) numeroLong] = 1 + resolver(numeroLong + numeroLong + numeroLong + 1);
				}
			}
			else
			{
				iteraciones [(int) numeroLong] = 1 + resolver(numeroLong + numeroLong + numeroLong + 1);
			}
			return iteraciones [(int) numeroLong];
		}
		else
		{
			BigInteger numeroBig = (BigInteger) numero;
			if(numeroBig.mod(new BigInteger("2")) == BigInteger.ZERO)
			{
				if(numeroBig.shiftRight(1).compareTo(maximoBig) == 0)
				{
					return 1 + resolver(numeroBig.shiftRight(1).longValue());
				}
				else
				{
					return 1 + resolver(numeroBig.shiftRight(1));
				}
			}
			else
			{
				BigInteger siguiente = numeroBig;
				siguiente = siguiente.add(siguiente).add(siguiente).add(BigInteger.ONE);
				return 1 + resolver(siguiente);
			}
		}
	}
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int mayor = 0;
			boolean invertir = false;
			if(a > b)
			{
				int temp = a;
				a = b;
				b = temp;
				invertir = true;
			}
			for(int i = a; i < b + 1; i++)
			{
				int respuesta = resolver((long) i);
				if(respuesta > mayor)
				{
					mayor = respuesta;
				}
			}
			if(invertir)
			{
				System.out.println(b + " " + a + " " + mayor);
			}
			else
			{
				System.out.println(a + " " + b + " " + mayor);
			}
		}
		
	}
}
