import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fuses
{
	static int[] fuses = new int[21];
	static boolean[] prendido = new boolean[21];
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nn = 1;
		while(true)
		{
			String[] pedazos = br.readLine().split(" ");
			int n = Integer.parseInt(pedazos[0]);
			int m = Integer.parseInt(pedazos[1]);
			int c = Integer.parseInt(pedazos[2]);
			if(n == 0 && m == 0 && c == 0)
				return;
			int maxCap = -1;
			for(int i = 1; i <= n; i++)
			{
				fuses[i] = Integer.parseInt(br.readLine());
				prendido[i] = false;
			}
			for(int i = 0; i < m; i++)
			{
				int lectura = Integer.parseInt(br.readLine());
				prendido[lectura] = !prendido[lectura];
				int total = 0;
				for(int j = 1; j <= n; j++)
				{
					total += prendido[j] ? fuses[j] : 0;
				}
				maxCap = Math.max(total, maxCap);
			}
			System.out.println("Sequence " + nn++);
			if(maxCap > c)
			{
				System.out.println("Fuse was blown.");
			}
			else
			{
				System.out.println("Fuse was not blown.");
				System.out.println("Maximal power consumption was " + maxCap + " amperes.");
			}
			System.out.println();
		}
	}
}
