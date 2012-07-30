import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class G 
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public String next()
		{

			while(st == null || !st.hasMoreTokens())
			{
				try { st = new StringTokenizer(br.readLine()); }
				catch(Exception e) { throw new RuntimeException(); }
			}
			return st.nextToken();
		}
		
		public int nextInt()
		{
			return Integer.parseInt(next());
		}
		
		public double nextDouble()
		{
			return Double.parseDouble(next());
		}
		
		public String nextLine()
		{
			st = null;
			try { return br.readLine(); }
			catch(Exception e) { throw new RuntimeException(); }
		}
		
		public boolean endLine()
		{
			try 
			{
				String next = br.readLine();
				while(next != null && next.trim().isEmpty())
					next = br.readLine();
				if(next == null)
					return true;
				st = new StringTokenizer(next);
				return false;
			}
			catch(Exception e) { throw new RuntimeException(); }
		}
	}

	static class Respuesta
	{
		int comp, faltante;
		
		public Respuesta(int c, int f)
		{
			comp = c;
			faltante = f;
		}
	}
	
	static class Planta
	{
		Planta padre;
		ArrayList <Planta> hijos = new ArrayList <Planta> ();
		ArrayList <Respuesta> respuestas = new ArrayList <Respuesta> ();
		int x, y, cap, id;
		
		public Planta(Planta p, int xx, int yy, int cc, int idd)
		{
			padre = p;
			x = xx;
			y = yy;
			cap = cc;
			id = idd;
		}
		
		public Respuesta solucionMagica()
		{
			for(Planta p : hijos)
				respuestas.add(p.solucionMagica());
			int nComp = 0;
			int faltante = 0;
			for(Respuesta r : respuestas)
			{
				nComp += r.comp;
				faltante += r.faltante;
			}
			faltante += cap;
			if(faltante >= c)
			{
				nComp++;
				faltante = 0;
			}
			return new Respuesta(nComp, faltante);
		}
	}
	
	static int c;
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		Planta[] plantas = new Planta[10001];
		while(true)
		{
			int n = sc.nextInt();
			c = sc.nextInt();
			if(n == 0 && c == 0)
				return;
			int x = sc.nextInt();
			int y = sc.nextInt();
			int c = sc.nextInt();
			plantas[0] = new Planta(null, x, y, c, 0);
			for(int i = 1; i < n; i++)
			{
				x = sc.nextInt();
				y = sc.nextInt();
				c = sc.nextInt();
				Planta mejor = null;
				int mejorDistancia = Integer.MAX_VALUE;
				for(int j = 0; j < i; j++)
				{
					Planta actual = plantas[j];
					int distancia = (actual.x - x);
					distancia *= distancia;
					int distancia2 = (actual.y - y);
					distancia2 *= distancia2;
					distancia += distancia2;
					if(distancia < mejorDistancia)
					{
						mejorDistancia = distancia;
						mejor = actual;
					}
				}
				plantas[i] = new Planta(mejor, x, y, c, i);
				mejor.hijos.add(plantas[i]);
			}
			System.out.println(plantas[0].solucionMagica().comp);
		}
	}

}
