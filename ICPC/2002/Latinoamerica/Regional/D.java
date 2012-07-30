import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class D 
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
	
	static class Entrada
	{
		int a;
		int b;
		int c;
		
		public Entrada(int aa, int bb, int cc)
		{
			a = aa;
			b = bb;
			c = cc;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + a;
			result = prime * result + b;
			result = prime * result + c;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			Entrada other = (Entrada) obj;
			if (a == other.a && b == other.b && c == other.c)
				return true;
			return false;
		}
	}
	
	static HashMap <Entrada, Boolean> mapa = new HashMap <Entrada, Boolean> (1000000);
	static int[] cajas = new int[2011];
	static char[] cajasR = new char[2011];
	static int n;

	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			int m = sc.nextInt();
			int l = sc.nextInt();
			if(m == 0 && l == 0)
				return;
			n = sc.nextInt();
			for(int i = 1; i <= n; i++)
				cajas[i] = sc.nextInt();
			mapa.clear();
			boolean resultado = dp(m, l, 1);
			if(resultado)
			{
				int cuenta = 0;
				for(int i = 1; i <= n; i++)
					if(cajasR[i] == 'M')
						cuenta++;
				System.out.print(cuenta);
				for(int i = 1; i <= n; i++)
					if(cajasR[i] == 'M')
						System.out.print(" " + i);
				System.out.println();
			}
			else
				System.out.println("Impossible to distribute");			
		}
	}
	
	static Entrada prueba = new Entrada(0, 0, 0);
	
	static boolean dp(int m, int l, int box)
	{
		if(box == n + 1)
			return true;
		prueba.a = m;
		prueba.b = l;
		prueba.c = box;
		if(mapa.containsKey(prueba))
			return mapa.get(prueba);
		if(m > l)
		{
			if(m >= cajas[box] && dp(m - cajas[box], l, box + 1))
			{
				cajasR[box] = 'M';
				mapa.put(new Entrada(m, l, box), true);
				return true;
			}
			if(l >= cajas[box] && dp(m, l - cajas[box], box + 1))
			{
				cajasR[box] = 'L';
				mapa.put(new Entrada(m, l, box), true);
				return true;
			}
			mapa.put(new Entrada(m, l, box), false);
			return false;
		}
		else
		{
			if(l >= cajas[box] && dp(m, l - cajas[box], box + 1))
			{
				cajasR[box] = 'L';
				mapa.put(new Entrada(m, l, box), true);
				return true;
			}
			if(m >= cajas[box] && dp(m - cajas[box], l, box + 1))
			{
				cajasR[box] = 'M';
				mapa.put(new Entrada(m, l, box), true);
				return true;
			}
			mapa.put(new Entrada(m, l, box), false);
			return false;
		}
	}
}
