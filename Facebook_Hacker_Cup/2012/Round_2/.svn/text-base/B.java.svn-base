import java.util.Scanner;
import java.lang.Math;

public class B
{	
	static class DisjointSet
	{
		int[] p;
		int[][] bestHeight;
		
		public DisjointSet(int size)
		{
			p = new int[size];
			bestHeight = new int[size][];
			for(int i = 0; i < size; i++)
				make_set(i);
		}

		public void make_set(int x)
		{
			p[x] = x;
		}

		public void merge(int x, int y)
		{
			link(find_set(x), find_set(y));
		}

		public void link(int x, int y)
		{
				p[x] = y;
		}

		public int find_set(int x)
		{
			if (x != p[x])
				p[x] = find_set(p[x]);
			return p[x];
		}
		
		int[] findHeight(int x)
		{
			return bestHeight[find_set(x)];
		}
		
		void setHeight(int x, int[] height)
		{
			bestHeight[find_set(x)] = height;
		}
	}

	static int[][] todos = new int[30001][5001];	
	static int n;
	static Scanner sc;
	static int d;
	static int[] temp = new int[5001];
	static DisjointSet ds;
	
	static int solve()
	{
		for(int j = 0; j < n - 1; j++)
		{
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			int[] heightA = ds.findHeight(a);
			int[] heightB = ds.findHeight(b);
			for(int i = 0; i < d; i++)
			{
				int h1 = Math.max(heightA[i + 1], heightB[0] + 1);
				int h2 = Math.max(heightA[0] + 1, heightB[i + 1]);
				temp[i] = Math.min(h1, h2);
			}
			temp[d] = 1000000;
			for(int i = 0; i <= d; i++)
				heightA[i] = temp[i];
			ds.merge(a, b);
			ds.setHeight(a, heightA);
		}
		return ds.findHeight(0)[0];
	}
	
	public static void main(String[] args)
	{
		sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int caso = 1; caso <= tc; caso++)
		{
			n = sc.nextInt();
			d = sc.nextInt();
			ds = new DisjointSet(n);
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j <= d; j++)
					todos[i][j] = 1;
				ds.setHeight(i, todos[i]);
			}
			System.out.printf("Case #%d: %d\n", caso, solve());
		}
	}
}
