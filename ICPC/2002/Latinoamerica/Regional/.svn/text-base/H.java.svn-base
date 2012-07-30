import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;


public class H 
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner() throws FileNotFoundException
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

	static int N, M;
	static int[] X = new int[105];
	static int[] K = new int[100005];
	static double[] P = new double[100005];
	static double[][] minCost = new double[105][100005];
	static HashMap <Integer, ArrayList <Integer> > mapa = new HashMap < Integer, ArrayList<Integer> > (101);

	static double minCost2(int m, int n)
	{
		if(minCost[m][n] != Double.POSITIVE_INFINITY)
			return minCost[m][n];
		if(m == M)
			return 0;
		double ans = Double.MAX_VALUE;
		ArrayList <Integer> a = mapa.get(X[m]);
		int bb = Collections.binarySearch(a, n);
		if(bb < 0)
		{
			bb += 1;
			bb *= -1;
		}
		for(int b = bb; b < a.size(); b++)
		{
			int i = a.get(b);
			if(i >= n)
				ans = Math.min(ans, minCost2(m + 1, i + 1) + P[i]);
		}
		return minCost[m][n] = ans;
	}
	
	static void clean()
	{
		for(int i = 0; i <= M; i++)
			for(int j = 0; j <= N; j++)
				minCost[i][j] = Double.POSITIVE_INFINITY;
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner();
		while(true)
		{
			M = sc.nextInt();
			N = sc.nextInt();
			clean();
			if(M == 0 && N == 0)
				return;
			mapa.clear();
			for(int i = 0; i < M; i++)
			{
				X[i] = sc.nextInt();
				mapa.put(X[i], new ArrayList <Integer> ());
			}
			for(int j = 0; j < N; j++)
			{
				int temp1 = sc.nextInt();
				double temp2 = sc.nextDouble();
				if(mapa.get(temp1) == null)
				{
					j--;
					N--;
				}
				else
				{
					K[j] = temp1;
					P[j] = temp2;
					mapa.get(temp1).add(j);
				}
			}
			double ans = minCost2(0,0);
	        if (ans == Double.MAX_VALUE)
	            System.out.printf("Impossible\n");
	        else
	            System.out.printf("%.2f\n", ans);
		}
	}
}
