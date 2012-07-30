import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class i 
{
	static Long[][][] dp = new Long[61][61][61];
	static char[] a, b, c;
	
	static Long buscar(int ai, int bi, int ci)
	{
		if(ci == c.length)
			return dp[ai][bi][ci] = 1L;
		if(dp[ai][bi][ci] != null)
			return dp[ai][bi][ci];
		long cuenta = 0;
		char match = c[ci];
		for(int i = ai; i < a.length; i++)
			if(match == a[i])
				cuenta += buscar(i + 1, bi, ci + 1);
		for(int i = bi; i < b.length; i++)
			if(match == b[i])
				cuenta += buscar(ai, i + 1, ci + 1);
		return dp[ai][bi][ci] = cuenta;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int aa = 0; aa < t; aa++)
		{
			String[] pedazos = br.readLine().split(" ");
			a = pedazos[0].toCharArray();
			b = pedazos[1].toCharArray();
			c = pedazos[2].toCharArray();
			for(int i = 0; i <= a.length; i++)
				for(int j = 0; j <= a.length; j++)
					for(int k = 0; k <= c.length; k++)
						dp[i][j][k] = null;
			System.out.println(buscar(0, 0, 0));
		}
	}
}
