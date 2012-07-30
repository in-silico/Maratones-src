import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class J
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
	    	System.setOut(new PrintStream(new BufferedOutputStream(System.out, 1000000)));
			br = new BufferedReader(new InputStreamReader(System.in), 1000000);
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
	
	static long[] fenwickTree = new long[100001];
	static int[] bs = new int[100001];
	static int p;
	static int l;
	
	static void create() 
	{
		for(int i = 0; i <= l; i++)
			fenwickTree[i] = 0;
	}

	static int query(int a, int b) 
	{
	    if (a == 0)
	    {
	        int sum = 0;
	        for (; b >= 0; b = (b & (b + 1)) - 1)
	        {
	          sum += fenwickTree[b];
	          sum %= p;
	        }
	        return sum;
	    } 
	    else 
	    {
	        return ((query(0, b) - query(0, a - 1)) + p) % p;
	    }
	}

	static void increase(int k, int inc)
	{
	    for (; k < l + 1; k |= k + 1)
	    {
	        fenwickTree[k] += inc;
	        fenwickTree[k] += p;
	        fenwickTree[k] %= p;
	    }
	}
	
	static long modInverse(long a, long n) 
	{
		 long i = n, v = 0, d = 1;
		 while (a > 0)
		 {
			  long t = i / a, x = a;
			  a = i % x;
			  i = x;
			  x = d;
			  d = v - t * x;
			  v = x;
		 }
		 v %= n;
		 if (v < 0) v = (v + n) % n;
		 return v;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			int b = sc.nextInt();
			p = sc.nextInt();
			l = sc.nextInt();
			int n = sc.nextInt();
			if(b == 0 && p == 0 && l == 0 && n == 0)
			{
				System.out.flush();
				return;
			}
			bs[0] = 1;
			create();
			for(int i = 1; i <= l; i++)
			{
				long anterior = bs[i - 1];
				anterior *= b;
				anterior %= p;
				bs[i] = (int) anterior;
			}
			for(int i = 0; i < n; i++)
			{
				String comando = sc.next();
				if(comando.equals("E"))
				{
					int pos = sc.nextInt();
					int val = sc.nextInt();
					int actual = query(pos, pos);
					increase(pos, -actual);
					long res = bs[l - pos];
					res *= val;
					res %= p;
					increase(pos, (int) res);
				}
				else
				{
					int inicio = sc.nextInt();
					int fin = sc.nextInt();
					int actual = query(inicio, fin);
					long res = bs[l - fin];
					res = modInverse(res, p);
					System.out.println((actual * res) % p);
				}
			}
			System.out.println("-");
		}
	}
}