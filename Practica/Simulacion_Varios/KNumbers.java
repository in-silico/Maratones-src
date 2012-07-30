import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class KNumbers 
{
	static int[] numeroVeces = new int[10];
	static StringBuilder sb = new StringBuilder(200);
	
	public static String inventory(String number)
	{
		for(int i = 0; i < 10; i++)
			numeroVeces[i] = 0;
		for(int i = 0; i < number.length(); i++)
		{
			numeroVeces[number.charAt(i) - '0']++;
		}
		sb.setLength(0);
		for(int i = 0; i < 10; i++)
		{
			if(numeroVeces[i] > 0)
			{
				sb.append(numeroVeces[i]);
				sb.append(i);
			}
		}
		return sb.toString();
	}
	
	static HashMap <String, Integer> mapa = new HashMap <String, Integer> (20);
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String nuevaLinea = br.readLine();
			if(nuevaLinea.equals("-1"))
				return;
			mapa.clear();
			mapa.put(nuevaLinea, 0);
			String actual = nuevaLinea;
			boolean ciclo = false;
			boolean termino = false;
			int i;
			for(i = 1; i <= 15; i++)
			{
				String siguiente = inventory(actual);
				if(actual.equals(siguiente))
				{
					termino = true;
					break;
				}
				else if(mapa.containsKey(siguiente))
				{
					ciclo = true;
					i = i - mapa.get(siguiente);
					break;
				}
				actual = siguiente;
				mapa.put(actual, i);
			}
			if(termino)
			{
				if(i == 1)
				{
					System.out.println(nuevaLinea + " is self-inventorying");
				}
				else
				{
					System.out.println(nuevaLinea + " is self-inventorying after " + (i - 1) + " steps");
				}
			}
			else if(ciclo)
			{
				System.out.println(nuevaLinea + " enters an inventory loop of length " + i);
			}
			else
			{
				System.out.println(nuevaLinea + " can not be classified after 15 iterations");
			}
		}
	}
}
