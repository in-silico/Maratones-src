import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class A 
{
	
	static String digitosBase(int valor, int base)
	{
		String acum = "";
		while(valor != 0)
		{
			acum += valor % base + " ";
			valor /= base;
		}
		return acum;
	}
	static int solucion(long b1, long b2, int r1, int r2)
	{
		r2--;
		for(int i = r2; i > r1; i--)
		{
			String a = digitosBase(i, (int) b1);
			for(int j = 1; j < 100; j++)
			{
				String s = digitosBase(i * j, (int) b2);
				if(s.equals(a))
					return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++)
		{
			String[] pedazos = br.readLine().split(" ");
			int solucion = solucion(Long.parseLong(pedazos[0]), Long.parseLong(pedazos[1]), Integer.parseInt(pedazos[2]), Integer.parseInt(pedazos[3]));
			if(solucion == -1)
			{
				System.out.println("Non-existent.");
			}
			else
			{
				System.out.println(solucion);
			}
		}
	}

}
