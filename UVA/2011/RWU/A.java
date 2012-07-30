import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class A 
{
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
		
		public long nextLong() throws IOException
		{
			return Long.parseLong(next());
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner();
		long[] factorial = new long[21];
		factorial[0] = 1;
		for(int i = 1; i <= 20; i++)
			factorial[i] = factorial[i - 1] * i;
		int n = sc.nextInt();
		for(int caso = 0; caso < n; caso++)
		{
			String s = sc.next();
			long nPermutacion = sc.nextLong();
			nPermutacion--;
			char[] respuesta = new char[s.length()];
			long temp = nPermutacion;
			for(int i = 0; i < s.length(); i++)
			{
				int siguiente = (int) (temp / factorial[s.length() - i - 1]);
				int numero = 0;
				for(int j = 0; j < s.length(); j++)
				{
					if(numero == siguiente && respuesta[j] == 0)
					{
						respuesta[j] = s.charAt(i);
						break;
					}
					if(respuesta[j] == 0)
						numero++;
				}
				temp = temp % factorial[s.length() - i - 1];
			}
			System.out.println("Case " + (caso + 1) + ": " + new String(respuesta));
		}
	}
}