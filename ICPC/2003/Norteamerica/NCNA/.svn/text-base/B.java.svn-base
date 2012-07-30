import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B 
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int[] leerEnteros(int numero) throws IOException
	{
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int[] salida = new int[numero];
		for(int i = 0; i < salida.length; i++)
			salida[i] = Integer.parseInt(st.nextToken());
		return salida;
	}
	
	public static void main(String[] args) throws IOException
	{
		int caso = 1;
		while(true)
		{
			int n = leerEnteros(1)[0];
			if(n == 0)
				return;
			int res = resolver(n) / 2 - 1;
			System.out.println("Case " + caso++ + ", n = " + n + ", unique stars = " + res);
		}
	}

	private static int resolver(int n) 
	{
		int c = 0;
		int total = 1;
		for(int i = 2; n > 1; i++)
		{
			c = 0;
			int cuenta = 1;
			while(n % i == 0)
			{
				c++;
				n /= i;
				cuenta *= i;
			}
			if(c > 0)
				total *= cuenta - cuenta / i;
		}
		return total;
	}
}
