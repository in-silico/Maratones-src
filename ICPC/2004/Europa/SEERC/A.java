import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;


public class A 
{
	
	static class Entrada
	{
		int p;
		int v;
		
		Entrada(int a)
		{
			p = a;
			v = 1;
		}
	}
	
	static String s;
	
	public static boolean vivo(int a, int desde, int minimo)
	{
		for(int i = minimo + 1; i <= desde; i++)
		{
			if(!s.substring(0, a).equals(s.substring(a * (i -  1), a * (i))))
					return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numero = 1;
		while(true)
		{
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				return;
			System.out.println("Test case #" + numero++);
			s = br.readLine();
			LinkedList<Entrada> vivos = new LinkedList <Entrada> ();
			for(int i = 0; i < n; i++)
			{
				int tam = i + 1;
				ListIterator <Entrada> it = vivos.listIterator();
				while(it.hasNext())
				{
					Entrada actual = it.next();
					if(actual.p > (tam >> 1))
						break;
					if(tam % actual.p == 0)
					{
						if(vivo(actual.p, tam / actual.p, actual.v))
						{
							actual.v = tam / actual.p;
							System.out.println(tam + " " + actual.v);
							break;
						}
						else
						{
							it.remove();
						}
					}
				}
				vivos.add(new Entrada(tam));
			}
			System.out.println();
		}
	}

}
