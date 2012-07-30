import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class D 
{
	static char[] a, b, c;
	
	static Boolean[][][] dp = new Boolean[201][201][401];
	
	public static boolean intentar(int actualA, int actualB, int actualC)
	{
		if(dp[actualA][actualB][actualC] != null)
			return dp[actualA][actualB][actualC];
		if(actualC == c.length)
		{
			if(actualA == a.length && actualB == b.length && actualC == actualA + actualB)
				return dp[actualA][actualB][actualC] = true;
			else
				return dp[actualA][actualB][actualC] = false;
		}
		if(actualA < a.length && a[actualA] == c[actualC])
		{
			if(intentar(actualA + 1, actualB, actualC + 1))
				return dp[actualA][actualB][actualC] = true;
		}
		if(actualB < b.length && b[actualB] == c[actualC])
		{
			if(intentar(actualA, actualB + 1, actualC + 1))
				return dp[actualA][actualB][actualC] = true;
		}
		return dp[actualA][actualB][actualC] = false;
	}
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++)
		{
			String[] pedazos = br.readLine().split(" ");
			a = pedazos[0].toCharArray();
			b = pedazos[1].toCharArray();
			c = pedazos[2].toCharArray();
			for(int ii = 0; ii <= a.length; ii++)
				for(int j = 0; j <= b.length; j++)
					for(int k = ii + j; k <= c.length; k++)
						dp[ii][j][k] = null;
			if(intentar(0, 0, 0))
				System.out.println("Data set " + (i + 1) + ": yes");
			else
				System.out.println("Data set " + (i + 1) + ": no");
		}
	}

}
