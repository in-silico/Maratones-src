import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintStream;


public class B_CompressionText
{
	
	static String a, b, entrada;
	static int dp[] = new int[100];
	
	public static void main(String[] args) throws IOException
	{
		System.setIn(new FileInputStream("CompressionText.in"));
		System.setOut(new PrintStream("CompressionText.out"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++)
		{
			entrada = br.readLine();
			int menor = entrada.length();
			for(int j = 0; j < entrada.length() - 2; j++)
			{
				a = entrada.substring(j, j + 3);
				for(int k = 0; k < entrada.length() - 2; k++)
				{
					b = entrada.substring(k, k + 3);
					for(int l = 0; l < 100; l++)
					{
						dp[l] = -1;
					}
					menor = Math.min(menor, dp(0));
				}
			}
			System.out.println(menor);
		}
	}
	
	private static int dp(int i)
	{
		if(dp[i] != -1)
			return dp[i];
		if(i == entrada.length())
			return 0;
		int mejor = entrada.length();
		if(i < mejor - 2)
		{
			if(a.equals(entrada.substring(i, i + 3)) || b.equals(entrada.substring(i, i + 3)))
				mejor = 2 + dp(i + 3);
		}
		mejor = Math.min(mejor, 1 + dp(i + 1));
		return dp[i] = mejor;
	}
}
