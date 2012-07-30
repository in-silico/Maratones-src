import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class I 
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public String next()
		{

			while(st == null || !st.hasMoreTokens())
			{
				try { st = new StringTokenizer(br.readLine()); }
				catch(Exception e) { throw new RuntimeException(); }
			}
			return st.nextToken();
		}
		
		public int nextInt()
		{
			return Integer.parseInt(next());
		}
		
		public double nextDouble()
		{
			return Double.parseDouble(next());
		}
		
		public String nextLine()
		{
			st = null;
			try { return br.readLine(); }
			catch(Exception e) { throw new RuntimeException(); }
		}
	}
	
	static Integer[][] dp = new Integer[260][132];
	static ArrayList <Integer> slots = new ArrayList <Integer> ();
	static int[] balls = new int[300];
	static int s;
	static int b;
	
	public static int dp(int slot, int ball)
	{
		if(dp[slot][ball] != null)
			return dp[slot][ball];
		if(slot >= s - 1)
			return dp[slot][ball] = ball == b ? 0 : Integer.MAX_VALUE;
		int pos1 = Integer.MAX_VALUE;
		if(ball != b)
			pos1 = dp(slot + 2, ball + 1);
		if(pos1 != Integer.MAX_VALUE)
			pos1 += (slots.get(slot) + slots.get(slot + 1)) * balls[ball];
		return dp[slot][ball] = Math.min(pos1, dp(slot + 1, ball));
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			s = sc.nextInt();
			b = sc.nextInt();
			if(s == 0 && b == 0)
				return;
			slots.clear();
			for(int i = 0; i < s; i++)
				slots.add(sc.nextInt());
			for(int i = 0; i < b; i++)
				balls[i] = sc.nextInt();
			int mejor = Integer.MAX_VALUE;
			for(int i = 0; i < s; i++)
			{
				for(int j = 0; j < s + 4; j++)
					for(int k = 0; k < b + 4; k++)
						dp[j][k] = null;
				mejor = Math.min(mejor, dp(0, 0));
				Collections.rotate(slots, -1);
			}
			System.out.println(-mejor);
		}
	}
}
