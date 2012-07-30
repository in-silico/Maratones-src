import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class A 
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
	
	static ArrayList <Integer> find_lis(ArrayList <Integer> a)
	{
	        ArrayList <Integer> p = new ArrayList <Integer> (a.size());
	        ArrayList <Integer> b = new ArrayList <Integer> (a.size());
	        for(int i = 0; i < a.size(); i++)
	        	p.add(0);
	        int u, v;
	        if (a.isEmpty()) return b;
	        b.add(0);
	        for (int i = 1; i < a.size(); i++) 
	        {
	                if (a.get(b.get(b.size() - 1)) < a.get(i))
	                {
	                        p.set(i, b.get(b.size() - 1));
	                        b.add(i);
	                        continue;
	                }
	                for (u = 0, v = b.size() - 1; u < v;) 
	                {
	                        int c = (u + v) / 2;
	                        if (a.get(b.get(c)) < a.get(i)) 
	                        	u = c+1; 
	                        else 
	                        	v = c;
	                }

	                if (a.get(i) < a.get(b.get(u))) 
	                {
	                        if (u > 0)
	                        	p.set(i, b.get(u-1));
	                        b.set(u, i);
	                }
	        }
	        for (u = b.size(), v = b.get(b.size() - 1); u-- != 0; v = p.get(v)) 
	        	b.set(u, v);
	        return b;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		ArrayList <Integer> b = new ArrayList <Integer> (100000);
		while(!sc.endLine())
		{
			b.clear();
			int l = sc.nextInt();
			for(int i = 0; i < l; i++)
				b.add(sc.nextInt());
			System.out.println(find_lis(b).size());
		}
	}
}