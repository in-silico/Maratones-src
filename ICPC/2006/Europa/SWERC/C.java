import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class C 
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
	
	static public class DS
	{
		int[] array;
		public DS(int t)
		{
			array=new int[t];
		}
		
		public void inicializar(int t)
		{
			for(int i=0;i<t;i++)
				array[i]=i;
		}
		
		public int find_set(int a)
		{
			int tmp=a;
			if (a!=array[a])
				tmp=find_set(array[a]);
			array[a]=tmp;
			return array[a];
			
		}
		public void merge(int a,int b)
		{
			array[find_set(a)]=find_set(b);
		}
		
		
	}
	
	
	
	
	
	public static void main(String args[]) throws IOException
	{
		int n1,n2;
		Scanner sc = new Scanner();
		int refusals=0;
		DS disset=new DS(100005);
		while(true)
		{
			
			disset.inicializar(100005);
			refusals=0;
			while(true)
			{
				n1=sc.nextInt();
				if(n1 == -1)
					break;
				n2=sc.nextInt();
				if (disset.find_set(n1)==disset.find_set(n2))
				{
					refusals++;
					continue;
				}
				disset.merge(n1, n2);
			}
			System.out.println(refusals);
			if(sc.endLine())
				return;
		}	
	}

}
