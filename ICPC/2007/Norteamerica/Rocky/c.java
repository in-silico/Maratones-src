import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.TreeSet;


public class c 
{
	static class Outlet implements Comparable <Outlet>
	{
		int numero;
		int distancia;
		boolean visitado = false;
		int x;
		int y;
		LinkedList <Outlet> vecinos = new LinkedList <Outlet> ();
		
		public Outlet(int n)
		{
			numero = n;
		}

		@Override
		public int compareTo(Outlet o) 
		{
			if(distancia == o.distancia)
				return Integer.valueOf(numero).compareTo(o.numero);
			return Integer.valueOf(distancia).compareTo(o.distancia);
		}
	}
	
	static Outlet[] outlets = new Outlet[2000];
	static BigDecimal mil = new BigDecimal(1000);
	static TreeSet <Outlet> pq = new TreeSet <Outlet> ();
	
	static long sacarEntero(String s)
	{
		BigDecimal bd = new BigDecimal(s);
		bd = bd.multiply(mil);
		return bd.longValueExact();
	}
	
	static long hipotenusa(long a, long b)
	{
		long cuadrado = a * a + b * b;
		double res = Math.sqrt(cuadrado);
		long valor = (long)(res + 0.1);
		if(valor * valor == cuadrado)
			return valor * 1000;
		long sal = (long) (res * 1000);
		return sal + 1;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int i = 0; i < 2000; i++)
			outlets[i] = new Outlet(i);
		for(int aa = 0; aa < tc; aa++)
		{
			String[] pedazos = br.readLine().split("\\s+");
			int nO = Integer.parseInt(pedazos[0]);
			int inicial = Integer.parseInt(pedazos[1]);
			int ultimo = Integer.parseInt(pedazos[2]);
			long a = sacarEntero(pedazos[3]);
			long b = sacarEntero(pedazos[4]);
			long cables = a + b;
			for(int i = 1; i <= nO; i++)
			{
				outlets[i].vecinos.clear();
				outlets[i].distancia = Integer.MAX_VALUE;
				outlets[i].visitado = false;
				pedazos = br.readLine().split("\\s+");
				outlets[i].x = Integer.parseInt(pedazos[0]);
				outlets[i].y = Integer.parseInt(pedazos[1]);
			}
			outlets[inicial].distancia = 0;
			for(int i = 1; i <= nO; i++)
			{
				for(int j = 1; j <= nO; j++)
				{
					if(i == j)
						continue;
					long distancia = hipotenusa(outlets[j].x - outlets[i].x, outlets[j].y - outlets[i].y);
					if(distancia < cables)
					{
						outlets[i].vecinos.add(outlets[j]);
					}
				}
			}
			pq.clear();
			pq.add(outlets[inicial]);
			while(!pq.isEmpty())
			{
				Outlet actual = pq.pollFirst();
				if(actual.numero == ultimo)
					break;
				actual.visitado = true;
				int siguiente = actual.distancia + 1;
				for(Outlet o : actual.vecinos)
				{
					if(o.visitado)
						continue;
					if(siguiente < o.distancia)
					{
						pq.remove(o);
						o.distancia = siguiente;
						pq.add(o);
					}
				}
			}
			System.out.println(outlets[ultimo].distancia == Integer.MAX_VALUE ? "Impossible" : outlets[ultimo].distancia);
		}
	}
}
