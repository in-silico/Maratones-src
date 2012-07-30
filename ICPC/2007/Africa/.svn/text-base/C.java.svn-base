import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class C 
{
	static int n; 
	static int[][] original = new int[1010][1010];
	static int[][] rotada = new int[1010][1010];
	

	private static void poner(int iInicio, int iFin, int jInicio, int jFin, int numeroActual) 
	{
		LinkedList <Integer> anillo = new LinkedList <Integer> ();
		int iEncontrado = 0;
		int actual = 0;
		for(int j = jInicio; j <= jFin; j++)
		{
			if(original[iInicio][j] == numeroActual)
			{
				iEncontrado = actual;
			}
			anillo.add(original[iInicio][j]);
			actual++;
		}
		for(int i = iInicio + 1; i <= iFin; i++)
		{
			if(original[i][jFin] == numeroActual)
			{
				iEncontrado = actual;
			}
			anillo.add(original[i][jFin]);
			actual++;
		}
		for(int j = jFin - 1; j >= jInicio; j--)
		{
			if(original[iFin][j] == numeroActual)
			{
				iEncontrado = actual;
			}
			anillo.add(original[iFin][j]);
			actual++;
		}
		for(int i = iFin - 1; i > iInicio; i--)
		{
			if(original[i][jInicio] == numeroActual)
			{
				iEncontrado = actual;
			}
			anillo.add(original[i][jInicio]);
			actual++;
		}
		List <Integer> pedazoAdelante = anillo.subList(iEncontrado, anillo.size());
		pedazoAdelante.addAll(anillo.subList(0, iEncontrado));
		Iterator <Integer> it = pedazoAdelante.iterator();
		for(int j = jInicio; j <= jFin; j++)
		{
			rotada[iInicio][j] = it.next();
		}
		for(int i = iInicio + 1; i <= iFin; i++)
		{
			rotada[i][jFin] = it.next();
		}
		for(int j = jFin - 1; j >= jInicio; j--)
		{
			rotada[iFin][j] = it.next();
		}
		for(int i = iFin - 1; i > iInicio; i--)
		{
			rotada[i][jInicio] = it.next();
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numero = 1;
		while(true)
		{
			n = Integer.parseInt(br.readLine());
			if(n == 0)
				return;
			for(int i = 0; i < n; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++)
				{
					original[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int iInicio = 0;
			int jInicio = 0;
			int iFin = n - 1;
			int jFin = n - 1;
			int numeroActual = 1;
			while(iInicio <= iFin && jInicio <= jFin)
			{
				poner(iInicio++, iFin--, jInicio++, jFin--, numeroActual);
				numeroActual += n + 1;
			}
			int cuenta = 1;
			boolean si = true;
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < n; j++)
				{
					if(rotada[i][j] != cuenta++)
					{
						si = false;
						break;
					}
				}
			}
			System.out.println(numero++ + ". " + (si ? "YES" : "NO"));
		}
	}
}
