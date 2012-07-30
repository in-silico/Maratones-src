import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Factoring
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static long leerNumero() throws NumberFormatException, IOException
	{
		return Long.parseLong(br.readLine());
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		boolean empezo = false;
		while(true)
		{
			long n = leerNumero();
			if(n < 0)
				return;
			if(empezo == false)
				empezo = true;
			else
				System.out.println();
			int raiz = (int) Math.sqrt(n) + 2;
			ArrayList <Long> factores = new ArrayList <Long> ();
			for(int i = 2; i < raiz; i++)
			{
				if(n % i == 0)
				{
					factores.add((long) i);
					n /= i;
					raiz = (int) Math.sqrt(n) + 2;
					i--;
				}
			}
			if(n > 1)
				factores.add(n);
			Collections.sort(factores);
			for(long a : factores)
				System.out.println("    " + a);
		}
	}

}
