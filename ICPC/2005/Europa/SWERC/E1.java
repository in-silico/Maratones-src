import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;


public class E1
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner() throws FileNotFoundException
		{
			br = new BufferedReader(new FileReader("e.in"));
		}
		
		public int nextInt() throws IOException
		{

				if(st == null || !st.hasMoreElements())
					st = new StringTokenizer(br.readLine());
				return Integer.parseInt(st.nextToken());
		}
	}
	
	static HashMap <Long, Integer> ab = new HashMap <Long, Integer> ();
	
	public static void main(String[] args) throws IOException
	{
		int[] a = new int[4001];
		int[] b = new int[4001];
		int[] c = new int[4001];
		int[] d = new int[4001];
		Scanner sc = new Scanner();
		while(true)
		{
			ab.clear();
			int n = sc.nextInt();
			if(n == 0)
				return;
			for(int i = 0; i < n; i++)
			{
				a[i] = sc.nextInt();
				b[i] = sc.nextInt();
				c[i] = sc.nextInt();
				d[i] = sc.nextInt();
			}
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
				{
					long suma = a[i];
					suma += b[j];
					if(ab.containsKey(suma))
						ab.put(suma, ab.get(suma) + 1);
					else
						ab.put(suma, 1);
				}
			long total = 0;
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
				{
					long suma = c[i];
					suma += d[j];
					Integer posible = ab.get(-suma);
					if(posible != null)
						total += posible;
				}
			System.out.println(total);
		}
		
	}

}
