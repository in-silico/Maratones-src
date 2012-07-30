import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class H 
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
		int caso = 0;
		while(true)
		{
			String s = br.readLine();
			if(s.split(" ").length == 1 && s.trim().equals("0"))
				return;
			int[] numero = new int[10];
			String[] pedazos = s.split(" ");
			int i = Integer.parseInt(pedazos[0]);
			int f = Integer.parseInt(pedazos[1]);
			if(i > f)
			{
				int temp = i;
				i = f;
				f = temp;
			}
			for(int a = i; a <= f; a++)
			{
				s = a + "";
				for(char c : s.toCharArray())
				{
					if(c >= '0' && c <= '9')
						numero[c - '0']++;
				}
			}
			System.out.print("Case " + ++caso + ":");
			for(i = 0; i <= 9; i++)
				System.out.print(" " + i + ":" + numero[i]);
			System.out.println();	
		}
	}
}
