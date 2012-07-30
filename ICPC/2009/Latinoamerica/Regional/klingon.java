import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class klingon 
{
	static BufferedReader is;
	static char [] numero = new char[19];
	
	private static int leerInt() throws IOException 
	{
		char actual;
		while((actual = (char) is.read()) < '0' || actual > '9');
		int digitos = 1;
		numero[0] = actual;
		while((actual = (char) is.read()) >= '0' && actual <= '9')
		{
			numero[digitos++] = actual;
		}
		return Integer.parseInt(new String(numero, 0, digitos));
	}
	
	@SuppressWarnings("unused")
	private static long leerLong() throws IOException 
	{
		char actual;
		while((actual = (char) is.read()) < '0' || actual > '9');
		int digitos = 1;
		numero[0] = actual;
		while((actual = (char) is.read()) >= '0' && actual <= '9')
		{
			numero[digitos++] = actual;
		}
		return Long.parseLong(new String(numero, 0, digitos));
	}
	
	public static void main(String [] args) throws IOException
	{
		is = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			int nDivisiones = leerInt();
			if(nDivisiones == 0)
				break;
			int [] acumulado = new int[1001];
			for(int i = 0; i < nDivisiones; i++)
			{
				int nEstudiantes = leerInt();
				double [] division = new double[nEstudiantes];
				for(int j = 0; j < nEstudiantes; j++)
				{
					division[j] = leerInt();
				}
				Arrays.sort(division);
				for(int j = 0; j < 1001; j++)
				{
					int posicion = (-1 * Arrays.binarySearch(division, j - 0.5)) - 1;
					acumulado[j] += Math.abs(nEstudiantes - posicion - posicion);
				}
			}
			int menor = Integer.MAX_VALUE;
			for(int i = 0; i < 1001; i++)
			{
				if(acumulado[i] < menor)
					menor = acumulado[i];
			}
			System.out.println(menor);
		}
	}

}
