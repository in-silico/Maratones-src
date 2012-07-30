import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class G 
{
	
	public static BigInteger leerBI(String s)
	{
		while(s.charAt(0) == '0' && s.length() != 1)
		{
			s = s.substring(1);
		}
		return new BigInteger(s);
	}
	
	public static String ponerLongitud(BigInteger a, int n)
	{
		String salida = a.toString();
		while(salida.length() < n)
			salida = "0" + salida;
		return salida;
	}
	
	public static boolean esCiclo(String a, String b)
	{
		for(int i = 0; i < a.length(); i++)
		{
			String temp = b.substring(i) + b.substring(0, i);
			if(temp.equals(a))
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String numero = br.readLine();
			if(numero == null)
				break;
			BigInteger numeroBI = leerBI(numero);
			boolean es = true;
			for(int i = 1; i <= numero.length(); i++)
			{
				es = es && esCiclo(ponerLongitud(numeroBI.multiply(new BigInteger(i + "")), numero.length()), numero);
			}
			if(es)
				System.out.println(numero + " is cyclic");
			else
				System.out.println(numero + " is not cyclic");
				
			
		}
	}

}
