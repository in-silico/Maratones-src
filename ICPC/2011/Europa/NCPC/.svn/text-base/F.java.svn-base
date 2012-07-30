import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class F {
	
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
	
	
	static class alse implements Comparable<alse>
	{
		int year;
		int strength;
		boolean mine;
		public alse(int a,int b)
		{
			this.year=a;
			this.strength=b;
			mine=false;
		}
		@Override
		public int compareTo(alse o) {
			// TODO Auto-generated method stub
			return o.strength-this.strength;
		}
	}
	
	static class pair implements Comparable<pair>
	{
		int year;
		int strength;
		boolean mine;
		public pair(int a,int b)
		{
			this.year=a;
			this.strength=b;
			mine=false;
		}
		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return this.year-o.year;
		}
	}
	
	public static void main(String args[])
	{
		PriorityQueue<alse> pq=new PriorityQueue<alse>();
		pair[] array=new pair[200020];
		for(int i=0;i<200020;i++)
			array[i]=new pair(0,0);
		Scanner sc=new Scanner();
		int K,N;
		
		while(!sc.endLine())
		{
			K=sc.nextInt();
			N=sc.nextInt();
			array[0].year=sc.nextInt();
			array[0].strength=sc.nextInt();
			array[0].mine=true;
			for(int i=1;i<=N+K-2;i++)
			{
				array[i].year=sc.nextInt();
				array[i].strength=sc.nextInt();
				array[i].mine=false;
			}
			
			Arrays.sort(array, 0, N+K-1);
			pq.clear();
			int year=2011;
			int i=0;
			for(;i<N+K-1;i++)
			{
				if (array[i].year!=2011)
					break;
				alse actual=new alse(2011,array[i].strength);
				actual.mine=array[i].mine;
				pq.add(actual);
			}
			
			boolean flag=false;
			for(;i<N+K-1;i++)
			{
				alse mejor=pq.poll();
				if (mejor.mine==true)
					{
						year=array[i-1].year;
						flag=true;
						break;
					}
				alse tmp=new alse(array[i].year,array[i].strength);
				tmp.mine=array[i].mine;
				pq.add(tmp);
			}
			
			if (flag)
				System.out.println(year);
			else
			{
				alse mejor=pq.poll();
				if (mejor.mine==true)
					System.out.println(array[i-1].year);
				else
					System.out.println("unknown");
			}
				
		}	
		
		
		
	}

}
