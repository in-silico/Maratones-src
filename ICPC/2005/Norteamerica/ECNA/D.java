import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;


public class D 
{
	static final double delta = 1e-8;
	
	static class Linea implements Comparable <Linea>
	{
		double pendiente;
		double enX0;
		boolean infinita;
		double x1, y1;
		int cuenta = 1;
		
		public Linea(double x1, double x2, double y1, double y2)
		{
			if(Math.abs(x2 - x1) < delta)
			{
				infinita = true;
			}
			else
			{
				pendiente = (y2 - y1) / (x2 - x1);
			}
			this.x1 = x1;
			this.y1 = y1;
			enX0 = f(0);
		}
		
		public double f(int x)
		{
			if(infinita)
				return 0;
			return pendiente * (x - x1) + y1;
		}

		public static int comparar(double a, double b)
		{
			if(Math.abs(a - b) < delta)
				return 0;
			return a < b ? -1 : 1;
		}
		
		@Override
		public int compareTo(Linea o) 
		{
			if(infinita)
			{
				if(!o.infinita)
					return 1;
				return comparar(x1, o.x1);
			}
			if(comparar(pendiente, o.pendiente) == 0)
			{
				return comparar(enX0, o.enX0);
			}
			return comparar(pendiente, o.pendiente);
		}
	}
	



	static int[][] puntos = new int[1001][2];
	static TreeMap <Linea, Linea> lineas = new TreeMap <Linea, Linea> ();
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int foto = 1;
		while(true)
		{
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				break;
			for(int i = 0; i < n; i++)
			{
				String[] pedazos = br.readLine().split("\\s+");
				puntos[i][0] = Integer.parseInt(pedazos[0]);
				puntos[i][1] = Integer.parseInt(pedazos[1]);
			}
			lineas.clear();
			for(int i = 0; i < n; i++)
			{
				for(int j = i + 1; j < n; j++)
				{
					Linea nueva = new Linea(puntos[i][0], puntos[j][0], puntos[i][1], puntos[j][1]);
					if(lineas.containsKey(nueva))
					{
						lineas.get(nueva).cuenta++;
					}
					else
					{
						lineas.put(nueva, nueva);
					}
				}
			}
			int maximo = 0;
			for(Linea l : lineas.values())
			{
				maximo = Math.max(maximo, l.cuenta);
			}
			int cuenta = 0;
			int cuando = 0;
			for(int i = 1; i < maximo; i++)
			{
				cuenta += i;
				if(cuenta == maximo)
				{
					cuando = i + 1;
					break;
				}
			}
			System.out.println("Photo " + foto++ + ": " + (cuando < 4 ? 0 : cuando) + " points eliminated");
		}
	}
}
