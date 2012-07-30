import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.TreeMap;


@SuppressWarnings("unchecked")
public class B
{
	
	static class Respuesta
	{
		BigInteger ultimo;
		BigInteger este;
		int coma;
		Respuesta siguiente;
		
		public Respuesta(BigInteger u, int c, Respuesta s, BigInteger e)
		{
			ultimo = u;
			coma = c;
			siguiente = s;
			este = e;
		}
		
		Respuesta agregar(int coma, BigInteger este)
		{
			return new Respuesta(ultimo, coma, this, este);
		}
	}
	
	static TreeMap <BigInteger, Respuesta> [] dp = new TreeMap[80];
	static int tam;
	static String cadena;
	static Respuesta NSP = new Respuesta(null, 0, null, null);
	
	public static BigInteger darBI(int desde, int hasta)
	{
		String cadenaPedazo = cadena.substring(desde, hasta + 1);
		while(desde < hasta && cadenaPedazo.charAt(0) == '0')
		{
			cadenaPedazo = cadena.substring(++desde, hasta + 1);
		}
		return new BigInteger(cadenaPedazo);
	}
	
	public static Respuesta buscar(int desde, BigInteger menor)
	{
		if(dp[desde].containsKey(menor))
		{
			return dp[desde].get(menor);
		}
		Respuesta actual = new Respuesta(darBI(desde, tam - 1), tam - 1, null, darBI(desde, tam - 1));
		for(int i = desde; i < tam - 1; i++)
		{
			BigInteger este = darBI(desde, i);
			if(este.compareTo(menor) < 0)
				continue;
			Respuesta posible = buscar(i + 1, este.add(BigInteger.ONE));
			if(posible == NSP)
				continue;
			posible = posible.agregar(i, este);
			int respuesta = posible.ultimo.compareTo(actual.ultimo);
			if(respuesta <= 0)
			{
				if(respuesta == 0)
				{
					Respuesta a = posible;
					Respuesta b = actual;
					while(true)
					{
						if(a == null || b == null)
							break;
						if(a.este.compareTo(b.este) > 0)
						{
							actual = posible;
							break;
						}
						a = a.siguiente;
						b = b.siguiente;
					}
				}
				else
				{
					actual = posible;
				}
			}
		}
		if(actual.ultimo.compareTo(menor) < 0)
			actual = NSP;
		dp[desde].put(menor, actual);
		return actual;
	}
	
	public static void main(String[] args) throws IOException
	{
		for(int i = 0; i < 80; i++)
		{
			dp[i] = new TreeMap <BigInteger, Respuesta> ();
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			cadena = br.readLine();
			if(cadena.equals("0"))
				break;
			tam = cadena.length();
			for(int i = 0; i < 80; i++)
			{
				dp[i].clear();
			}
			int anterior = -1;
			Respuesta r = buscar(0, BigInteger.ZERO.subtract(BigInteger.ONE));
			while(r != null)
			{
				System.out.print(cadena.substring(anterior + 1, r.coma + 1) + (r.siguiente != null ? "," : ""));
				anterior = r.coma;
				r = r.siguiente;
			}
			System.out.println();
		}
	}
}
