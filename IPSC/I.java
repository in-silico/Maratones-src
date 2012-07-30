import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class I 
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
	
	static char[][] matrizA;
	static char[][] matrizB;
	static char[][] matrizC;
	static char[][] matrizD;
	
	static int visitar(int i, int j, int dir, char[][] matriz, char res)
	{
		try
		{
			if(dir == 0)
			{
				if(matriz[i][j] == res)
					return 1 + visitar(i, j + 1, dir, matriz, res);
				return 0;
			}
			else if(dir == 1)
			{
				if(matriz[i][j] == res)
					return 1 + visitar(i + 1, j, dir, matriz, res);
				return 0;
			}
			else if(dir == 2)
			{
				if(matriz[i][j] == res)
					return 1 + visitar(i + 1, j + 1, dir, matriz, res);
				return 0;
			}
			else
			{
				if(matriz[i][j] == res)
					return 1 + visitar(i + 1, j - 1, dir, matriz, res);
				return 0;
			}
		}
		catch(Exception e)
		{
			return 0;
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		int l = leerEnteros(1)[0];
		int cuentaHansel = 0;
		int cuentaGretel = 0;
		for(int i = 0; i < l; i++)
		{
			int[] e = leerEnteros(3);
			int m = e[0];
			int n = e[1];
			int k = e[2];
			matrizA = new char[n][];
			matrizB = new char[n][];
			matrizC = new char[n][];
			matrizD = new char[n][];
			for(int j = 0; j < n; j++)
			{
				String s = br.readLine();
				matrizA[j] = s.toCharArray();
				matrizB[j] = s.toCharArray();
				matrizC[j] = s.toCharArray();
				matrizD[j] = s.toCharArray();
			}
			boolean hansel = false;
			for(int j = 0; !hansel && j < n; j++)
				for(int q = 0; !hansel && q < m; q++)
				{
					if(visitar(j, q, 0, matrizA, 'x') == k)
						hansel = true;
					else if(visitar(j, q, 1, matrizB, 'x') == k)
						hansel = true;
					else if(visitar(j, q, 2, matrizC, 'x') == k)
						hansel = true;
					else if(visitar(j, q, 3, matrizD, 'x') == k)
						hansel = true;
				}
			if(hansel)
				cuentaHansel++;
			else
			{
				boolean gretel = false;
				for(int j = 0; !gretel && j < n; j++)
					for(int q = 0; !gretel && q < m; q++)
					{
						if(visitar(j, q, 0, matrizA, 'o') == k)
							gretel = true;
						else if(visitar(j, q, 1, matrizB, 'o') == k)
							gretel = true;
						else if(visitar(j, q, 2, matrizC, 'o') == k)
							gretel = true;
						else if(visitar(j, q, 3, matrizD, 'o') == k)
							gretel = true;
					}
				if(gretel)
					cuentaGretel++;
			}
		}	
		System.out.println(cuentaHansel + ":" + cuentaGretel);
	}
}
