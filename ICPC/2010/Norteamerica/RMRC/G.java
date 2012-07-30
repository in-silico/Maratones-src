import java.util.Scanner;


public class G 
{
	static int[] a = new int[1001];
	static int[] b = new int[1001];
	static int[] c = new int[2002];
	
	static int aa, bb;
	static int posible = 0;
	
	static Boolean[][] dp = new Boolean[1001][1001];
	
	public static boolean dp(int ai, int bi)
	{
		if(dp[ai][bi] != null)
			return dp[ai][bi];
		if(ai == aa && bi == bb)
			return dp[ai][bi] = true;
		if(ai == aa)
			return dp[ai][bi] = c[ai + bi] == b[bi] ? dp(ai, bi + 1) : false;
		else if(bi == bb)
			return dp[ai][bi] = c[ai + bi] == a[ai] ? dp(ai + 1, bi) : false;
		else
		{
			if(c[ai + bi] == b[bi] && dp(ai, bi + 1))
				return dp[ai][bi] = true;
			return dp[ai][bi] = (c[ai + bi] == a[ai] ? dp(ai + 1, bi) : false);
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			aa = sc.nextInt();
			bb = sc.nextInt();
			if(aa == 0 && bb == 0)
				return;
			for(int i = 0; i < aa; i++)
				a[i] = sc.nextInt();
			for(int i = 0; i < bb; i++)
				b[i] = sc.nextInt();
			for(int i = 0; i < aa + bb; i++)
				c[i] = sc.nextInt();
			for(int i = 0; i <= aa; i++)
				for(int j = 0; j <= bb; j++)
					dp[i][j] = null;
			System.out.println((dp(0, 0) ? "" : "not ") + "possible");
		}
	}
}
