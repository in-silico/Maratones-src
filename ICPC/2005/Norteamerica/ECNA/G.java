import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;


public class G 
{
	
	static class Ciudad implements Comparable<Ciudad>
	{
		static int consecutivo = 0;
		static boolean empezo = false;
		
		int id;
		int conquista;
		int x, y, z;
		int valor;
		
		ArrayList <Ciudad> adjacentes = new ArrayList <Ciudad> ();
		int[] dp;
		TreeMap <Ciudad, Integer> posiciones = new TreeMap <Ciudad, Integer> ();
		
		public Ciudad(String readLine)
		{
			String[] pedazos = readLine.split("\\s+");
			id = Integer.parseInt(pedazos[0]);
			x = Integer.parseInt(pedazos[1]);
			y = Integer.parseInt(pedazos[2]);
			z = Integer.parseInt(pedazos[3]);
			conquista = consecutivo++;
		}
		
		public int distancia(Ciudad otra)
		{
			return (x - otra.x) * (x - otra.x) + (y - otra.y) * (y - otra.y) + (z - otra.z) * (z - otra.z);
		}

		public void llenarDp()
		{
			dp = new int[adjacentes.size()];
			for(int i = 0; i < dp.length; i++)
				dp[i] = -1;
			for(int i = 0; i < adjacentes.size(); i++)
			{
				posiciones.put(adjacentes.get(i), i);
			}
		}
		
		public int visitar(Ciudad desde)
		{
			int donde = desde == null ? 0 : posiciones.get(desde);
			if(desde != null && dp[donde] != -1)
				return dp[donde];
			int maximo = 0;
			for(Ciudad c : adjacentes)
			{
				if(c == desde)
					continue;
				maximo = Math.max(maximo, c.visitar(this));
			}
			if(desde != null)
				dp[donde] = maximo + 1;
			return maximo + 1;
		}

		@Override
		public int compareTo(Ciudad o)
		{
			if(!empezo)
				return Integer.valueOf(id).compareTo(o.id);
			if(valor == o.valor)
				return Integer.valueOf(id).compareTo(o.id);
			return Integer.valueOf(valor).compareTo(o.valor);
		}
	}
	
	static ArrayList <Ciudad> ciudades = new ArrayList <Ciudad> ();
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				return;
			ciudades.clear();
			for(int i = 0; i < n; i++)
			{
				int distanciaMenor = Integer.MAX_VALUE;
				Ciudad actual = null;
				Ciudad nueva = new Ciudad(br.readLine());
				for(Ciudad c : ciudades)
				{
					int distancia = nueva.distancia(c);
					if(distancia < distanciaMenor)
					{
						actual = c;
						distanciaMenor = distancia;
					}
					if(distancia == distanciaMenor && c.conquista < actual.conquista)
					{
						actual = c;
					}
				}
				ciudades.add(nueva);
				if(actual != null)
				{
					actual.adjacentes.add(nueva);
					nueva.adjacentes.add(actual);
				}
			}
			Ciudad.empezo = false;
			for(Ciudad c : ciudades)
				c.llenarDp();
			for(Ciudad c : ciudades)
				c.valor = c.visitar(null);
			Ciudad.empezo = true;
			Collections.sort(ciudades);
			if(ciudades.size() > 1 && ciudades.get(0).valor == ciudades.get(1).valor)
			{
				System.out.println(ciudades.get(0).id + " " + ciudades.get(1).id);
			}
			else
			{
				System.out.println(ciudades.get(0).id);
			}
		}
	}

}
