import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;


public class H 
{
	
	public static boolean esPrimo(int n)
	{
		if(n == 1 || n == 2 || n == 3 || n == 5 || n == 7)
			return true;
		if(n < 10)
			return false;
		int raiz = (int) Math.round(Math.sqrt(n));
		raiz += 1;
		for(int i = 2; i <= raiz; i++)
		{
			if(n % i == 0)
				return false;
		}
		return true;
	}
	static final int limiteA = 1260;
	static final int limiteB = 1260;
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		TreeSet <Integer> explosivos = new TreeSet <Integer> ();
		for(int a = 1; a <= limiteA; a++)
		{
			for(int b = -a + 1; b <= limiteB; b++)
			{
				long actual = 1;
				int anterior = 1;
				for(int i = 1; ; i++)
				{
					int nuevo = a * anterior + b;
					if(nuevo <= anterior || !esPrimo(nuevo))
						break;
					actual *= nuevo;
					if(i >= 3)
					{
						if(actual < 2000000001)
							explosivos.add((int) actual);
					}
					if(actual > 2000000000)
						break;
					anterior = nuevo;
				}
			}
		}
		ArrayList <Integer> arreglo = new ArrayList <Integer> (1000000);
		for(int i : explosivos)
			arreglo.add(i);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ntc = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < ntc; tc++)
		{
			String[] pedazos = br.readLine().split(" ");
			int xl = Integer.parseInt(pedazos[0]);
			int xh = Integer.parseInt(pedazos[1]);
			if(Collections.binarySearch(arreglo, xl) >= 0)
				xl--;
			if(Collections.binarySearch(arreglo, xh) >= 0)
				xh++;
			int numero = ((-Collections.binarySearch(arreglo, xh)) + 1) - ((-Collections.binarySearch(arreglo, xl)) + 1);
			System.out.println(numero);
		}
	}
}
