import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class D {
	
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
	
	
	
	static int[] perm=new int[15];
	static boolean[] mark=new boolean[15];
	
	static int dist(int actual,int siguiente)
	{
		return  Math.abs(pos[actual][0]-pos[siguiente][0]) + Math.abs(pos[actual][1]-pos[siguiente][1]);
	}
	
	static void generate(int index,int tam)
	{
		if (index==tam)
		{
			/*
			for(int i=0;i<tam;i++)
				System.out.print(perm[i]+" ");
			System.out.println();*/
			
			int distance=0;
			for(int i=0;i<tam-1;i++)
				distance+=dist(perm[i],perm[(i+1)%tam]);
			distance+=dist(0,perm[0]);
			distance+=dist(perm[tam-1],0);
			min=Math.min(min, distance);
			return;
		}
		
		for(int i=1;i<=tam;i++)
		{
			if (mark[i])
				continue;
			mark[i]=true;
			perm[index]=i;
			generate(index+1,tam);
			mark[i]=false;
		}
		return;
	}
	
	
	static int[][] pos=new int[15][2];
	static int min;
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner();
		int number=sc.nextInt();
		
		for(int c=0;c<number;c++)
		{	
			pos[0][0]=sc.nextInt();
			pos[0][1]=sc.nextInt();
			
			int tam=sc.nextInt();
			if (tam==0)
			{
				System.out.println("The shortest path has length 0");
				continue;
			}
			for(int i=1;i<=tam;i++)
			{
				pos[i][0]=sc.nextInt();
				pos[i][1]=sc.nextInt();
			}
			
			min=Integer.MAX_VALUE;
			for(int i=0;i<15;i++)
				mark[i]=false;
			generate(0,tam);
			System.out.println("The shortest path has length " + min);
			
		}
		
		
	}

}
