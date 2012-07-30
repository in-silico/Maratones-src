package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;

@SuppressWarnings("unchecked")
public class doublets
{
	static ArrayList <String> diccionario [] = new ArrayList[16];
	static String diccionario1 [] = new String[25500];
	static Hashtable <Integer, ArrayList <Integer>> doublets = new Hashtable <Integer, ArrayList <Integer>> ();
	static int padres [];
	static int n;
	
	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		n = 0;
		for(int i = 0; i < diccionario.length; i++)
		{
			diccionario[i] = new ArrayList <String> (20);
		}
		while(!(linea = br.readLine()).equals(""))
		{
			diccionario[linea.length() - 1].add(linea);
			diccionario1[n++] = linea;
		}
		Arrays.sort(diccionario1, 0, n);
		int p = 0;
		while((linea = br.readLine()) != null)
		{
			String primero = "", segundo = "";
			try
			{
				primero = linea.split(" ")[0];
				segundo = linea.split(" ")[1];
			}
			catch(Exception e)
			{
				return;
			}
			if(p++ != 0)
				System.out.println();
			if(primero.length() != segundo.length() || Arrays.binarySearch(diccionario1, 0, n, primero) < 0 || Arrays.binarySearch(diccionario1, 0, n, segundo) < 0)
			{
				System.out.println("No solution.");
				continue;
			}
			padres = new int[n];
			boolean visitados [] = new boolean[n];
			LinkedList <Integer> actuales = new LinkedList <Integer> ();
			int posPrimero = Arrays.binarySearch(diccionario1, 0, n, primero);
			int posSegundo = Arrays.binarySearch(diccionario1, 0, n, segundo);
			actuales.add(posPrimero);
			boolean termino = false;
			visitados[posPrimero] = true;
			while(!actuales.isEmpty())
			{
				int actual = actuales.poll();
				if(actual == posSegundo)
				{
					termino = true;
					break;
				}
				if(doublets.get(actual) == null)
				{
					generarHijos(actual);
				}
				for(int i : doublets.get(actual))
				{
					if(!visitados[i])
					{
						visitados[i] = true;
						padres[i] = actual;
						actuales.add(i);
					}
				}
			}
			if(!termino)
			{
				System.out.println("No solution.");
			}
			else
			{
				imprimir(posPrimero, posSegundo);
			}
		}
	}
	

	private static void imprimir(int posPrimero, int posSegundo)
	{
		if(posPrimero == posSegundo)
		{
			System.out.println(diccionario1[posPrimero]);
			return;
		}
		else
		{
			imprimir(posPrimero, padres[posSegundo]);
			System.out.println(diccionario1[posSegundo]);
		}
		
	}

	private static void generarHijos(int actual) 
	{
		String act = diccionario1[actual];
		ArrayList <Integer> hijos = new ArrayList <Integer> (20);
		if(diccionario[act.length() - 1].size() <= act.length() * 26)
		{
			for(String s : diccionario[act.length() - 1])
			{
				if(doublet(s, act))
				{
					hijos.add(Arrays.binarySearch(diccionario1, 0, n, s));
				}
			}
		}
		else
		{
			char arreglo [] = act.toCharArray();
			for(int i = 0; i < arreglo.length; i++)
			{
				char a = arreglo[i];
				for(char j = 'a'; j <= 'z'; j++)
				{
					if(j != i)
					{
						arreglo[i] = j;
						int pos = Arrays.binarySearch(diccionario1, 0, n, new String(arreglo));
						if(pos >= 0)
						{
							hijos.add(pos);
						}
					}
				}
				arreglo[i] = a;
			}
		}
		doublets.put(actual, hijos);
	}

	static boolean doublet(String a, String b)
	{
		if(a.equals(b))
			return false;
		int acum = 0;
		for(int i = 0; i < a.length(); i++)
		{
			if(a.charAt(i) != b.charAt(i))
			{
				if(acum++ > 1)
					return false;
			}
		}
		if(acum == 1)
			return true;
		else
			return false;
	}
}
