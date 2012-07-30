import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class B 
{
	static char anterior = 0;
	static boolean paila = false;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	
	public static BigInteger leerExpresion() throws IOException
	{
		if(anterior >= '0' && anterior <= '9')
		{
			StringBuilder sb = new StringBuilder(90);
			while(anterior >= '0' && anterior <= '9')
			{
				sb.append(anterior);
				anterior = (char) br.read();
			}
			if(anterior == ' ')
				anterior = leer();
			if(sb.length() > 90)
			{
				paila = true;
				return BigInteger.ONE;
			}
			else
				return new BigInteger(sb.toString());
		}
		else
		{
			anterior = leer();
			BigInteger a = leerExpresion();
			char simbolo = anterior;
			anterior = leer();
			BigInteger b = leerExpresion();
			anterior = leer();
			BigInteger resultado;
			if(paila)
				return BigInteger.ONE;
			else if(simbolo == '+')
				resultado = a.add(b);
			else if(simbolo == '-')
				resultado = a.subtract(b);
			else if(simbolo == '*')
				resultado = a.multiply(b);
			else
			{
				if(b.equals(BigInteger.ZERO))
				{
					paila = true;
					return BigInteger.ONE;
				}
				else
					resultado = a.divide(b);
			}
			if(resultado.toString().length() > 90 || resultado.compareTo(BigInteger.ZERO) < 0)
			{
				paila = true;
				return BigInteger.ONE;
			}
			return resultado;
		}
	}
	
	public static char leer() throws IOException
	{
		int actual = br.read();
		if(actual == -1)
			return '\0';
		while(actual == ' ' || actual == '\n')
		{
			actual = br.read();
			if(actual == -1)
				return '\0';
		}
		return (char) actual;
	}
	
	public static void main(String[] args) throws IOException
	{
		anterior = (char) leer();
		while(true)
		{
			paila = false;
			if(anterior == '\0')
				return;
			else if(anterior == '\n' || anterior == ' ')
				anterior = leer();
			if(anterior == '\0')
				return;
			BigInteger resultado = leerExpresion();
			if(paila)
				System.out.println("Error");
			else
				System.out.println(resultado);
		}
	}
}
