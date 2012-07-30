import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringTokenizer;


public class E2 
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
				return st.hasMoreTokens();
			}
			catch(Exception e) { throw new RuntimeException(); }
		}
	}
	
	public static void main(String[] args)
	{
		int[] a = new int[4001];
		int[] b = new int[4001];
		int[] c = new int[4001];
		int[] d = new int[4001];
		int[] X = new int[1024*16*1024];
		int[] Y = new int[1024*16*1024];
		Scanner sc = new Scanner();
	    int casos = sc.nextInt();
	    boolean empezo = false;
	    for(int caso = 0; caso < casos; caso++)
	    {
	        if(empezo)
	            System.out.println();
	        empezo = true;
		    int n = sc.nextInt();
		    int N = n * n;			
		    for(int i = 0; i < n; i++)
			{
				a[i] = sc.nextInt();
				b[i] = sc.nextInt();
				c[i] = sc.nextInt();
				d[i] = sc.nextInt();
			}
		    long res = 0;
			int x = 0, y = 0;
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++) 
					X[x++] = a[i] + b[j];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++) 
					Y[y++] = -(c[i] + d[j]);
			Arrays.sort(X, 0, N);
			Arrays.sort(Y, 0, N);
			x = y = 0;
			while (x < N && y < N)
			{
				int aa = X[x];
				int bb = Y[y];
				int v = aa < bb ? aa : bb;
				if (Y[y] == v && X[x] == v)
				{
					int c1 = 0, c2 = 0;
					while (x < N && X[x] == v) {c1++; x++;}
					while (y < N && Y[y] == v) {c2++; y++;}
					res += c1 * c2;
				}
				else if (X[x] < Y[y]) x++; 
				else y++;
			}
			System.out.println(res);
	    }
	}
}