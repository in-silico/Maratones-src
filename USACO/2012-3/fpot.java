import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringTokenizer;

public class fpot
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
	
	static class RMQ
	{
		int[] rmq;
		int n;

		RMQ(int[] t)
		{
			int logn = 1;
			n = t.length;
			for (int k = 1; k < n; k *= 2) ++logn;
			rmq = new int[n * logn];
			buildRMQ(t);
		}


		void buildRMQ(int[] t) 
		{
			int[] b = rmq; 
			System.arraycopy(t, 0, b, 0, n);
			int delta = 0;
			for(int k = 1; k < n; k *= 2) 
			{
				System.arraycopy(b, delta, b, n + delta, n);
				delta += n;
				for(int i = 0; i < n - k; i++) b[i + delta] = Math.min(b[i + delta], b[i + k + delta]);
			}
		}
		
		int minimum(int x, int y) 
		{
			int z = y - x, k = 0, e = 1, s;
			s = (((z & 0xffff0000) != 0) ? 1 : 0) << 4; z >>= s; e <<= s; k |= s;
			s = (((z & 0x0000ff00) != 0) ? 1 : 0) << 3; z >>= s; e <<= s; k |= s;
			s = (((z & 0x000000f0) != 0) ? 1 : 0) << 2; z >>= s; e <<= s; k |= s;
			s = (((z & 0x0000000c) != 0) ? 1 : 0) << 1; z >>= s; e <<= s; k |= s;
			s = (((z & 0x00000002) != 0) ? 1 : 0) << 0; z >>= s; e <<= s; k |= s;
			return Math.min(rmq[x + n * k], rmq[y + n * k - e + 1]);
		}
	}
	
	static class Pos implements Comparable <Pos>
	{
		int x, y;
		
		Pos(int x, int y)
		{
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pos o) 
		{
			if(x == o.x)
				return y - o.y;
			return x - o.x;
		}
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		System.setOut(new PrintStream("fpot.out"));
		System.setIn(new FileInputStream("fpot.in"));
		Scanner sc = new Scanner();
		int n = sc.nextInt();
		int d = sc.nextInt();
		Pos[] gotas = new Pos[n];
		for(int i = 0; i < n; i++)
			gotas[i] = new Pos(sc.nextInt(), sc.nextInt());
		Arrays.sort(gotas);
		int[] valores = new int[n];
		for(int i = 0; i < n; i++)
			valores[i] = gotas[i].y;
		RMQ rMinQ = new RMQ(valores);
		for(int i = 0; i < n; i++)
			valores[i] = -valores[i];
		RMQ rMaxQ = new RMQ(valores);
		int mejor = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++)
		{
			int low = i;
	        int high = n - 1;
	        while (low < high)
	        {
	            int mid = (low + high) >>> 1;
	            long midVal = (-rMaxQ.minimum(i, mid)) - rMinQ.minimum(i, mid);
	            if (midVal < d)
	                low = mid + 1;
	            else if (midVal >= d)
	                high = mid;
	        }
	        if(((-rMaxQ.minimum(i, low)) - rMinQ.minimum(i, low)) >= d)
	        	mejor = Math.min(mejor, gotas[low].x - gotas[i].x);
		}
		System.out.println(mejor == Integer.MAX_VALUE ? -1 : mejor);
	}
}
