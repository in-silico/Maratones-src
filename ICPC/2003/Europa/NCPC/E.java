import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class E
{
	
	public static long gcd(long a, long b)
	{
		if(b == 0)
			return a;
		return gcd(b, a % b);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++)
		{
			int m = Integer.parseInt(br.readLine());
			String[] pedazos = br.readLine().split(" ");
			long lcm = 1;
			for(int j = 0; j < m; j++)
			{
				long b = Long.parseLong(pedazos[j]);
				lcm = (lcm * b) / gcd(lcm, b);
			}
			if(lcm <= 1000000000)
			{
				System.out.println(lcm);
			}
			else
			{
				System.out.println("More than a billion.");
			}
		}
	}

}
