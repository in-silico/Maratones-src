import java.math.BigInteger;
import java.util.Scanner;


public class Priest 
{
	static BigInteger[] dp = new BigInteger[10001];
	static BigInteger[] dp2 = new BigInteger[10001];
	static BigInteger[] unos = new BigInteger[10001];
	
	public static void llenarDp()
	{
		dp[0] = BigInteger.ZERO;
		dp[1] = BigInteger.valueOf(1);
		dp[2] = BigInteger.valueOf(3);
		dp2[1] = dp[1].shiftLeft(1);
		dp2[2] = dp[2].shiftLeft(1);
		for(int i = 1; i <= 10000; i++)
			unos[i] = BigInteger.ONE.shiftLeft(i).subtract(BigInteger.ONE);
		for(int i = 3; i <= 10000; i++)
		{
			BigInteger minimum = BigInteger.ONE.shiftLeft(i).subtract(BigInteger.ONE);
			for(int j = Math.min(i - 1, 140); j >= 1; j--)
			{
				BigInteger before = minimum;
				minimum = minimum.min(dp2[i - j].add(unos[j]));
				if(minimum == before)
					break;
			}
			dp[i] = minimum;
			dp2[i] = dp[i].shiftLeft(1);
		}
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		llenarDp();
		while(sc.hasNextInt())
			System.out.println(dp[sc.nextInt()]);
	}
}
