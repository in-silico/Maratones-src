import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class B
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
	}
	
	static class Sequencia
	{
		TreeMap <Integer, Integer> numeros = new TreeMap <Integer, Integer> ();
		
		public Sequencia(int n)
		{
			numeros.put(n, 1);
			String actual = n + "";
			for(int i = 2; ; i++)
			{
				int siguiente = 0;
				for(char c : actual.toCharArray())
					siguiente += (c - '0') * (c - '0');
				if(numeros.containsKey(siguiente))
					break;
				numeros.put(siguiente, i);
				actual = siguiente + "";
			}
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a == 0 && b == 0)
				return;
			Sequencia as = new Sequencia(a);
			Sequencia bs = new Sequencia(b);
			int mejor = Integer.MAX_VALUE;
			for(Map.Entry<Integer, Integer> e : as.numeros.entrySet())
			{
				int numero = e.getKey();
				if(!bs.numeros.containsKey(numero))
					continue;
				mejor = Math.min(mejor, e.getValue() + bs.numeros.get(numero));
			}
			for(Map.Entry<Integer, Integer> e : bs.numeros.entrySet())
			{
				int numero = e.getKey();
				if(!as.numeros.containsKey(numero))
					continue;
				mejor = Math.min(mejor, e.getValue() + as.numeros.get(numero));
			}
			System.out.println(a + " " + b + " " + (mejor == Integer.MAX_VALUE ? 0 : mejor));
		}
	}
}
