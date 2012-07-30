import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Palindroms 
{

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String numero = br.readLine();
			if(numero == null)
				return;
			for(int i = 15; i >= 2; i--)
			{
				BigInteger numeroActual;
				try
				{
					numeroActual = new BigInteger(numero, i);
				}
				catch(Exception e)
				{
					if(i != 15)
						System.out.print(" ");
					System.out.print("?");
					continue;
				}
				int numeroPasos = 0;
				while(true)
				{
					try
					{
						String numeroActualS = numeroActual.toString(i);
						if(esPalindromo(numeroActualS))
						{
							if(i != 15)
								System.out.print(" ");
							System.out.print(numeroPasos);
							break;
						}
						numeroPasos++;
						StringBuilder sb = new StringBuilder(numeroActualS);
						sb.reverse();
						BigInteger num2 = new BigInteger(sb.toString(), i);
						numeroActual = numeroActual.add(num2);
					}
					catch(Exception e)
					{
						if(i != 15)
							System.out.print(" ");
						System.out.print("?");
						break;
					}
				}
			}
			System.out.println();
		}
	}

	private static boolean esPalindromo(String numeroActual) 
	{
		int tam = numeroActual.length();
		for(int i = 0; i < tam / 2; i++)
		{
			if(numeroActual.charAt(i) != numeroActual.charAt(tam - 1 - i))
				return false;
		}
		return true;
	}
}
