import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class B 
{
	static class DisjointSet
	{
		int[] p, rank, siguiente;

		public DisjointSet(int size)
		{
			rank = new int[size];
			p = new int[size];
			siguiente = new int[size];
			for(int i = 0; i < size; i++)
			{
				make_set(i);
			}
		}

		public void make_set(int x)
		{
			p[x] = x;
			rank[x] = 0;
			siguiente[x] = 0;
		}

		public void merge(int x, int y)
		{
			link(find_set(x), find_set(y));
			rank[x] = (Math.abs(x - y) % 1000);
			siguiente[x] = y;
		}
		
		public int costo(int x)
		{
			if(siguiente[x] == x)
				return rank[x];
			return rank[x] + costo(siguiente[x]);
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
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++)
		{
			int n = Integer.parseInt(br.readLine());
			DisjointSet ds = new DisjointSet(n + 1);
			while(true)
			{
				String[] pedazos = br.readLine().split(" ");
				if(pedazos.length == 1)
					break;
				if(pedazos[0].equals("I"))
				{
					ds.merge(Integer.parseInt(pedazos[1]), Integer.parseInt(pedazos[2]));
				}
				else
				{
					System.out.println(ds.costo(Integer.parseInt(pedazos[1])));
				}
			}
		}
	}

}
