import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;


public class j
{
	static class Piramide implements Comparable <Piramide>
	{
		int cubos;
		int tamCubos;
		boolean alta;
		String nombre;
		
		public Piramide(int c, int tc, boolean a)
		{
			cubos = c;
			tamCubos = tc;
			alta = a;
			nombre = cubos + (a ? "H" : "L");
		}

		@Override
		public int compareTo(Piramide o)
		{
			return o.tamCubos - tamCubos;
		}
	}
	
	static int[] valores = new int[320];
	static int[][] minMax = new int[7][1000001];
	static Piramide[] piramides = new Piramide[320];

	static void generar()
	{
		int[] acumulado = new int[320];
		TreeMap <Integer, Piramide> enOrden = new TreeMap <Integer, Piramide> ();
		acumulado[0] = 0;
		acumulado[1] = 1;
		for(int i = 2; true; i++)
		{
			acumulado[i] = acumulado[i - 1] + i * i;
			if(acumulado[i] > 1000000)
				break;
			enOrden.put(acumulado[i], new Piramide(i, acumulado[i], true));
		}
		acumulado[0] = 0;
		acumulado[1] = 1;
		acumulado[2] = 4;
		for(int i = 3; true; i++)
		{
			acumulado[i] = acumulado[i - 2] + i * i;
			if(acumulado[i] > 1000000)
				break;
			enOrden.put(acumulado[i], new Piramide(i, acumulado[i], false));
		}
		int j = 0;
		for(Map.Entry <Integer, Piramide> e : enOrden.entrySet())
		{
			valores[j] = e.getKey();
			piramides[j++] = e.getValue();
		}
		minMax[0][0] = -1;
		for(int i = 1; i < 1000001; i++)
			minMax[0][i] = Integer.MAX_VALUE;
		for(int k = 1; k < 7; k++)
			for(int n = 1; n < 1000001; n++)
			{
//				if(minMax[k - 1][n] != Integer.MAX_VALUE)
//					minMax[k][n] = minMax[k - 1][n];
//				else
//				{
					int menor = Arrays.binarySearch(valores, n / k - 1);
					int mayor = Arrays.binarySearch(valores, n + 1);
					if(menor < 0)
					{
						menor++;
						menor = -menor;
					}
					if(mayor < 0)
					{
						mayor++;
						mayor = -mayor;
					}
					minMax[k][n] = Integer.MAX_VALUE;
					for(int i = menor; i < mayor; i++)
					{
						if(valores[i] > n)
							break;
						if(minMax[k - 1][n - valores[i]] < i)
						{
							minMax[k][n] = i;
							break;
						}
					}
				}
//			}
	}
	
	public static String solucionar(int n)
	{
		ArrayList <Piramide> respuesta = new ArrayList <Piramide> ();
		int i = 1;
		for(i = 1; i < 7; i++)
		{
			if(minMax[i][n] != Integer.MAX_VALUE)
				break;
		}
		if(i == 7)
			return " impossible";
		int anterior = 320;
		int nActual = n;
		for(int j = 1; j <= i; j++)
		{
			int mejor = 0;
			for(int s = 0; s < anterior; s++)
			{
				if(valores[s] > nActual)
					break;
				if(minMax[i - j][nActual - valores[s]] < s)
					mejor = s;
			}
			anterior = mejor;
			nActual -= valores[mejor];
			respuesta.add(piramides[mejor]);
		}
//		if(nActual != 0)
//			System.out.println("paila");
		Collections.sort(respuesta);
		String res = "";
		int valor = 0;
//		for(int a = 0; a < respuesta.size(); a++)
//			for(int j = 0; j < respuesta.size(); j++)
//				if(a != j && respuesta.get(a) == respuesta.get(j))
//					System.out.println("paila");
//		if(respuesta.size() == 6)
//			System.out.println(n);
		for(Piramide p : respuesta)
			valor += p.tamCubos;
		if(valor != n)
			System.out.println("paila");
		for(Piramide p : respuesta)
			res += " " + p.nombre;
		return res;
	}
	
	static class Entrada
	{
		public Entrada(int i, int j, Entrada object) 
		{
			actual = i;
			tam = j;
			siguiente = object;
		}
		
		int tam;
		int actual;
		Entrada siguiente;
	}
	
	static Entrada[][] dp = new Entrada[321][10000];
	static Entrada nula = new Entrada(0, 0, null);
	
	public static Entrada dp(int maximo, int faltante)
	{
		if(faltante == 0)
			return new Entrada(0, 0, null);
		if(dp[maximo][faltante] != null)
			return dp[maximo][faltante];
		Entrada actual = null;
		for(int i = 0; i < maximo; i++)
		{
			if(valores[i] > faltante)
				break;
			Entrada siguiente = dp(i, faltante - valores[i]);
			if(siguiente != nula)
			{
				if(actual == null)
					actual = new Entrada(i, siguiente.tam + 1, siguiente);
				else
				{
					if(actual.tam >= siguiente.tam + 1)
						actual = new Entrada(i, siguiente.tam + 1, siguiente);
				}
			}
		}
		if(actual == null)
			return dp[maximo][faltante] = nula;
		else
			return dp[maximo][faltante] = actual;
	}
	
	public static String resolver(int n)
	{
		Entrada r = dp(320, n);
		if(r == nula)
			return " impossible";
		ArrayList <Piramide> respuesta = new ArrayList <Piramide> ();
		while(r.tam != 0)
		{
			respuesta.add(piramides[r.actual]);
			r = r.siguiente;
		}
		Collections.sort(respuesta);
		String res = "";
		for(Piramide p : respuesta)
			res += " " + p.nombre;
		return res;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		generar();
		int caso = 1;
//		for(int i = 1; i < 10000; i++)
//			if(!solucionar(i).equals(resolver(i)))
//				System.out.println(i);
		while(true)
		{
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				return;
			System.out.println("Case " + caso++ + ":" + solucionar(n));
		}
	}
}
