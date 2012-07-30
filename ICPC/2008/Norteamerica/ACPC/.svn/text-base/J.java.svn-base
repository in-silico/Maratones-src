import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.StringTokenizer;

public class J
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
	
	public static class Estado
	{
		int mm;
		int mf;
		int fm;
		int ff;
		char anterior;
		char primero;
		
		public Estado(int mmi, int mfi, int fmi, int ffi, char ant, char pri)
		{
			mm = mmi;
			mf = mfi;
			fm = fmi;
			ff = ffi;
			anterior = ant;
			primero = pri;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + anterior;
			result = prime * result + ff;
			result = prime * result + fm;
			result = prime * result + mf;
			result = prime * result + mm;
			result = prime * result + primero;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Estado other = (Estado) obj;
			if (anterior != other.anterior)
				return false;
			if (ff != other.ff)
				return false;
			if (fm != other.fm)
				return false;
			if (mf != other.mf)
				return false;
			if (mm != other.mm)
				return false;
			if (primero != other.primero)
				return false;
			return true;
		}
	}
	
	static HashMap <Estado, Boolean> dp = new HashMap <Estado, Boolean> ();
	
	public static boolean dp(int mm, int mf, int fm, int ff, char anterior, char primero)
	{
		Estado nuevo = new Estado(mm, mf, fm, ff, anterior, primero);
		if(dp.containsKey(nuevo))
			return dp.get(nuevo);
		if(mm != 0 && anterior != 'm' && dp(mm - 1, mf, fm, ff, 'm', primero == ' ' ? 'm' : primero))
		{
			dp.put(nuevo, true);
			return true;
		}
		if(mf != 0 && anterior != 'm' && dp(mm, mf - 1, fm, ff, 'f', primero == ' ' ? 'm' : primero))
		{
			dp.put(nuevo, true);
			return true;
		}
		if(fm != 0 && anterior != 'f' && dp(mm, mf, fm - 1, ff, 'm', primero == ' ' ? 'f' : primero))
		{
			dp.put(nuevo, true);
			return true;
		}
		if(ff != 0 && anterior != 'f' && dp(mm, mf, fm, ff - 1, 'f', primero == ' ' ? 'f' : primero))
		{
			dp.put(nuevo, true);
			return true;
		}
		if(mm == 0 && mf == 0 && fm == 0 && ff == 0 && anterior != primero)
		{
			dp.put(nuevo, true);
			return true;
		}
		dp.put(nuevo, false);
		return false;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int n = sc.nextInt();
		for(int i = 0; i < n; i++)
		{
			String s = sc.nextLine();
			StringTokenizer st = new StringTokenizer(s);
			int mm = 0;
			int mf = 0;
			int fm = 0;
			int ff = 0;
			int total = 0;
			while(st.hasMoreTokens())
			{
				String este = st.nextToken();
				if(este.equals("MM"))
					mm++;
				else if(este.equals("MF"))
					mf++;
				else if(este.equals("FM"))
					fm++;
				else
					ff++;
				total++;
			}
			dp.clear();
			if(total == 1 || !dp(mm, mf, fm, ff, ' ', ' '))
				System.out.println("NO LOOP");
			else
				System.out.println("LOOP");
		}
	}
}
