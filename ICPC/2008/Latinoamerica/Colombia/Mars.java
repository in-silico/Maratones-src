import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Mars 
{

	static int[] entrada = new int[100000];
	static int[] salida = new int[100000];
	static int[] faltantes = new int[100000];
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int tam = st.countTokens();
			for(int i = 0; i < tam; i++)
			{
				entrada[i] = Integer.parseInt(st.nextToken());
				salida[i] = -1;
			}
			if(tam == 1 && entrada[0] == 0)
				return;
			Arrays.sort(entrada, 0, tam);
			int posEntrada = 0;
			int posFaltantes = 0;
			for(int i = 0; i < tam; i++)
			{
				while(posEntrada != tam && entrada[posEntrada] < i )
					faltantes[posFaltantes++] = entrada[posEntrada++];
				if(posEntrada == tam)
					continue;
				if(entrada[posEntrada] == i)
				{
					salida[i] = entrada[posEntrada++];
					while(posEntrada != tam && entrada[posEntrada] == i)
						faltantes[posFaltantes++] = entrada[posEntrada++];
				}
			}
			if(posEntrada != tam)
				System.out.println("Message hacked by the Martians!!!");
			else
			{
				int pFaltantes = 0;
				for(int i = 0; i < tam; i++)
				{
					if(salida[i] == -1)
						salida[i] = faltantes[pFaltantes++];
				}
				System.out.print(salida[0]);
				for(int i = 1; i < tam; i++)
					System.out.print(" " + salida[i]);
				System.out.println();
			}
			
		}
	}
}
