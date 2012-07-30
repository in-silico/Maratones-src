import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class H {
	
	static class Scanner
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		public String next() throws IOException
		{
			while(st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		
		public int nextInt() throws IOException
		{
			return Integer.parseInt(next());
		}
	}
	
	public static void main(String args[]) throws IOException
	{
		Scanner sc=new Scanner();
		int T=sc.nextInt();
		for(int i=1;i<=T;i++)
		{
			int income=sc.nextInt();
			System.out.println("Case "+i+": "+solve(income));
		}
	}
	
	static double epsilon=1e-7;

	private static int solve(int income) {
		
		double tax=0;
		income-=180000;
		if (income<=0)
		{
			return 0;
		}
		if (income<=300000)
		{
			tax+=((double)income)*0.1;
			int tmp=(int)tax;
			if (Math.abs(tmp-tax)<epsilon)
			{
				return (tmp<=2000)?2000:tmp;
			}
			tmp++;
			return (tmp<=2000)?2000:tmp;
		}
		income-=300000;
		tax+=30000;
		if (income<=400000)
		{
			tax+=((double)income)*0.15;
			int tmp=(int)tax;
			if (Math.abs(tmp-tax)<epsilon)
			{
				return (tmp<=2000)?2000:tmp;
			}
			tmp++;
			return (tmp<=2000)?2000:tmp;
		}
		income-=400000;
		tax+=60000;
		if (income<=300000)
		{
			tax+=((double)income)*0.2;
			int tmp=(int)tax;
			if (Math.abs(tmp-tax)<epsilon)
			{
				return (tmp<=2000)?2000:tmp;
			}
			tmp++;
			return (tmp<=2000)?2000:tmp;
		}
		income-=300000;
		tax+=60000;
		tax+=((double)income)*0.25;
		int tmp=(int)tax;
		if (Math.abs(tmp-tax)<epsilon)
		{
			return (tmp<=2000)?2000:tmp;
		}
		tmp++;
		return (tmp<=2000)?2000:tmp;
	
	}

}
