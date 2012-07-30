import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class E
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
	
	static Integer[] grundy = new Integer[10001];
	static ArrayList <Integer> s = new ArrayList <Integer> ();
	
	static int grundy(int x)
	{
		if(grundy[x] != null)
			return grundy[x];
		ArrayList <Integer> posibilidades = new ArrayList <Integer> ();
		for(int i : s)
		{
			int posible = x - i;
			if(posible >= 0)
				posibilidades.add(grundy(posible));
		}
		int mex = 0;
		Collections.sort(posibilidades);
		for(int i : posibilidades)
			if(i == mex)
				mex++;
			else if(i < mex)
				continue;
			else
				break;
		return grundy[x] = mex;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			s.clear();
			int k = sc.nextInt();
			if(k == 0)
				return;
			for(int i = 0; i < k; i++)
				s.add(sc.nextInt());
			for(int i = 0; i <= 10000; i++)
				grundy[i] = null;
			int m = sc.nextInt();
			for(int i = 0; i < m; i++)
			{
				int l = sc.nextInt();
				int acum = 0;
				for(int j = 0; j < l; j++)
				{
					acum ^= grundy(sc.nextInt());
				}
				System.out.print(acum == 0 ? "L" : "W");
			}
			System.out.println();
		}
	}
}
