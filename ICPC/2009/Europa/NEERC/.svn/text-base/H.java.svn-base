import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class H {
	
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
	
	public static void main(String args[]) throws IOException
	{
		//Scanner sc=new Scanner();
		BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String cad=rd.readLine();
			if (cad==null)
				break;
			char[] array=cad.toCharArray();
			int nzeros=0;
			int amount_zero=0;
			int nzeros_zero=0;
			for(int i=0;i<array.length;i++)
			{
				if (array[i]=='0')
				{
					nzeros++;
					if (array[(i+1)%array.length]=='0')
						nzeros_zero++;
					else {
					}
					amount_zero++;
				} else {
				}
			}
		
			double rotate=((double)nzeros)/array.length;
			double shot=((double)nzeros_zero)/amount_zero;
			
			if (Math.abs(rotate-shot)<1e-7)
			{
				System.out.println("EQUAL");
				continue;
			}
			if (rotate>shot)
				System.out.println("ROTATE");
			else
				System.out.println("SHOOT");
			
			
			
		}
	}


}
