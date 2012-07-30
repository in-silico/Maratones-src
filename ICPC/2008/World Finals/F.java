import java.math.BigInteger;


public class F
{
	static BigInteger[][][][] dp = new BigInteger[10][1001][2][2];
	static int n;
	
	static BigInteger dp(int numr, int pos, boolean lastO, boolean firstO)
	{
		if(dp[numr + 1][pos][lastO ? 1 : 0][firstO ? 1 : 0] != null)
			return dp[numr + 1][pos][lastO ? 1 : 0][firstO ? 1 : 0];
		if(pos == n)
			return (numr == 4) ? BigInteger.ONE : BigInteger.ZERO;
		BigInteger acum = BigInteger.ZERO;
		if(numr < 5)
			acum = acum.add(dp(numr + 1, pos + 1, false, pos == 0 ? false : firstO));
		if(!lastO && !(pos == n - 1 && firstO))
			acum = acum.add(dp(numr - 1, pos + 1, true, pos == 0 ? true : firstO));
		return dp[numr + 1][pos][lastO ? 1 : 0][firstO ? 1 : 0] = acum;
	}
	public static void main(String[] args)
	{
		System.out.print("{\"0\",\n");
		for(int i = 1; i < 1001; i++)
		{
			for(int j = 0; j < 10; j++)
				for(int k = 0; k < 1001; k++)
					for(int l = 0; l < 2; l++)
						for(int m = 0; m < 2; m++)
						dp[j][k][l][m] = null;
			n = i;
			System.out.println("\"" + dp(0, 0, false, false) + "\",");
		}
		System.out.println("};");
	}

}
