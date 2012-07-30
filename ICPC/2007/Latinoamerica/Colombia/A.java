import java.util.ArrayList;
import java.util.Scanner;


public class A 
{
	static class Letra
	{
		char c;
		Integer asignado;
		boolean noCero = false;
		
		public Letra(char c2) 
		{
			c = c2;
		}
	}
	static class Palabra
	{
		int tam;
		Letra[] letras;
		boolean mas;
		
		public Palabra(int t, boolean m)
		{
			tam = t;
			mas = m;
			letras = new Letra[tam];
		}
	}

	static ArrayList <Palabra> izquierdas = new ArrayList <Palabra> ();
	static ArrayList <Palabra> derechas = new ArrayList <Palabra> ();

	static int maxIzquierda;
	static int maxDerecha;
	static Letra[] todas = new Letra[27];
	static Character[] ocupadas = new Character[10];
	static Letra[] usadas = new Letra[11];
	static int u;
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			for(int i = 0; i < 27; i++)
				todas[i] = null;
			for(int i = 0; i < 10; i++)
				ocupadas[i] = null;
			Scanner interno = new Scanner(sc.nextLine());
			izquierdas.clear();
			maxIzquierda = 0;
			while(true)
			{
				String signo = izquierdas.size() == 0 ? "+" : interno.next();
				if(signo.equals("="))
						break; 
				String s = interno.next();
				Palabra actual = new Palabra(s.length(), signo.equals("+"));
				int i = s.length() - 1;
				for(char c : s.toCharArray())
				{
					if(todas[c - 'A'] == null)
						todas[c - 'A'] = new Letra(c);
					actual.letras[i--] = todas[c - 'A'];
				}
				if(s.length() > 1)
					todas[actual.letras[s.length() - 1].c - 'A'].noCero = true;
				maxIzquierda = Math.max(maxIzquierda, s.length());
				izquierdas.add(actual);
			}
			derechas.clear();
			maxDerecha = 0;
			while(true)
			{
				if(!interno.hasNext())
						break;
				String signo = derechas.size() == 0 ? "+" : interno.next();
				String s = interno.next();
				Palabra actual = new Palabra(s.length(), signo.equals("+"));
				int i = s.length() - 1;
				for(char c : s.toCharArray())
				{
					if(todas[c - 'A'] == null)
						todas[c - 'A'] = new Letra(c);
					actual.letras[i--] = todas[c - 'A'];
				}
				if(s.length() > 1)
					todas[actual.letras[s.length() - 1].c - 'A'].noCero = true;
				maxDerecha = Math.max(maxDerecha, s.length());
				derechas.add(actual);
			}
			u = 0;
			for(Letra l : todas)
			{
				if(l != null)
					usadas[u++] = l;
			}
			backtrack(0, 0, 0, 0);
			for(int i = 0; i < 10; i++)
				if(ocupadas[i] == null)
					System.out.print("*");
				else
					System.out.print(ocupadas[i]);
			System.out.println();
		}
	}
	
	static boolean backtrack(int columna, int palabra, int carryI, int carryD)
	{
		if(palabra == izquierdas.size() + derechas.size())
		{
			int acumI = 0;
			for(Palabra p : izquierdas)
			{
				if(columna < p.tam)
					if(p.mas)
						acumI += p.letras[columna].asignado;
					else
						acumI -= p.letras[columna].asignado;
			}
			acumI += carryI;
			int acumD = 0;
			for(Palabra p : derechas)
			{
				if(columna < p.tam)
					if(p.mas)
						acumD += p.letras[columna].asignado;
					else
						acumD -= p.letras[columna].asignado;
			}
			acumD += carryD;
			int acumModI = acumI < 0 ? (((-acumI / 10) + 1) * 10) + acumI : acumI % 10;
			int acumModD = acumD < 0 ? (((-acumD / 10) + 1) * 10) + acumD : acumD % 10;
			if(acumModI != acumModD)
				return false;
			if(acumI < 0)
				acumI -= 10;
			if(acumD < 0)
				acumD -= 10;
			return backtrack(columna + 1, 0, acumI / 10, acumD / 10);
		}
		if(columna == Math.max(maxDerecha, maxIzquierda))
			return resolver();
		Palabra actual = palabra < izquierdas.size() ? izquierdas.get(palabra) : derechas.get(palabra - izquierdas.size());
		if(actual.tam <= columna || actual.letras[columna].asignado != null)
			if(columna == actual.tam - 1 && actual.tam != 1 && actual.letras[columna].asignado.intValue() == 0)
				return false;
			else
				return backtrack(columna, palabra + 1, carryI, carryD);
		for(int i = 0; i < 10; i++)
		{
			if(ocupadas[i] == null)
			{
				if(i == 0 && columna == actual.tam - 1 && actual.tam != 1)
					continue;
				ocupadas[i] = actual.letras[columna].c;
				actual.letras[columna].asignado = i;
				if(backtrack(columna, palabra + 1, carryI, carryD))
					return true;
				actual.letras[columna].asignado = null;
				ocupadas[i] = null;
			}
		}
		return false;
	}
	
	public static boolean resolver()
	{
		int totalI = 0;
		for(Palabra p : izquierdas)
		{
			int actual = 0;
			int potencia = 1;
			for(int i = 0; i < p.tam; i++)
			{
				actual += p.letras[i].asignado * potencia;
				potencia *= 10;
			}
			if(p.mas)
				totalI += actual;
			else
				totalI -= actual;
		}
		int totalD = 0;
		for(Palabra p : derechas)
		{
			int actual = 0;
			int potencia = 1;
			for(int i = 0; i < p.tam; i++)
			{
				actual += p.letras[i].asignado * potencia;
				potencia *= 10;
			}
			if(p.mas)
				totalD += actual;
			else
				totalD -= actual;
		}
		return totalD == totalI;
	}
}