import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class D 
{
	
	static HashMap <String, Integer> todasPalabras = new HashMap <String, Integer> (200000);
	@SuppressWarnings("unchecked")
	static HashMap <Long, Integer> [][] hashes = new HashMap[10][10];
	static int consecutivo = 0;
	
	static int darPalabra(String s)
	{
		if(todasPalabras.containsKey(s))
			return todasPalabras.get(s);
		todasPalabras.put(s, consecutivo);
		return consecutivo++;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String linea = br.readLine();
			if(linea == null)
				return;
			consecutivo = 0;
			StringTokenizer st = new StringTokenizer(linea);
			int filas = Integer.parseInt(st.nextToken());
			int columnas = Integer.parseInt(st.nextToken());
			todasPalabras.clear();
			for(int i = 0; i < columnas; i++)
				for(int j = i + 1; j < columnas; j++)
					hashes[i][j] = new HashMap <Long, Integer> (20000);
			boolean paila = false;
			int[] fila = new int[10];
			for(int i = 1; i <= filas; i++)
			{
				st = new StringTokenizer(br.readLine(), ",");
				for(int j = 0; j < columnas; j++)
					fila[j] = darPalabra(st.nextToken());
				if(paila)
					continue;
				for(int j = 0; j < columnas; j++)
					for(int k = j + 1; k < columnas; k++)
					{
						if(paila)
							break;
						long a = fila[j];
						long b = fila[k] + 1000000000;
						b <<= 32;
						a |= b;
						if(hashes[j][k].containsKey(a))
						{
							System.out.println("NO");
							int otra = hashes[j][k].get(a);
							System.out.println(otra + " " + i);
							System.out.println(++j + " " + ++k);
							paila = true;
							break;
						}
						else
							hashes[j][k].put(a, i);
					}
			}
			if(!paila)
				System.out.println("YES");
		}
	}
}