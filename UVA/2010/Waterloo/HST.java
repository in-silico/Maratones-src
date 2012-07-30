import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;


public class HST 
{
	static class Entrada
	{
		long a, b, c;

		public Entrada(long a, long b, long c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		Hashtable <String, Entrada> hash = new Hashtable <String, Entrada> (100000);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int aa = Integer.parseInt(br.readLine());
		int i = 1;
		while(i++ <= aa)
		{
			hash.clear();
			String[] iniciales = br.readLine().split(" ");
			int n = Integer.parseInt(iniciales[0]);
			int m = Integer.parseInt(iniciales[1]);
			for(int j = 0; j < n; j++)
			{
				String[] actual = br.readLine().split(" ");
				hash.put(actual[0], new Entrada(convertir(actual[1]), convertir(actual[2]), convertir(actual[3])));
			}
			long cuenta = 0;
			for(int j = 0; j < m; j++)
			{
				String[] actual = br.readLine().split(" ");
				Entrada entrada = hash.get(actual[0]);
				long numero = Long.parseLong(actual[1].substring(1).replace(".", ""));
				long c = (numero * entrada.c) / 1000;
				if(c % 10 >= 5)
				{
					c /= 10;
					c++;
				}
				else
				{
					c /= 10;
				}
				long b = (numero * entrada.b) / 1000;
				if(b % 10 >= 5)
				{
					b /= 10;
					b++;
				}
				else
				{
					b /= 10;
				}
				long a = (numero * entrada.a) / 1000;
				if(a % 10 >= 5)
				{
					a /= 10;
					a++;
				}
				else
				{
					a /= 10;
				}
				cuenta += c;
				cuenta -= a + b;
			}
			if(cuenta < 0)
			{
				cuenta *= -1;
				System.out.print("-");
			}
			if(cuenta < 10)
			{
				System.out.println("0.0" + cuenta);
			}
			else if(cuenta < 100)
			{
				System.out.println("0." + cuenta);
			}
			else
			{
				String cuentaS = cuenta + "";
				System.out.println(cuentaS.substring(0, cuentaS.length() - 2) + "." + cuentaS.substring(cuentaS.length() - 2, cuentaS.length()));
			}
		}
	}
	private static long convertir(String string)
	{
		string = string.substring(0, string.length() - 1);
		int indice = string.indexOf('.');
		string = string.replace(".", "");
		if(indice == -1)
		{
			return Long.parseLong(string) * 100;
		}
		if(indice == string.length() - 1)
		{
			return Long.parseLong(string) * 10;
		}
		return Long.parseLong(string);
	}
}
