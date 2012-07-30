import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Svemir 
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
	    	System.setOut(new PrintStream(new BufferedOutputStream(System.out), true));
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
				return !st.hasMoreTokens();
			}
			catch(Exception e) { throw new RuntimeException(); }
		}
	}
	
	static int ids = 0;
	
	public static class Planet
	{
		long x, y, z;
		int id = ids++;
		Planet closestX;
		Planet closestY;
		Planet closestZ;
		Planet closestP;
		long closest;

		public Planet(long x, long y, long z)
		{
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		void calcularClosest()
		{
			closestX = calcularMejor(enX, 0);
			closestY = calcularMejor(enY, 1);
			closestZ = calcularMejor(enZ, 2);
			closest = Integer.MAX_VALUE;
			closestP = null;
			if(closestX != null)
			{
				closest = Math.min(closest, Math.abs(x - closestX.x));
				closestP = closestX;
			}
			if(closestY != null)
			{
				long anterior = closest;
				closest = Math.min(closest, Math.abs(y - closestY.y));
				if(anterior != closest)
					closestP = closestY;
			}
			if(closestZ != null)
			{
				long anterior = closest;
				closest = Math.min(closest, Math.abs(z - closestZ.z));
				if(anterior != closest)
					closestP = closestZ;
			}
		}
		
		Planet calcularMejor(TreeMap <Planet, Planet> a, int cual)
		{
			Planet p = a.ceilingKey(this);
			Planet p1 = a.floorKey(this);
			if(p != null)
			{
				if(p1 == null)
					return p;
				else
				{
					if(cual == 0)
						return Math.abs(p1.x - x) > Math.abs(p.x - x) ? p : p1;
					else if(cual == 1)
						return Math.abs(p1.y - y) > Math.abs(p.y - y) ? p : p1;
					else
						return Math.abs(p1.z - z) > Math.abs(p.z - z) ? p : p1;
				}
			}
			else
				return p1;
		}
		
	}
	
	static TreeMap <Planet, Planet> enX = new TreeMap <Planet, Planet> (new Comparator<Planet>()
			{

				@Override
				public int compare(Planet o1, Planet o2) 
				{
					if(o1.x == o2.x)
						return o1.id - o2.id;
					return (int) (o1.x - o2.x);
				}
	});
	
	static TreeMap <Planet, Planet> enY = new TreeMap <Planet, Planet> (new Comparator<Planet>()
			{

				@Override
				public int compare(Planet o1, Planet o2) 
				{
					if(o1.y == o2.y)
						return o1.id - o2.id;
					return (int) (o1.y - o2.y);
				}
	});
	
	static TreeMap <Planet, Planet> enZ = new TreeMap <Planet, Planet> (new Comparator<Planet>()
			{

				@Override
				public int compare(Planet o1, Planet o2) 
				{
					if(o1.z == o2.z)
						return o1.id - o2.id;
					return (int) (o1.z - o2.z);
				}
			});
	
	static TreeMap <Planet, Planet> actuales = new TreeMap <Planet, Planet> (new Comparator<Planet>()
			{
				@Override
				public int compare(Planet o1, Planet o2) 
				{
					if(o1.closest == o2.closest)
						return o1.id - o2.id;
					return (int) (o1.closest - o2.closest);
				}
			});
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int n = sc.nextInt();
		for(int i = 0; i < n; i++)
		{
			Planet nuevo = new Planet(sc.nextInt(), sc.nextInt(), sc.nextInt());
			enX.put(nuevo, nuevo);
			enY.put(nuevo, nuevo);
			enZ.put(nuevo, nuevo);
			if(i == n - 1)
			{
				enX.remove(nuevo);
				enY.remove(nuevo);
				enZ.remove(nuevo);
				nuevo.calcularClosest();
				actuales.put(nuevo, nuevo);
			}
		}
		long costo = 0;
		while(!enX.isEmpty())
		{
			Planet mejor = actuales.firstKey();
			if(actuales.containsKey(mejor.closestP))
			{
				actuales.remove(mejor);
				mejor.calcularClosest();
				actuales.put(mejor, mejor);
				continue;
			}
			costo += mejor.closest;
			Planet nuevo = mejor.closestP;
			enX.remove(nuevo);
			enY.remove(nuevo);
			enZ.remove(nuevo);
			nuevo.calcularClosest();
			actuales.put(nuevo, nuevo);
		}
		System.out.println(costo);
	}
}