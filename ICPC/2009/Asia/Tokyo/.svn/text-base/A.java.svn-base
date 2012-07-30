import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class A {

	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st = null;
		
		public Scanner()
		{
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public int nextInt()
		{
			try
			{
				while(st == null || !st.hasMoreTokens())
					st = new StringTokenizer(br.readLine());
				return Integer.parseInt(st.nextToken());
			}
			catch(Exception e)
			{
				throw(new RuntimeException());
			}
		}
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner();
		while(true)
		{
			int w = sc.nextInt();
			int d = sc.nextInt();
			if(w == 0 && d == 0)
				return;
			int cuenta = 0;
			ArrayList <Integer> a = new ArrayList <Integer> ();
			for(int i = 0; i < w; i++)
			{
				int n = sc.nextInt();
				cuenta += n;
				a.add(n);
			}
			for(int i = 0; i < d; i++)
			{
				int n = sc.nextInt();
				cuenta += n;
				for(int j = 0; j < a.size(); j++)
				{
					if(n == a.get(j))
					{
						a.remove(j);
						cuenta -= n;
						break;
					}
				}
			}
			System.out.println(cuenta);
		}
		
	}
}
