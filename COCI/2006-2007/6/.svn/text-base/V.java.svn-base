import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class V 
{
	static boolean[] noProhibidos = new boolean[10];
	
	public static void generar(ArrayList <Integer> lista, int digitos, int actual, long maximo, boolean todos)
	{
		if(actual > maximo)
			return;
		if(digitos == 0)
		{
			if(actual == 0 && lista.isEmpty())
				lista.add(actual);
			else if(actual != 0)
				lista.add(actual);
			return;
		}
		else
		{
			if(!todos)
			{
				if(actual == 0 && lista.isEmpty() && (!todos || noProhibidos[0]))
					lista.add(actual);
				else if(actual != 0)
					lista.add(actual);
			}
			for(int i = 0; i < 10; i++)
				if(noProhibidos[i] && (i != 0 || actual != 0))
					generar(lista, digitos - 1, actual * 10 + i, maximo, todos);
		}
	}
	
	
	public static long contar(long x, long maximo)
	{
		if(x == 1)
			return maximo;
		int tam = (maximo + "").length();
		if(tam == 1)
		{
			if(maximo == 0)
				return 0;
			int cuenta = 0;
			for(int i = (int) x; i <= maximo; i++)
				if(noProhibidos[i] && i % x == 0)
					cuenta++;
			return cuenta;
		}
		else
		{
			int p = (int) (maximo / Math.pow(10, tam - (tam >> 1)));
			ArrayList <Integer> a = new ArrayList <Integer> ();
			generar(a, tam >> 1, 0, p, false);
			ArrayList <Integer> b = new ArrayList <Integer> ();
			generar(b, tam - (tam >> 1), 0, Integer.MAX_VALUE, !noProhibidos[0]);
			HashMap <Long, Integer> veces = new HashMap <Long, Integer> ();
			for(int i : b)
			{
				if(veces.containsKey(i % x))
					veces.put(i % x, veces.get(i % x) + 1);
				else
					veces.put(i % x, 1);
			}
			int cuenta = 0;
			for(int i : a)
			{
				if(i == p)
				{
					long pp = (long) (p * Math.pow(10, tam - (tam >> 1)));
					for(int j : b)
					{
						pp += j;
						if(pp <= maximo && pp % x == 0)
							cuenta++;
						pp -= j;
					}
				}
				else
				{
					long valor = i;
					valor *= Math.pow(10, tam - (tam >> 1));
					if(valor == 0)
					{
						ArrayList <Integer> c = new ArrayList <Integer> ();
						generar(c, tam - (tam >> 1), 0, Integer.MAX_VALUE, false);
						for(int j : c)
						{
							if(j == 0)
								continue;
							if(j % x == 0)
								cuenta++;
						}
						continue;
					}
					long mod = valor % x;
					long buscado = ((x << 1) - mod) % x;
					cuenta += veces.containsKey(buscado) ? veces.get(buscado) : 0;
					if(buscado == 0 && i == 0 && veces.containsKey(buscado) && noProhibidos[0])
						cuenta--;
				}
			}
			return cuenta;
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		long x = sc.nextLong();
		long a = sc.nextLong();
		long b = sc.nextLong();
		for(char c : sc.next().toCharArray())
			noProhibidos[c - '0'] = true;
		System.out.println(contar(x, b) - contar(x, a - 1));
	}
}
